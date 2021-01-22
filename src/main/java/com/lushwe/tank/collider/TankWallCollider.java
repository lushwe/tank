package com.lushwe.tank.collider;

import com.lushwe.tank.GameObject;
import com.lushwe.tank.model.Tank;
import com.lushwe.tank.model.Wall;

/**
 * 说明：坦克-墙碰撞
 *
 * @author Jack Liu
 * @date 2021/1/16 下午10:45
 * @since 0.1
 */
public class TankWallCollider implements Collider {

    @Override
    public boolean collide(GameObject go1, GameObject go2) {
        if (go1 instanceof Tank && go2 instanceof Wall) {
            return collideWith((Tank) go1, (Wall) go2);
        } else if (go1 instanceof Wall && go2 instanceof Tank) {
            return collide(go2, go1);
        }
        return false;
    }

    private boolean collideWith(Tank tank, Wall wall) {
        if (tank.getRect().intersects(wall.getRect())) {
            // 坦克碰到墙，子弹返回
            tank.back();
        }
        return false;
    }
}
