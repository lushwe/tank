package com.lushwe.tank.model;

import com.lushwe.tank.GameModel;
import com.lushwe.tank.GameObject;
import com.lushwe.tank.TankFrame;
import com.lushwe.tank.enums.Dir;
import com.lushwe.tank.enums.Group;
import com.lushwe.tank.model.def.DefaultTank;
import com.lushwe.tank.strategy.FireStrategy;
import com.lushwe.tank.util.PropertyUtils;
import com.lushwe.tank.util.ResourceUtils;

import java.awt.*;

/**
 * 说明：基础坦克对象
 *
 * @author Jack Liu
 * @date 2021/1/10 下午8:40
 * @since 0.1
 */
public abstract class Tank extends GameObject {

    public static int WIDTH = ResourceUtils.goodTankU.getWidth();
    public static int HEIGHT = ResourceUtils.goodTankU.getHeight();

    protected int oldX;
    protected int oldY;

    /**
     * 方向
     */
    protected Dir dir;

    /**
     * 阵营
     */
    protected Group group;

    /**
     * 矩形
     */
    protected Rectangle rect;

    /**
     * 开火策略
     */
    protected FireStrategy fs;

    public Tank(int x, int y, Dir dir, Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.rect = new Rectangle(x, y, WIDTH, HEIGHT);

        // 初始化开火策略
        String fsName = PropertyUtils.getString(this.group.name().toLowerCase() + "FS");
        try {
            fs = (FireStrategy) Class.forName(fsName).getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        GameModel.getInstance().add(this);
    }

    public int getX() {
        return x;
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

    public Rectangle getRect() {
        return rect;
    }

    public abstract void setMoving(boolean moving);

    public abstract void die();

    public abstract void fire();

    public void back() {
        this.x = this.oldX;
        this.y = this.oldY;
    }

    /**
     * 边界检查
     */
    protected void boundsCheck() {
        if (this.x < 2) {
            x = 2;
        }
        if (this.y < 28) {
            y = 28;
        }
        if (this.x > TankFrame.GAME_WIDTH - DefaultTank.WIDTH - 2) {
            x = TankFrame.GAME_WIDTH - DefaultTank.WIDTH - 2;
        }
        if (this.y > TankFrame.GAME_HEIGHT - DefaultTank.HEIGHT - 2) {
            y = TankFrame.GAME_HEIGHT - DefaultTank.HEIGHT - 2;
        }
    }
}
