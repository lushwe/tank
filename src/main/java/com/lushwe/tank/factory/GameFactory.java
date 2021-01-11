package com.lushwe.tank.factory;

import com.lushwe.tank.model.Bullet;
import com.lushwe.tank.model.Explode;
import com.lushwe.tank.GameModel;
import com.lushwe.tank.model.Tank;
import com.lushwe.tank.enums.Dir;
import com.lushwe.tank.enums.Group;

/**
 * 说明：基础游戏工厂
 *
 * @author Jack Liu
 * @date 2021-1-10 20:27
 * @since 0.1
 */
public interface GameFactory {

    /**
     * 创建坦克
     *
     * @param x
     * @param y
     * @param dir
     * @param group
     * @param gm
     * @return
     */
    Tank createTank(int x, int y, Dir dir, Group group, GameModel gm);

    /**
     * 创建子弹
     *
     * @param x
     * @param y
     * @param dir
     * @param group
     * @param gm
     * @return
     */
    Bullet createBullet(int x, int y, Dir dir, Group group, GameModel gm);

    /**
     * 创建爆炸
     *
     * @param x
     * @param y
     * @param gm
     * @return
     */
    Explode createExplode(int x, int y, GameModel gm);
}
