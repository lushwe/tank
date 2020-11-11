package com.lushwe.tank;

import java.awt.Color;
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
    private static int WIDTH = 30;
    private static int HEIGHT = 30;

    private int x;
    private int y;

    private Dir dir;

    private TankFrame tf;

    private boolean moving = false;

    public Tank(int x, int y, Dir dir, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    /**
     * @param g
     */
    public void paint(Graphics g) {

        Color color = g.getColor();

        g.setColor(Color.YELLOW);
        g.fillRect(x, y, WIDTH, HEIGHT);
        g.setColor(color);

        move();

    }

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
    }

    /**
     * 发射子弹
     */
    public void fire() {
        tf.myBullet = new Bullet(this.x, this.y, this.dir);
    }

    // getter setter
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
