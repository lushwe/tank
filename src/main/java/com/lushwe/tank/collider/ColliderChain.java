package com.lushwe.tank.collider;

import com.lushwe.tank.GameObject;
import com.lushwe.tank.util.PropertyUtils;

import java.util.LinkedList;
import java.util.List;

/**
 * 说明：碰撞器链
 *
 * @author Jack Liu
 * @date 2021/1/14 下午8:01
 * @since 0.1
 */
public class ColliderChain implements Collider {

    /**
     * 碰撞器列表
     */
    private List<Collider> colliders = new LinkedList<>();

    public ColliderChain() {
        String colliderNames = PropertyUtils.getString("colliders");
        String[] colliderNameArr = colliderNames.split(",");
        try {
            for (String colliderName : colliderNameArr) {
                Collider collider = (Collider) Class.forName(colliderName).getDeclaredConstructor().newInstance();
                colliders.add(collider);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean collide(GameObject go1, GameObject go2) {
        for (Collider collider : colliders) {
            if (collider.collide(go1, go2)) {
                return true;
            }
        }
        return false;
    }
}
