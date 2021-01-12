package com.lushwe.tank.model;

import com.lushwe.tank.GameObject;
import com.lushwe.tank.util.ResourceUtils;

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
     * 碰撞
     *
     * @param tank
     */
    public abstract void collideWith(Tank tank);
}
