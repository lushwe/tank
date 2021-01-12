package com.lushwe.tank.model.rect;

import com.lushwe.tank.GameModel;
import com.lushwe.tank.TankFrame;
import com.lushwe.tank.enums.Dir;
import com.lushwe.tank.enums.Group;
import com.lushwe.tank.model.Bullet;
import com.lushwe.tank.model.Tank;
import com.lushwe.tank.model.def.DefaultExplode;
import com.lushwe.tank.model.def.DefaultTank;

import java.awt.*;

/**
 * 说明：方形子弹
 *
 * @author Jack Liu
 * @date 2021/1/10 下午9:51
 * @since 0.1
 */
public class RectBullet extends Bullet {

    private static final int SPEED = 6;

    Rectangle rect = new Rectangle();

    /**
     * 方向
     */
    private Dir dir;

    /**
     * 阵营
     */
    private Group group;

    private GameModel gm;

    /**
     * 活着
     */
    private boolean living = true;

    public RectBullet(int x, int y, Dir dir, Group group, GameModel gm) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.gm = gm;

        rect.x = this.x;
        rect.y = this.y;
        rect.width = WIDTH;
        rect.height = HEIGHT;

        this.gm.getBulletList().add(this);
    }

    /**
     * 画自己
     *
     * @param g
     */
    @Override
    public void paint(Graphics g) {

        if (!living) {
            gm.getBulletList().remove(this);
        }

        //
        Color color = g.getColor();
        g.setColor(group == Group.GOOD ? Color.RED : Color.YELLOW);
        g.fillRect(x, y, 10, 10);
        g.setColor(color);

        // 移动
        move();

    }

    /**
     * 移动
     */
    private void move() {

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

        // 更新 rect
        rect.x = this.x;
        rect.y = this.y;

        if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) {
            // 移出窗口，死亡
            living = false;
        }
    }

    /**
     * 碰撞
     *
     * @param tank
     */
    @Override
    public void collideWith(Tank tank) {

        if (this.group == tank.getGroup()) {
            return;
        }

        if (this.rect.intersects(tank.getRect())) {
            // 子弹死亡
            this.die();
            // 坦克死亡
            tank.die();
            // 添加爆炸
            int x = tank.getX() + DefaultTank.WIDTH / 2 - DefaultExplode.WIDTH / 2;
            int y = tank.getY() + DefaultTank.HEIGHT / 2 - DefaultExplode.HEIGHT / 2;
            this.gm.getExplodes().add(this.gm.getGameFactory().createExplode(x, y, this.gm));
        }

    }

    /**
     * 死亡
     */
    private void die() {
        this.living = false;
    }
}
