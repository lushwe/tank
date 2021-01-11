package com.lushwe.tank;

import com.lushwe.tank.enums.Dir;
import com.lushwe.tank.enums.Group;
import com.lushwe.tank.factory.GameFactory;
import com.lushwe.tank.model.Bullet;
import com.lushwe.tank.model.Explode;
import com.lushwe.tank.model.Tank;
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
     * 敌人坦克
     */
    private List<Tank> tankList = new ArrayList<>();

    /**
     * 子弹
     */
    private List<Bullet> bulletList = new ArrayList<>();

    /**
     * 爆炸
     */
    private List<Explode> explodes = new ArrayList<>();

    /**
     * 游戏工厂
     */
    private GameFactory gameFactory;

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
            this.tankList.add(this.gameFactory.createTank(100 + 100 * i, 200, Dir.DOWN, Group.BAD, this));
        }
    }

    public void paint(Graphics g) {

        System.out.println("paint");

        // 画出子弹数量
        Color color = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("子弹数量：" + bulletList.size(), 10, 50);
        g.drawString("敌人数量：" + tankList.size(), 10, 70);
        g.drawString("爆炸数量：" + explodes.size(), 10, 90);
        g.setColor(color);

        // 画坦克
        mainTank.paint(g);

        // 画坦克
        for (int i = 0; i < tankList.size(); i++) {
            tankList.get(i).paint(g);
        }

        // 画子弹
        for (int i = 0; i < bulletList.size(); i++) {
            bulletList.get(i).paint(g);
        }

        // 画爆炸
        for (int i = 0; i < explodes.size(); i++) {
            explodes.get(i).paint(g);
        }

        // 碰撞检测
        for (int i = 0; i < bulletList.size(); i++) {
            for (int j = 0; j < tankList.size(); j++) {
                bulletList.get(i).collideWith(tankList.get(j));
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

    public List<Tank> getTankList() {
        return tankList;
    }

    public List<Bullet> getBulletList() {
        return bulletList;
    }

    public List<Explode> getExplodes() {
        return explodes;
    }

    public GameFactory getGameFactory() {
        return gameFactory;
    }
}
