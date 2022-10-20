package Game.obj;

import java.awt.Graphics;
import java.awt.Image;

//实现背景的移动
public class BgObj extends GameObj {
    public BgObj() {
        super();
    }

    public BgObj(Image img, int x, int y, double speed) {
        super(img, x, y, speed);
    }

    @Override
    public void paintSelf(Graphics gImage) {
        super.paintSelf(gImage);
        y += speed;// 加上背景移动的速度之后所显示的背景图片的纵位置
        // 为了解决图片走完后黑屏的问题，设置图片的循环播放
        // 也就是当图片走完y=0的时候，再次将y复原为初始位置重复走
        if (y >= 32) {
            y = -210;
        }
    }

}
