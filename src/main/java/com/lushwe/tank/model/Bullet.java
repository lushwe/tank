package com.lushwe.tank.model;

import com.lushwe.tank.GameModel;
import com.lushwe.tank.GameObject;
import com.lushwe.tank.enums.Dir;
import com.lushwe.tank.enums.Group;
import com.lushwe.tank.util.ResourceUtils;

import java.awt.*;

/**
 * 说明：基础子弹对象
 *
 * @author Jack Liu
 * @date 2021/1/10 下午8:40
 * @since 0.1
 */
public abstract class Bullet extends GameObject {

    public static int WIDTH = ResourceUtils.bulletD.getWidth();
    public static int HEIGHT = ResourceUtils.bulletD.getHeight();

    /**
     * 方向
     */
    protected Dir dir;

    /**
     * 阵营
     */
    protected Group group;

    /**
     * 矩形
     */
    protected Rectangle rect;

    /**
     * 活着
     */
    protected boolean living = true;

    public Bullet(int x, int y, Dir dir, Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.rect = new Rectangle(x, y, WIDTH, HEIGHT);

        GameModel.getInstance().add(this);
    }

    public Group getGroup() {
        return group;
    }

    public Rectangle getRect() {
        return rect;
    }

    public Dir getDir() {
        return dir;
    }

    /**
     * 死亡
     */
    public void die() {
        living = false;
    }

    /**
     * 是否活着
     *
     * @return
     */
    public boolean isLiving() {
        return living;
    }
}
