package com.lushwe.tank;

import java.awt.Color;
import java.awt.Graphics;

/**
 * 说明：子弹对象
 *
 * @author Jack Liu
 * @date 2020-11-10 21:00
 * @since 0.1
 */
public class Bullet {

    private static final int SPEED = 10;
    private static int WIDTH = 20;
    private static int HEIGHT = 20;

    private int x;
    private int y;

    private Dir dir;

    private TankFrame tf;

    private boolean live = true;

    public Bullet(int x, int y, Dir dir, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    /**
     * @param g
     */
    public void paint(Graphics g) {
        if (!live) {
            tf.bulletList.remove(this);
        }

        Color color = g.getColor();

        g.setColor(Color.RED);
        g.fillOval(x, y, WIDTH, HEIGHT);
        g.setColor(color);

        move();

    }

    private void move() {

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

        if (x < 0 || y < 0 || x > tf.GAME_WIDTH || y > tf.GAME_HEIGHT) {
            live = false;
        }
    }
}
