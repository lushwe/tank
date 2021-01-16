package com.lushwe.tank.model;

import com.lushwe.tank.GameModel;
import com.lushwe.tank.GameObject;
import com.lushwe.tank.TankFrame;
import com.lushwe.tank.enums.Dir;
import com.lushwe.tank.enums.Group;
import com.lushwe.tank.model.def.DefaultTank;
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

    public abstract int getX();

    public abstract int getY();

    public abstract Dir getDir();

    public abstract void setDir(Dir dir);

    public abstract void setMoving(boolean moving);

    public abstract Group getGroup();

    public abstract GameModel getGm();

    public abstract Rectangle getRect();

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
