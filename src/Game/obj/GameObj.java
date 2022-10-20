package Game.obj;

import java.awt.*;

import Game.GameWin;

//游戏元素父类的编写
public class GameObj {
    Image img;
    int x;
    int y;
    int width;
    int height;
    double speed;
    GameWin frame;//窗口的引用

    public Image getImage()
    {
        return img;
    }

    public void setImg(Image img)
    {
        this.img=img;
    }

    public int getX()
    {
        return x;
    }

    public void setX(int x)
    {
        this.x=x;
    }

    public int getY()
    {
        return y;
    }

    public void setY(int y)
    {
        this.y=y;
    }

    public int getWidth()
    {
        return width;
    }

    public void setWidth(int width)
    {
        this.width=width;
    }

    public int getHeight()
    {
        return height;
    }

    public void setHeight(int height)
    {
        this.height=height;
    }

    public double getSpeed()
    {
        return speed;
    }

    public void setSpeed(double speed)
    {
        this.speed=speed;
    }

    public GameWin getFrame()
    {
        return frame;
    }

    public void setFrame(GameWin frame)
    {
        this.frame=frame;
    }

    //有参无参构造（多做几个运用更灵活）
    public GameObj()
    {

    }

    public GameObj(Image img,int x,int y,double speed)
    {
        this.img=img;
        this.x=x;
        this.y=y;
        this.speed=speed;
    }

    public GameObj(Image img,int x,int y,int width,int height,double speed,GameWin frame) 
    {
        this.img=img;
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
        this.speed=speed;
        this.frame=frame;
    }

    //绘制自身的方法
    public void paintSelf(Graphics gImage)
    {
        gImage.drawImage(img, x, y, null);
    }

    //获取自身矩形的方法
    public Rectangle getRec()
    {
        return new Rectangle(x,y,width,height);
    }


}
