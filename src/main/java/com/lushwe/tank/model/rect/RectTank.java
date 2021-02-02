package com.lushwe.tank.model.rect;

import com.lushwe.tank.GameModel;
import com.lushwe.tank.enums.Dir;
import com.lushwe.tank.enums.Group;
import com.lushwe.tank.model.Tank;
import com.lushwe.tank.strategy.FireStrategy;
import com.lushwe.tank.util.PropertyUtils;

import java.awt.*;
import java.util.Random;

/**
 * 说明：方形坦克
 *
 * @author Jack Liu
 * @date 2021/1/10 下午9:50
 * @since 0.1
 */
public class RectTank extends Tank {

    private static final int SPEED = 2;

    /**
     * 移动中
     */
    private boolean moving = true;

    /**
     * 活着
     */
    private boolean living = true;

    /**
     * 随机变量
     */
    private Random random = new Random();

    public RectTank(int x, int y, Dir dir, Group group) {
        super(x, y, dir, group);
    }

    /**
     * 画自己
     *
     * @param g
     */
    @Override
    public void paint(Graphics g) {

        if (!living) {
            GameModel.getInstance().remove(this);
        }

        //
        Color color = g.getColor();
        g.setColor(group == Group.GOOD ? Color.RED : Color.YELLOW);
        g.fillRect(x, y, 40, 40);
        g.setColor(color);

        // 移动
        move();

    }

    /**
     * 是否我方坦克
     *
     * @return
     */
    private boolean isGoodGroup() {
        return this.group == Group.GOOD;
    }

    /**
     * 移动
     */
    private void move() {

        oldX = x;
        oldY = y;

        if (!moving) {
            return;
        }

        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
        }

        // 坦克随机开火
        if (this.group == Group.BAD && random.nextInt(100) > 95) {
            this.fire();
        }
        if (this.group == Group.BAD && random.nextInt(100) > 95) {
            randomDir();
        }

        // 边界检查
        boundsCheck();

        // 更新 rect
        rect.x = this.x;
        rect.y = this.y;
    }

    /**
     * 随机移动
     */
    private void randomDir() {
        this.dir = Dir.values()[random.nextInt(4)];
    }

    /**
     * 发射子弹
     */
    public void fire() {
        fs.fire(this);
    }

    /**
     * 死亡
     */
    public void die() {
        this.living = false;
    }

    // =========================== getter/setter method ===========================
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public Group getGroup() {
        return group;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    @Override
    public Rectangle getRect() {
        return rect;
    }

}
