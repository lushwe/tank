package com.lushwe.tank.model.def;

import com.lushwe.tank.model.Wall;

import java.awt.*;

/**
 * 说明：默认墙
 *
 * @author Jack Liu
 * @date 2021/1/16 下午10:42
 * @since 0.1
 */
public class DefaultWall extends Wall {

    public DefaultWall(int x, int y, int w, int h) {
        super(x, y, w, h);
    }

    @Override
    protected Color getColor() {
        return Color.DARK_GRAY;
    }
}
