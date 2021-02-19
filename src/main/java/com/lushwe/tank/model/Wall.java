package com.lushwe.tank.model;

import com.lushwe.tank.GameModel;
import com.lushwe.tank.GameObject;

import java.awt.*;

/**
 * 说明：基础墙对象
 *
 * @author Jack Liu
 * @date 2021/1/14 下午9:27
 * @since 0.1
 */
public abstract class Wall extends GameObject {

    /**
     * 宽
     */
    protected int w;

    /**
     * 高
     */
    protected int h;

    /**
     * 方块
     */
    protected Rectangle rect;

    public Wall(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.rect = new Rectangle(x, y, w, h);

        GameModel.getInstance().add(this);
    }

    @Override
    public void paint(Graphics g) {
        Color color = g.getColor();
        g.setColor(getColor());
        g.fillRect(x, y, w, h);
        g.setColor(color);
    }

    protected abstract Color getColor();

    public Rectangle getRect() {
        return rect;
    }
}
