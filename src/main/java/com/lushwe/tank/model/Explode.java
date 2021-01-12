package com.lushwe.tank.model;

import com.lushwe.tank.GameObject;
import com.lushwe.tank.util.ResourceUtils;

/**
 * 说明：基础爆炸对象
 *
 * @author Jack Liu
 * @date 2021/1/10 下午8:41
 * @since 0.1
 */
public abstract class Explode extends GameObject {

    public static int WIDTH = ResourceUtils.explodes[0].getWidth();
    public static int HEIGHT = ResourceUtils.explodes[0].getHeight();

}
