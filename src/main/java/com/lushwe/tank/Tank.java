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

    private static final int SPEED = 10;

    private int x;
    private int y;

    private Dir dir = Dir.DOWN;

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Tank(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    /**
     * @param g
     */
    public void paint(Graphics g) {
        // 画一个矩形
        g.fillRect(x, y, 50, 50);

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
}
