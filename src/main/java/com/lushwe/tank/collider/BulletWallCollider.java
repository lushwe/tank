package com.lushwe.tank.collider;

import com.lushwe.tank.GameObject;
import com.lushwe.tank.model.Bullet;
import com.lushwe.tank.model.Wall;

/**
 * 说明：子弹-墙碰撞器
 *
 * @author Jack Liu
 * @date 2021/1/16 下午10:46
 * @since 0.1
 */
public class BulletWallCollider implements Collider {

    @Override
    public boolean collide(GameObject go1, GameObject go2) {
        if (go1 instanceof Bullet && go2 instanceof Wall) {
            return collideWith((Bullet) go1, (Wall) go2);
        } else if (go1 instanceof Wall && go2 instanceof Bullet) {
            return collide(go2, go1);
        }
        return false;
    }

    private boolean collideWith(Bullet bullet, Wall wall) {
        if (bullet.getRect().intersects(wall.getRect())) {
            // 子弹碰到墙，子弹消失
            bullet.die();
        }
        return false;
    }
}
