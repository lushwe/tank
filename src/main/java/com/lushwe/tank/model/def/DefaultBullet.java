package com.lushwe.tank.model.def;

import com.lushwe.tank.GameModel;
import com.lushwe.tank.TankFrame;
import com.lushwe.tank.enums.Dir;
import com.lushwe.tank.enums.Group;
import com.lushwe.tank.model.Bullet;
import com.lushwe.tank.util.ResourceUtils;

import java.awt.*;

/**
 * 说明：默认子弹对象
 *
 * @author Jack Liu
 * @date 2020-11-10 21:00
 * @since 0.1
 */
public class DefaultBullet extends Bullet {

    private static final int SPEED = 6;

    Rectangle rect = new Rectangle();

    /**
     * 方向
     */
    private Dir dir;

    /**
     * 阵营
     */
    private Group group;

    /**
     * 游戏模型对象
     */
    private GameModel gm;

    /**
     * 活着
     */
    private boolean living = true;

    public DefaultBullet(int x, int y, Dir dir, Group group, GameModel gm) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.gm = gm;

        rect.x = this.x;
        rect.y = this.y;
        rect.width = WIDTH;
        rect.height = HEIGHT;

        this.gm.add(this);
    }

    /**
     * 画自己
     *
     * @param g
     */
    @Override
    public void paint(Graphics g) {

        if (!living) {
            gm.remove(this);
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
     * 死亡
     */
    public void die() {
        this.living = false;
    }

    public Rectangle getRect() {
        return rect;
    }

    public Dir getDir() {
        return dir;
    }

    @Override
    public Group getGroup() {
        return group;
    }

    @Override
    public GameModel getGm() {
        return gm;
    }

    public boolean isLiving() {
        return living;
    }
}
