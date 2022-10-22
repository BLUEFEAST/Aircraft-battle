package Game.obj;

import Game.GameWin;

import java.awt.*;

public class BossObj extends GameObj{
    public BossObj(Image img, int x, int y, int width, int height, double speed, GameWin frame) {
        super(img, x, y, width, height, speed, frame);
    }
    @Override
    public Image getImg() {
        return super.getImg();
    }

    @Override
    public void paintSelf(Graphics gImage) {
        super.paintSelf(gImage);
        if(x > 480 || x < -15){  //使敌方Boss到边界时会往相反方向走
            speed = -speed;
        }
        x += speed;
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}
