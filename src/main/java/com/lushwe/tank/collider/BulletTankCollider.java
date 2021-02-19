package com.lushwe.tank.collider;

import com.lushwe.tank.GameModel;
import com.lushwe.tank.GameObject;
import com.lushwe.tank.model.Bullet;
import com.lushwe.tank.model.Tank;
import com.lushwe.tank.model.def.DefaultExplode;
import com.lushwe.tank.model.def.DefaultTank;

/**
 * 说明：子弹-坦克碰撞
 *
 * @author Jack Liu
 * @date 2021/1/12 下午11:12
 * @since 0.1
 */
public class BulletTankCollider implements Collider {

    @Override
    public boolean collide(GameObject go1, GameObject go2) {
        if (go1 instanceof Bullet && go2 instanceof Tank) {
            return collideWith((Bullet) go1, (Tank) go2);
        } else if (go1 instanceof Tank && go2 instanceof Bullet) {
            return collide(go2, go1);
        }
        return false;
    }

    private boolean collideWith(Bullet bullet, Tank tank) {
        if (bullet.getGroup() == tank.getGroup()) {
            return false;
        }
        if (bullet.getRect().intersects(tank.getRect())) {
            // 子弹死亡
            bullet.die();
            // 坦克死亡
            tank.die();
            // 添加爆炸
            int x = tank.getX() + DefaultTank.WIDTH / 2 - DefaultExplode.WIDTH / 2;
            int y = tank.getY() + DefaultTank.HEIGHT / 2 - DefaultExplode.HEIGHT / 2;
            GameModel.getInstance().getGameFactory().createExplode(x, y);
            return true;
        }
        return false;
    }
}
