package com.lushwe.tank;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * 说明：子弹对象
 *
 * @author Jack Liu
 * @date 2020-11-10 21:00
 * @since 0.1
 */
public class Bullet {

    private static final int SPEED = 6;

    public static int WIDTH = ResourceMgr.bulletD.getWidth();
    public static int HEIGHT = ResourceMgr.bulletD.getHeight();

    Rectangle rect = new Rectangle();

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
     * 活着
     */
    private boolean living = true;

    public Bullet(int x, int y, Dir dir, Group group, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tf = tf;

        rect.x = this.x;
        rect.y = this.y;
        rect.width = WIDTH;
        rect.height = HEIGHT;
    }

    /**
     * 画自己
     *
     * @param g
     */
    public void paint(Graphics g) {

        if (!living) {
            tf.bulletList.remove(this);
        }

        switch (dir) {
            case LEFT:
                g.drawImage(ResourceMgr.bulletL, x, y, null);
                break;
            case UP:
                g.drawImage(ResourceMgr.bulletU, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.bulletR, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.bulletD, x, y, null);
                break;
        }

        // 移动
        move();

    }

    /**
     * 移动
     */
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

        // 更新 rect
        rect.x = this.x;
        rect.y = this.y;

        if (x < 0 || y < 0 || x > tf.GAME_WIDTH || y > tf.GAME_HEIGHT) {
            // 移出窗口，死亡
            living = false;
        }
    }

    /**
     * 碰撞
     *
     * @param tank
     */
    public void collideWith(Tank tank) {

        if (this.group == tank.getGroup()) {
            return;
        }

        if (this.rect.intersects(tank.rect)) {
            // 子弹死亡
            this.die();
            // 坦克死亡
            tank.die();
            // 添加爆炸
            int x = tank.getX() + Tank.WIDTH / 2 - Explode.WIDTH / 2;
            int y = tank.getY() + Tank.HEIGHT / 2 - Explode.HEIGHT / 2;
            this.tf.explodes.add(new Explode(x, y, this.tf));
        }

    }

    /**
     * 死亡
     */
    private void die() {
        this.living = false;
    }
}
