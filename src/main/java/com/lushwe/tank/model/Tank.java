package com.lushwe.tank.model;

import com.lushwe.tank.GameModel;
import com.lushwe.tank.GameObject;
import com.lushwe.tank.enums.Dir;
import com.lushwe.tank.enums.Group;
import com.lushwe.tank.util.ResourceUtils;

import java.awt.*;

/**
 * 说明：基础坦克对象
 *
 * @author Jack Liu
 * @date 2021/1/10 下午8:40
 * @since 0.1
 */
public abstract class Tank extends GameObject {

    public static int WIDTH = ResourceUtils.goodTankU.getWidth();
    public static int HEIGHT = ResourceUtils.goodTankU.getHeight();

    public abstract int getX();

    public abstract int getY();

    public abstract Dir getDir();

    public abstract void setDir(Dir dir);

    public abstract void setMoving(boolean moving);

    public abstract Group getGroup();

    public abstract GameModel getGm();

    public abstract void die();

    public abstract void fire();

    public abstract Rectangle getRect();

}
