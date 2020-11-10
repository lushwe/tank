package com.lushwe.tank;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 说明：坦克大战主页
 *
 * @author Jack Liu
 * @date 2020-10-29 21:11
 * @since 0.1
 */
public class TankFrame extends Frame {

    /**
     * 主站坦克
     */
    Tank myTank = new Tank(200, 200);


    public TankFrame() {
        this.setSize(800, 600);
        this.setResizable(false);
        this.setTitle("tank war");

        this.setVisible(true);

        // 添加键盘监听器
        this.addKeyListener(new TankKeyListener());
        // 添加窗口监听器
        this.addWindowListener(new TankWindowsListener());
    }

    @Override
    public void paint(Graphics g) {

        System.out.println("paint");

        //
        myTank.paint(g);

    }

    /**
     * 键盘监听器
     */
    private class TankKeyListener extends KeyAdapter {

        boolean left = false;
        boolean up = false;
        boolean right = false;
        boolean down = false;

        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    left = true;
                    break;
                case KeyEvent.VK_UP:
                    up = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    right = true;
                    break;
                case KeyEvent.VK_DOWN:
                    down = true;
                    break;
                default:
                    break;
            }

            setMainTankDir();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    left = false;
                    break;
                case KeyEvent.VK_UP:
                    up = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    right = false;
                    break;
                case KeyEvent.VK_DOWN:
                    down = false;
                    break;
                default:
                    break;
            }

            setMainTankDir();
        }

        /**
         * 设置主坦克方向
         */
        private void setMainTankDir() {

            myTank.setMoving(true);

            if (left) {
                myTank.setDir(Dir.LEFT);
            }
            if (up) {
                myTank.setDir(Dir.UP);
            }
            if (right) {
                myTank.setDir(Dir.RIGHT);
            }
            if (down) {
                myTank.setDir(Dir.DOWN);
            }
        }
    }

    /**
     * 窗口监听器
     */
    private class TankWindowsListener extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    }
}
