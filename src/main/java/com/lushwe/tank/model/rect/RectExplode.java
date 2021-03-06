package com.lushwe.tank.model.rect;

import com.lushwe.tank.GameModel;
import com.lushwe.tank.model.Explode;

import java.awt.*;

/**
 * 说明：方形爆炸
 *
 * @author Jack Liu
 * @date 2021/1/10 下午9:51
 * @since 0.1
 */
public class RectExplode extends Explode {

    private int step = 0;

    public RectExplode(int x, int y) {
        super(x, y);
    }

    @Override
    public void paint(Graphics g) {

        //
        Color color = g.getColor();
        g.setColor(Color.PINK);
        g.fillRect(x, y, 4 * step, 4 * step);
        step++;
        g.setColor(color);

        if (step >= 16) {
            GameModel.getInstance().remove(this);
        }
    }
}
