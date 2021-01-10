package com.lushwe.tank;

import com.lushwe.tank.factory.BaseExplode;
import com.lushwe.tank.util.ResourceUtils;

import java.awt.*;

/**
 * 说明：爆炸对象
 *
 * @author Jack Liu
 * @date 2020-11-17 09:06
 * @since 0.1
 */
public class Explode extends BaseExplode {

    public static int WIDTH = ResourceUtils.explodes[0].getWidth();
    public static int HEIGHT = ResourceUtils.explodes[0].getHeight();

    private int x, y;

    private GameModel gm;

    private int step = 0;

    public Explode(int x, int y, GameModel gm) {
        this.x = x;
        this.y = y;
        this.gm = gm;

        new Thread(() -> new Audio("audio/explode.wav").play()).start();
    }

    @Override
    public void paint(Graphics g) {

        g.drawImage(ResourceUtils.explodes[step++], x, y, null);

        if (step >= ResourceUtils.explodes.length) {
            this.gm.explodes.remove(this);
        }
    }
}
