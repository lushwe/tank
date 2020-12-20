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

        new Thread(() -> new Audio("audio/war1.wav").loop()).start();

        while (true) {
            Thread.sleep(25L);
            tf.repaint();
        }
    }
}
