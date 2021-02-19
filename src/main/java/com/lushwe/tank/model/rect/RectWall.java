package com.lushwe.tank.model.rect;

import com.lushwe.tank.model.Wall;

import java.awt.*;

/**
 * 说明：绿色墙
 *
 * @author Jack Liu
 * @date 2021/1/16 下午10:48
 * @since 0.1
 */
public class RectWall extends Wall {

    public RectWall(int x, int y, int w, int h) {
        super(x, y, w, h);
    }

    @Override
    protected Color getColor() {
        return Color.GREEN;
    }

}
