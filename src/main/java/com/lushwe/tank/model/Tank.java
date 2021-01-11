package com.lushwe.tank.factory;

import com.lushwe.tank.GameModel;
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
public interface Tank {

    int WIDTH = ResourceUtils.goodTankU.getWidth();
    int HEIGHT = ResourceUtils.goodTankU.getHeight();

    int getX();

    int getY();

    Dir getDir();

    void setDir(Dir dir);

    void setMoving(boolean moving);

    Group getGroup();

    GameModel getGm();

    void die();

    void fire();

    Rectangle getRect();

    /**
     * 画自己
     *
     * @param g
     */
    void paint(Graphics g);
}
