package com.lushwe.tank.factory;

import com.lushwe.tank.GameModel;
import com.lushwe.tank.enums.Dir;
import com.lushwe.tank.enums.Group;

/**
 * 说明：基础游戏工厂
 *
 * @author Jack Liu
 * @date 2021-1-10 20:27
 * @since 0.1
 */
public interface BaseGameFactory {

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
    BaseTank createTank(int x, int y, Dir dir, Group group, GameModel gm);

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
    BaseBullet createBullet(int x, int y, Dir dir, Group group, GameModel gm);

    /**
     * 创建爆炸
     *
     * @param x
     * @param y
     * @param gm
     * @return
     */
    BaseExplode createExplode(int x, int y, GameModel gm);
}
