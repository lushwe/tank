package com.lushwe.tank;

import java.awt.Graphics;
import java.util.Random;

/**
 * 说明：坦克对象
 *
 * @author Jack Liu
 * @date 2020-11-10 20:32
 * @since 0.1
 */
public class Tank {

    private static final int SPEED = 2;

    public static int WIDTH = ResourceMgr.goodTankU.getWidth();
    public static int HEIGHT = ResourceMgr.goodTankU.getHeight();


    private int x;
    private int y;

    /**
     * 方向
     */
    private Dir dir;

    /**
     * 阵营
     */
    private Group group;

    /**
     * 窗口
     */
    private TankFrame tf;

    /**
     * 移动中
     */
    private boolean moving = true;

    /**
     * 活着
     */
    private boolean living = true;

    /**
     * 随机变量
     */
    private Random random = new Random();

    public Tank(int x, int y, Dir dir, Group group, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tf = tf;
    }

    /**
     * 画自己
     *
     * @param g
     */
    public void paint(Graphics g) {

        if (!living) {
            tf.tankList.remove(this);
        }

        switch (dir) {
            case LEFT:
                g.drawImage(isGoodGroup() ? ResourceMgr.goodTankL : ResourceMgr.badTankL, x, y, null);
                break;
            case UP:
                g.drawImage(isGoodGroup() ? ResourceMgr.goodTankU : ResourceMgr.badTankU, x, y, null);
                break;
            case RIGHT:
                g.drawImage(isGoodGroup() ? ResourceMgr.goodTankR : ResourceMgr.badTankR, x, y, null);
                break;
            case DOWN:
                g.drawImage(isGoodGroup() ? ResourceMgr.goodTankD : ResourceMgr.badTankD, x, y, null);
                break;
        }

        // 移动
        move();

    }

    /**
     * 是否我方坦克
     *
     * @return
     */
    private boolean isGoodGroup() {
        return this.group == Group.GOOD;
    }

    /**
     * 移动
     */
    private void move() {

        if (!moving) {
            return;
        }

        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
        }

        // 坦克随机开火
        if (this.group == Group.BAD && random.nextInt(100) > 95) {
            this.fire();
        }
        if (this.group == Group.BAD && random.nextInt(100) > 95) {
            randomDir();
        }

        // 边界检查
        boundsCheck();
    }

    /**
     * 边界检查
     */
    private void boundsCheck() {
        if (this.x < 2) {
            x = 2;
        }
        if (this.y < 28) {
            y = 28;
        }
        if (this.x > TankFrame.GAME_WIDTH - Tank.WIDTH - 2) {
            x = TankFrame.GAME_WIDTH - Tank.WIDTH - 2;
        }
        if (this.y > TankFrame.GAME_HEIGHT - Tank.HEIGHT - 2) {
            y = TankFrame.GAME_HEIGHT - Tank.HEIGHT - 2;
        }
    }

    /**
     * 随机移动
     */
    private void randomDir() {
        this.dir = Dir.values()[random.nextInt(4)];
    }

    /**
     * 发射子弹
     */
    public void fire() {

        int x = this.x + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int y = this.y + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;

        tf.bulletList.add(new Bullet(x, y, this.dir, this.group, this.tf));

        if (this.group == Group.GOOD) {
            new Thread(() -> new Audio("audio/tank_fire.wav").play()).start();
        }
    }

    /**
     * 死亡
     */
    public void die() {
        this.living = false;
    }

    // =========================== getter/setter method ===========================
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

}
