package com.lushwe.tank.model;

import com.lushwe.tank.Audio;
import com.lushwe.tank.GameModel;
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

    public Explode(int x, int y) {
        this.x = x;
        this.y = y;

        new Thread(() -> new Audio("audio/explode.wav").play()).start();

        GameModel.getInstance().add(this);
    }
}
