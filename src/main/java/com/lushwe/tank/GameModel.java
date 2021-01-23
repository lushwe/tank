package com.lushwe.tank;

import com.lushwe.tank.collider.ColliderChain;
import com.lushwe.tank.enums.Dir;
import com.lushwe.tank.enums.Group;
import com.lushwe.tank.factory.GameFactory;
import com.lushwe.tank.model.Tank;
import com.lushwe.tank.model.def.DefaultWall;
import com.lushwe.tank.model.rect.RectWall;
import com.lushwe.tank.util.PropertyUtils;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 说明：游戏模型对象封装
 *
 * @author Jack Liu
 * @date 2020-12-20 22:28
 * @since 0.1
 */
public class GameModel {

    /**
     * 主坦克
     */
    private Tank mainTank;

    /**
     * 游戏对象列表
     */
    private List<GameObject> gameObjects = new ArrayList<>();

    /**
     * 游戏工厂
     */
    private GameFactory gameFactory;

    /**
     * 碰撞器链
     */
    private ColliderChain colliderChain = new ColliderChain();

    public GameModel() {

        // 初始化游戏工厂
        String gameFactoryName = PropertyUtils.getString("gameFactory");
        try {
            gameFactory = (GameFactory) Class.forName(gameFactoryName).getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 初始化我方坦克
        this.mainTank = this.gameFactory.createTank(200, 100, Dir.DOWN, Group.GOOD, this);

        // 初始化敌方坦克
        int initTankCount = PropertyUtils.getInt("initTankCount");
        for (int i = 0; i < initTankCount; i++) {
            this.gameObjects.add(this.gameFactory.createTank(100 + 100 * i, 200, Dir.DOWN, Group.BAD, this));
        }

        // 初始化墙
        add(new DefaultWall(150, 150, 200, 50));
        add(new DefaultWall(600, 150, 200, 50));
        add(new RectWall(300, 500, 50, 200));
        add(new RectWall(600, 500, 50, 200));
    }

    /**
     * 添加对象
     *
     * @param go
     */
    public void add(GameObject go) {
        this.gameObjects.add(go);
    }

    /**
     * 移除对象
     *
     * @param go
     */
    public void remove(GameObject go) {
        this.gameObjects.remove(go);
    }

    public void paint(Graphics g) {

//        System.out.println("paint");

        // 画出子弹数量
//        Color color = g.getColor();
//        g.setColor(Color.WHITE);
//        g.drawString("子弹数量：" + bulletList.size(), 10, 50);
//        g.drawString("敌人数量：" + tankList.size(), 10, 70);
//        g.drawString("爆炸数量：" + explodes.size(), 10, 90);
//        g.setColor(color);

        // 画主坦克
        mainTank.paint(g);

        // 画游戏对象（坦克、子弹、爆炸）
        for (int i = 0; i < gameObjects.size(); i++) {
            gameObjects.get(i).paint(g);
        }

        // 碰撞检测
        for (int i = 0; i < gameObjects.size(); i++) {
            for (int j = i + 1; j < gameObjects.size(); j++) {
                colliderChain.collide(gameObjects.get(i), gameObjects.get(j));
            }
        }
    }

    /**
     * 获取主坦克
     *
     * @return
     */
    public Tank getMainTank() {
        return mainTank;
    }

    public GameFactory getGameFactory() {
        return gameFactory;
    }
}
