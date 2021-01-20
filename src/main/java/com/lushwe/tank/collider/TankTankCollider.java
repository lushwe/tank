package com.lushwe.tank.collider;

import com.lushwe.tank.GameObject;
import com.lushwe.tank.model.Tank;

/**
 * 说明：坦克-坦克碰撞
 *
 * @author Jack Liu
 * @date 2021/1/12 下午11:12
 * @since 0.1
 */
public class TankTankCollider implements Collider {

    @Override
    public boolean collide(GameObject go1, GameObject go2) {
        if (go1 instanceof Tank && go2 instanceof Tank) {
            return collideWith((Tank) go1, (Tank) go2);
        }
        return false;
    }

    private boolean collideWith(Tank tank1, Tank tank2) {
        if (tank1.getRect().intersects(tank2.getRect())) {
            // 返回上一个位置
            tank1.back();
            tank2.back();
        }
        return false;
    }
}
