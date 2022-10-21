package Game.obj;

import Game.GameWin;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
//import java.awt.event.MouseMotionListener;

public class PlaneObj extends GameObj {
    @Override
    public Image getImg() {
        return super.getImg();
    }

    public PlaneObj() {
        super();
    }

    public PlaneObj(Image img, int x, int y, int width, int height, double speed, GameWin frame) {
        super(img, x, y, width, height, speed, frame);
        this.frame.addMouseMotionListener(new MouseAdapter() {  // 鼠标控制
            @Override
            public void mouseMoved(MouseEvent e){
//                PlaneObj.super.x = e.getX() - 11;
//                PlaneObj.super.y = e.getY() - 16;
                PlaneObj.super.x = e.getX() - 65;
                PlaneObj.super.y = e.getY() - 60;
            }
        });
    }

    @Override
    public void paintSelf(Graphics gImage) {
        super.paintSelf(gImage);
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}