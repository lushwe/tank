package com.lushwe.tank.strategy;

import com.lushwe.tank.Audio;
import com.lushwe.tank.Bullet;
import com.lushwe.tank.Tank;
import com.lushwe.tank.enums.Dir;
import com.lushwe.tank.enums.Group;

/**
 * 说明：四个方向开火策略
 *
 * @author Jack Liu
 * @date 2021-01-02 22:54
 * @since 0.1
 */
public class FourDirFireStrategy implements FireStrategy {

    @Override
    public void fire(Tank tank) {

        int x = tank.getX() + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int y = tank.getY() + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;


        for (Dir dir : Dir.values()) {
            new Bullet(x, y, dir, tank.getGroup(), tank.getGm());
        }

        if (tank.getGroup() == Group.GOOD) {
            new Thread(() -> new Audio("audio/tank_fire.wav").play()).start();
        }
    }
}
