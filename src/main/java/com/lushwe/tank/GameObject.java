package com.lushwe.tank;

import java.awt.*;

/**
 * 说明：游戏对象
 *
 * @author Jack Liu
 * @date 2021/1/11 下午10:24
 * @since 0.1
 */
public abstract class GameObject {

    protected int x;

    protected int y;

    public abstract void paint(Graphics g);
}
