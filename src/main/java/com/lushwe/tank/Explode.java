package com.lushwe.tank;

import java.awt.Graphics;

/**
 * 说明：爆炸对象
 *
 * @author Jack Liu
 * @date 2020-11-17 09:06
 * @since 0.1
 */
public class Explode {

    public static int WIDTH = ResourceMgr.explodes[0].getWidth();
    public static int HEIGHT = ResourceMgr.explodes[0].getHeight();

    private int x, y;

    private GameModel gm;

    private int step = 0;

    public Explode(int x, int y, GameModel gm) {
        this.x = x;
        this.y = y;
        this.gm = gm;

        new Thread(() -> new Audio("audio/explode.wav").play()).start();
    }

    public void paint(Graphics g) {

        g.drawImage(ResourceMgr.explodes[step++], x, y, null);

        if (step >= ResourceMgr.explodes.length) {
            this.gm.explodes.remove(this);
        }
    }
}
