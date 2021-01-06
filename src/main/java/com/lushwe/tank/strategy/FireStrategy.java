package com.lushwe.tank.strategy;

import com.lushwe.tank.Tank;

/**
 * 说明：开火策略
 *
 * @author Jack Liu
 * @date 2021-01-02 22:53
 * @since 0.1
 */
public interface FireStrategy {

    /**
     * 开火
     *
     * @param tank
     */
    void fire(Tank tank);
}
