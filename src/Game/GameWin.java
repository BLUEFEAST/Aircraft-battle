package Game;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import Game.obj.BgObj;
import Game.utils.GameUtils;
public class GameWin extends JFrame
{

    //游戏状态：0未开始 1游戏中 2暂停 3通关失败 4通关成功
    static int state=0;//默认状态


    Image offScreenImage=null;
    int width=600;
    int height=600;

    //在窗口获取背景图对象
    BgObj bgObj=new BgObj(GameUtils.bgImg,0,-360,3);

    public void launch()
    {
        //设置窗口是否可见
        this.setVisible(true);
        //设置窗口大小
        this.setSize(width,height);
        //设置窗口位置
        this.setLocationRelativeTo(null);
        //设置窗口标题
        this.setTitle("飞机大作战");

        //鼠标左键点击启动游戏，文字消失
        this.addMouseListener(new MouseAdapter() 
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                //getButton()==1为鼠标左键，state==0为游戏未开始状态
                if(e.getButton()==1&&state==0)
                {
                    state=1;
                    repaint();//重新调用paint方法
                }
            }
        });
        //随着背景图的移动重复调用paint方法
        while (true)
        {
            repaint();
            try
            {
                Thread.sleep(30);
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args)
    {
        GameWin gameWin=new GameWin();
        gameWin.launch();

    }

    @Override
    public void paint(Graphics g)
    {
        if(offScreenImage==null)
        {
            offScreenImage=createImage(width,height);
        }

        //获取offScreenImage的画笔对象
        Graphics gImage=offScreenImage.getGraphics();
        gImage.fillRect(0,0,width,height);

        if(state==0)
        {
            gImage.drawImage(GameUtils.bgImg,0, 0,null);
            gImage.drawImage(GameUtils.bossImg,220, 120,null);
            gImage.drawImage(GameUtils.explodeImg,270, 350,null);
            gImage.setFont(new Font("仿宋",Font.BOLD,40));
            gImage.drawString("点击开始游戏", 180,300);
        }

        if(state==1)
        {
            bgObj.paintSelf(gImage);
            
        }
        g.drawImage(offScreenImage, 0,0,null);
    }
}
