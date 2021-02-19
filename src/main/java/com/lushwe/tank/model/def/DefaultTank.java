package com.lushwe.tank.model.def;

import com.lushwe.tank.GameModel;
import com.lushwe.tank.enums.Dir;
import com.lushwe.tank.enums.Group;
import com.lushwe.tank.model.Tank;
import com.lushwe.tank.util.ResourceUtils;

import java.awt.*;
import java.util.Random;

/**
 * 说明：默认坦克对象
 *
 * @author Jack Liu
 * @date 2020-11-10 20:32
 * @since 0.1
 */
public class DefaultTank extends Tank {

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

    public DefaultTank(int x, int y, Dir dir, Group group) {
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

        switch (dir) {
            case LEFT:
                g.drawImage(isGoodGroup() ? ResourceUtils.goodTankL : ResourceUtils.badTankL, x, y, null);
                break;
            case UP:
                g.drawImage(isGoodGroup() ? ResourceUtils.goodTankU : ResourceUtils.badTankU, x, y, null);
                break;
            case RIGHT:
                g.drawImage(isGoodGroup() ? ResourceUtils.goodTankR : ResourceUtils.badTankR, x, y, null);
                break;
            case DOWN:
                g.drawImage(isGoodGroup() ? ResourceUtils.goodTankD : ResourceUtils.badTankD, x, y, null);
                break;
        }

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

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

}
