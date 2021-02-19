package com.lushwe.tank.factory;

import com.lushwe.tank.enums.Dir;
import com.lushwe.tank.enums.Group;
import com.lushwe.tank.model.Bullet;
import com.lushwe.tank.model.Explode;
import com.lushwe.tank.model.Tank;
import com.lushwe.tank.model.def.DefaultBullet;
import com.lushwe.tank.model.def.DefaultExplode;
import com.lushwe.tank.model.def.DefaultTank;

/**
 * 说明：默认游戏工厂
 *
 * @author Jack Liu
 * @date 2021/1/10 下午8:43
 * @since 0.1
 */
public class DefaultGameFactory implements GameFactory {

    @Override
    public Tank createTank(int x, int y, Dir dir, Group group) {
        return new DefaultTank(x, y, dir, group);
    }

    @Override
    public Bullet createBullet(int x, int y, Dir dir, Group group) {
        return new DefaultBullet(x, y, dir, group);
    }

    @Override
    public Explode createExplode(int x, int y) {
        return new DefaultExplode(x, y);
    }
}
