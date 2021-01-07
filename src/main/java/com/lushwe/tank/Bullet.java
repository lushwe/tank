package com.lushwe.tank;

import com.lushwe.tank.enums.Dir;
import com.lushwe.tank.enums.Group;
import com.lushwe.tank.util.ResourceUtils;

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

    public static int WIDTH = ResourceUtils.bulletD.getWidth();
    public static int HEIGHT = ResourceUtils.bulletD.getHeight();

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

    private GameModel gm;

    /**
     * 活着
     */
    private boolean living = true;

    public Bullet(int x, int y, Dir dir, Group group, GameModel gm) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.gm = gm;

        rect.x = this.x;
        rect.y = this.y;
        rect.width = WIDTH;
        rect.height = HEIGHT;

        this.gm.bulletList.add(this);
    }

    /**
     * 画自己
     *
     * @param g
     */
    public void paint(Graphics g) {

        if (!living) {
            gm.bulletList.remove(this);
        }

        switch (dir) {
            case LEFT:
                g.drawImage(ResourceUtils.bulletL, x, y, null);
                break;
            case UP:
                g.drawImage(ResourceUtils.bulletU, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceUtils.bulletR, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceUtils.bulletD, x, y, null);
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

        if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) {
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
            this.gm.explodes.add(new Explode(x, y, this.gm));
        }

    }

    /**
     * 死亡
     */
    private void die() {
        this.living = false;
    }
}
