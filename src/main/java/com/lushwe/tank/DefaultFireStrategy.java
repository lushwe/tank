package com.lushwe.tank;

import com.lushwe.tank.enums.Group;

/**
 * 说明：默认开火策略
 *
 * @author Jack Liu
 * @date 2021-01-02 22:54
 * @since 0.1
 */
public class DefaultFireStrategy implements FireStrategy {

    @Override
    public void fire(Tank tank) {

        int x = tank.getX() + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int y = tank.getY() + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;

        new Bullet(x, y, tank.getDir(), tank.getGroup(), tank.getGm());

        if (tank.getGroup() == Group.GOOD) {
            new Thread(() -> new Audio("audio/tank_fire.wav").play()).start();
        }
    }
}
