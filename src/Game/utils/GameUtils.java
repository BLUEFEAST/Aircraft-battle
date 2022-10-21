package Game.utils;

import Game.obj.EnemyObj;
import Game.obj.GameObj;
import Game.obj.ShellObj;

//import javax.tools.Tool;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameUtils {
    // 背景图片
    public static Image bgImg = Toolkit.getDefaultToolkit().getImage("imgs/background.png");
    // 敌机boss图片
    public static Image bossImg = Toolkit.getDefaultToolkit().getImage("imgs/plane_boss/aircraft_boss.png");
    // 爆炸图片
    public static Image explodeImg = Toolkit.getDefaultToolkit().getImage("imgs/explode/aircraft_explode_1.gif");
    //我方飞机图片
    public static Image planeImg = Toolkit.getDefaultToolkit().getImage("imgs/plane/aircraft_1.png");
    //我方子弹图片
    public static Image shellImg = Toolkit.getDefaultToolkit().getImage("imgs/shell/missile_2.png");
    //小敌机图片
    public static Image enemyImg = Toolkit.getDefaultToolkit().getImage("imgs/plane_boss/aircraft_small_boss.png");
    //所有游戏物体的集合
    public static List<GameObj> gameObjList = new ArrayList<>();
    //要删除元素的集合
    public static List<GameObj> removeList = new ArrayList<>();
    //我方子弹的集合
    public static List<ShellObj> shellObjList = new ArrayList<>();
    //敌机的集合
    public static List<EnemyObj> enemyObjList = new ArrayList<>();
}
