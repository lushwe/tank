package com.lushwe.tank;

/**
 * 说明：主类
 *
 * @author Jack Liu
 * @date 2020-10-29 20:57
 * @since 0.1
 */
public class Main {

    public static void main(String[] args) throws Exception {

        TankFrame tf = new TankFrame();

        for (int i = 0; i < 5; i++) {
            tf.tankList.add(new Tank(100 + 100 * i, 400, Dir.DOWN, tf));
        }

        while (true) {
            Thread.sleep(100L);
            tf.repaint();
        }
    }
}
