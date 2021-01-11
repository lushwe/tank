package com.lushwe.tank.factory;

import com.lushwe.tank.util.ResourceUtils;

import java.awt.*;

/**
 * 说明：基础子弹对象
 *
 * @author Jack Liu
 * @date 2021/1/10 下午8:40
 * @since 0.1
 */
public interface Bullet {

    int WIDTH = ResourceUtils.bulletD.getWidth();
    int HEIGHT = ResourceUtils.bulletD.getHeight();

    /**
     * 画自己
     *
     * @param g
     */
    void paint(Graphics g);

    /**
     * 碰撞
     *
     * @param tank
     */
    void collideWith(Tank tank);
}
