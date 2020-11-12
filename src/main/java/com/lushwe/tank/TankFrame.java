package com.lushwe.tank;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * 说明：坦克大战主页
 *
 * @author Jack Liu
 * @date 2020-10-29 21:11
 * @since 0.1
 */
public class TankFrame extends Frame {

    static final int GAME_WIDTH = 800;
    static final int GAME_HEIGHT = 800;

    /**
     * 坦克
     */
    Tank myTank = new Tank(200, 200, Dir.DOWN, this);
    /**
     * 子弹
     */
    List<Bullet> bulletList = new ArrayList<>();


    public TankFrame() {
        this.setSize(GAME_WIDTH, GAME_HEIGHT);
        this.setResizable(false);
        this.setTitle("tank war");

        this.setVisible(true);

        // 添加键盘监听器
        this.addKeyListener(new TankKeyListener());
        // 添加窗口监听器
        this.addWindowListener(new TankWindowsListener());
    }


    // 双缓存解决闪烁问题
    Image offScreenImage = null;

    @Override
    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage, 0, 0, null);
    }

    @Override
    public void paint(Graphics g) {

        System.out.println("paint");

        // 画出子弹数量
        Color color = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("子弹数量：" + bulletList.size(), 10, 50);
        g.setColor(color);

        // 画坦克
        myTank.paint(g);

        // 画子弹
        for (int i = 0; i < bulletList.size(); i++) {
            bulletList.get(i).paint(g);
        }
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
                case KeyEvent.VK_CONTROL:
                    myTank.fire();
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
