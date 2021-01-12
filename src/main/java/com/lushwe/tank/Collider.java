package com.lushwe.tank;

/**
 * 说明：碰撞接口
 *
 * @author Jack Liu
 * @date 2021/1/12 下午11:11
 * @since 0.1
 */
public interface Collider {

    /**
     * 碰撞
     *
     * @param go1
     * @param go2
     */
    void collide(GameObject go1, GameObject go2);
}
