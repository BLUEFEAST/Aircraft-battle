package Game.obj;

import Game.GameWin;
import Game.utils.GameUtils;
//import jdk.nashorn.tools.Shell;

import java.awt.*;

public class EnemyObj extends GameObj{
    public EnemyObj() {
        super();
    }

    @Override
    public Image getImg() {
        return super.getImg();
    }

    public EnemyObj(Image img, int x, int y, int width, int height, double speed, GameWin frame) {
        super(img, x, y, width, height, speed, frame);
    }

    @Override
    public void paintSelf(Graphics gImage) {
        super.paintSelf(gImage);
        y += speed;
        //敌我飞机碰撞检测
        if(this.getRec().intersects(this.frame.planeObj.getRec())){
            GameWin.state = 3;
        }
        //与所有的敌机对象一一检测碰撞，矩形是否重叠
        //敌机消失前移动到(-200,200)  我方子弹(-100,100)
        for(ShellObj shellObj : GameUtils.shellObjList){
            if(this.getRec().intersects(shellObj.getRec())){  //已经碰撞了
                shellObj.setX(-100);
                shellObj.setY(100);
                this.x = -200;
                this.y = 200;
                GameUtils.removeList.add(shellObj);
                GameUtils.removeList.add(this);
            }
        }
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}
