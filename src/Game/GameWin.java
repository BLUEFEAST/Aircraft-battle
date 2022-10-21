package Game;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import Game.obj.*;
import Game.utils.GameUtils;

public class GameWin extends JFrame {
    // 游戏状态：0未开始 1游戏中 2暂停 3通关失败 4通关成功
    public static int state = 0;
    //双缓存的图片
    Image offScreenImage = null;
    //窗口的宽度
    int width = 600;
    //窗口的高度
    int height = 600;
    //游戏的重绘次数
    int count = 1;

    // 背景图对象
    BgObj bgObj = new BgObj(GameUtils.bgImg, 0, -360, 3);

    //我方战斗机对象
    public PlaneObj planeObj = new PlaneObj(GameUtils.planeImg, 290, 550, 128, 128, 0, this);

    //敌方Boss对象
    public BossObj bossObj = new BossObj(GameUtils.bossImg,250,35,128,128,5,this);

    //启动方法
    public void launch() {
        // 设置窗口是否可见
        this.setVisible(true);
        // 设置窗口大小
        this.setSize(width, height);
        // 设置窗口位置
        this.setLocationRelativeTo(null);
        // 设置窗口标题
        this.setTitle("飞机大作战");

        GameUtils.gameObjList.add(bgObj);
        GameUtils.gameObjList.add(planeObj);
        GameUtils.gameObjList.add(bossObj);

        // 鼠标左键点击启动游戏，文字消失
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // getButton()==1为鼠标左键，state==0为游戏未开始状态
                if (e.getButton() == 1 && state == 0) {
                    state = 1;
                    repaint();// 重新调用paint方法
                }
            }
        });

        // 重复绘制
        while (true) {
            if(state == 1){  //游戏只有在运行时才不断产生子弹和敌机
                createObj();
                repaint();
            }
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        // 初始化对象
        if (offScreenImage == null) {
            offScreenImage = createImage(width, height);
        }

        // 获取offScreenImage的画笔对象
        Graphics gImage = offScreenImage.getGraphics();
        // 用gImage填充画布
        gImage.fillRect(0, 0, width, height);

        if (state == 0) {  //游戏未开始
            gImage.drawImage(GameUtils.bgImg, 0, 0, null);
            gImage.drawImage(GameUtils.bossImg, 220, 120, null);
            gImage.drawImage(GameUtils.explodeImg, 270, 350, null);
            //gImage.setColor(Color.yellow);
            gImage.setFont(new Font("仿宋", Font.BOLD, 40));
            gImage.drawString("点击开始游戏", 180, 300);
        }

        if (state == 1) {  //游戏运行中
            for(int i = 0; i < GameUtils.gameObjList.size(); ++i){
                GameUtils.gameObjList.get(i).paintSelf(gImage);
            }
            GameUtils.gameObjList.removeAll(GameUtils.removeList);
        }
        if (state == 3) {  //游戏失败
            gImage.drawImage(GameUtils.explodeImg, planeObj.getX()-35, planeObj.getY()-50, null);
            gImage.setColor(Color.RED);
            gImage.setFont(new Font("仿宋", Font.BOLD, 40));
            gImage.drawString("GAME OVER", 180, 300);
        }

        // 把新图片一次性绘制到主窗口，解决游戏未开始时文字图片闪动问题
        g.drawImage(offScreenImage, 0, 0, null);
        count++;
    }

    void createObj(){
        //我方子弹
        if(count % 15 == 0){  // 每调用15次paint方法才生成一颗子弹
            GameUtils.shellObjList.add(new ShellObj(GameUtils.shellImg, planeObj.getX()+60, planeObj.getY()-30,9,21,5,this));
            GameUtils.gameObjList.add(GameUtils.shellObjList.get(GameUtils.shellObjList.size()-1));
        }

        if(count % 15 == 0){
            GameUtils.enemyObjList.add(new EnemyObj(GameUtils.enemyImg, (int)(Math.random()*12)*50, 0, 64, 64, 5,this));
            GameUtils.gameObjList.add(GameUtils.enemyObjList.get(GameUtils.enemyObjList.size()-1));
        }
    }

    public static void main(String[] args) {
        GameWin gameWin = new GameWin();
        gameWin.launch();

    }
}
