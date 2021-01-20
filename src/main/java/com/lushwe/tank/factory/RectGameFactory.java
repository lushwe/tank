package com.lushwe.tank.factory;

import com.lushwe.tank.GameModel;
import com.lushwe.tank.enums.Dir;
import com.lushwe.tank.enums.Group;
import com.lushwe.tank.model.Bullet;
import com.lushwe.tank.model.Explode;
import com.lushwe.tank.model.Tank;
import com.lushwe.tank.model.rect.RectBullet;
import com.lushwe.tank.model.rect.RectExplode;
import com.lushwe.tank.model.rect.RectTank;

/**
 * 说明：方形游戏工厂
 *
 * @author Jack Liu
 * @date 2021/1/10 下午9:52
 * @since 0.1
 */
public class RectGameFactory implements GameFactory {

    @Override
    public Tank createTank(int x, int y, Dir dir, Group group, GameModel gm) {
        return new RectTank(x, y, dir, group, gm);
    }

    @Override
    public Bullet createBullet(int x, int y, Dir dir, Group group, GameModel gm) {
        return new RectBullet(x, y, dir, group, gm);
    }

    @Override
    public Explode createExplode(int x, int y, GameModel gm) {
        return new RectExplode(x, y, gm);
    }
}
