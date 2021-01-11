package com.lushwe.tank.model;

import com.lushwe.tank.util.ResourceUtils;

import java.awt.*;

/**
 * 说明：基础爆炸对象
 *
 * @author Jack Liu
 * @date 2021/1/10 下午8:41
 * @since 0.1
 */
public interface Explode {

    int WIDTH = ResourceUtils.explodes[0].getWidth();
    int HEIGHT = ResourceUtils.explodes[0].getHeight();

    /**
     * 画自己
     *
     * @param g
     */
    void paint(Graphics g);
}
