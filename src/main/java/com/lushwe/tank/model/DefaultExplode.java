package com.lushwe.tank.factory.def;

import com.lushwe.tank.Audio;
import com.lushwe.tank.GameModel;
import com.lushwe.tank.factory.Explode;
import com.lushwe.tank.util.ResourceUtils;

import java.awt.*;

/**
 * 说明：爆炸对象
 *
 * @author Jack Liu
 * @date 2020-11-17 09:06
 * @since 0.1
 */
public class DefaultExplode implements Explode {

    private int x, y;

    private GameModel gm;

    private int step = 0;

    public DefaultExplode(int x, int y, GameModel gm) {
        this.x = x;
        this.y = y;
        this.gm = gm;

        new Thread(() -> new Audio("audio/explode.wav").play()).start();
    }

    @Override
    public void paint(Graphics g) {

        g.drawImage(ResourceUtils.explodes[step++], x, y, null);

        if (step >= ResourceUtils.explodes.length) {
            this.gm.getExplodes().remove(this);
        }
    }
}