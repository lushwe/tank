package com.lushwe.tank;

import com.lushwe.tank.model.Tank;

/**
 * 说明：子弹坦克碰撞
 *
 * @author Jack Liu
 * @date 2021/1/12 下午11:12
 * @since 0.1
 */
public class TankTankCollider implements Collider {

    @Override
    public void collide(GameObject go1, GameObject go2) {
        if (go1 instanceof Tank && go2 instanceof Tank) {
            collideWith((Tank) go1, (Tank) go2);
        }
    }

    private void collideWith(Tank tank1, Tank tank2) {
        if (tank1.getRect().intersects(tank2.getRect())) {
            // 反向移动
            tank1.setDir(tank1.getReverseDir());
            // 反向移动
            tank2.setDir(tank2.getReverseDir());
        }
    }
}
