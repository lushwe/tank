package com.lushwe.tank;

import java.awt.Graphics;

/**
 * 说明：坦克对象
 *
 * @author Jack Liu
 * @date 2020-11-10 20:32
 * @since 0.1
 */
public class Tank {

    private static final int SPEED = 5;

    public static int WIDTH = ResourceMgr.tankD.getWidth();
    public static int HEIGHT = ResourceMgr.tankD.getHeight();


    private int x;
    private int y;

    private Dir dir;

    private TankFrame tf;

    /**
     * 移动中
     */
    private boolean moving = false;

    /**
     * 活着
     */
    private boolean living = true;

    public Tank(int x, int y, Dir dir, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
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
                g.drawImage(ResourceMgr.tankL, x, y, null);
                break;
            case UP:
                g.drawImage(ResourceMgr.tankU, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.tankR, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.tankD, x, y, null);
                break;
        }

        // 移动
        move();

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

//        if (x < 0 || y < 0 || x > tf.GAME_WIDTH || y > tf.GAME_HEIGHT) {
//            // 移出窗口，死亡
//            living = false;
//        }
    }

    /**
     * 发射子弹
     */
    public void fire() {

        int x = this.x + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int y = this.y + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;

        tf.bulletList.add(new Bullet(x, y, this.dir, this.tf));
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

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

}
