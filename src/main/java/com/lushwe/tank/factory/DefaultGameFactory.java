package com.lushwe.tank.factory;

import com.lushwe.tank.Bullet;
import com.lushwe.tank.Explode;
import com.lushwe.tank.GameModel;
import com.lushwe.tank.Tank;
import com.lushwe.tank.enums.Dir;
import com.lushwe.tank.enums.Group;

/**
 * 说明：默认游戏工厂
 *
 * @author Jack Liu
 * @date 2021/1/10 下午8:43
 * @since 0.1
 */
public class DefaultGameFactory extends BaseGameFactory {

    @Override
    public BaseTank createTank(int x, int y, Dir dir, Group group, GameModel gm) {
        return new Tank(x, y, dir, group, gm);
    }

    @Override
    public BaseBullet createBullet(int x, int y, Dir dir, Group group, GameModel gm) {
        return new Bullet(x, y, dir, group, gm);
    }

    @Override
    public BaseExplode createExplode(int x, int y, GameModel gm) {
        return new Explode(x, y, gm);
    }
}
