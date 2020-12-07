package com.lushwe.tank.net;

/**
 * 说明：坦克消息对象
 *
 * @author Jack Liu
 * @date 2020-12-07 22:16
 * @since 0.1
 */
public class TankMsg {
    public int x, y;

    public TankMsg(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "TankMsg:" + x + "," + y;
    }
}
