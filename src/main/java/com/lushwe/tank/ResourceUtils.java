package com.lushwe.tank;

import com.lushwe.tank.util.ImageUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * 说明：图片资源管理器
 *
 * @author Jack Liu
 * @date 2020-11-12 21:39
 * @since 0.1
 */
public class ResourceUtils {

    public static BufferedImage goodTankL, goodTankU, goodTankR, goodTankD;
    public static BufferedImage badTankL, badTankU, badTankR, badTankD;
    public static BufferedImage bulletL, bulletU, bulletR, bulletD;
    public static BufferedImage[] explodes = new BufferedImage[16];

    static {
        try {
            // 我方坦克
            goodTankU = ImageIO.read(ResourceUtils.class.getClassLoader().getResourceAsStream("images/GoodTank1.png"));
            goodTankL = ImageUtils.rotateImage(goodTankU, -90);
            goodTankR = ImageUtils.rotateImage(goodTankU, 90);
            goodTankD = ImageUtils.rotateImage(goodTankU, 180);

            // 敌方坦克
            badTankU = ImageIO.read(ResourceUtils.class.getClassLoader().getResourceAsStream("images/BadTank1.png"));
            badTankL = ImageUtils.rotateImage(badTankU, -90);
            badTankR = ImageUtils.rotateImage(badTankU, 90);
            badTankD = ImageUtils.rotateImage(badTankU, 180);

            // 子弹
            bulletU = ImageIO.read(ResourceUtils.class.getClassLoader().getResourceAsStream("images/bulletU.png"));
            bulletL = ImageUtils.rotateImage(bulletU, -90);
            bulletR = ImageUtils.rotateImage(bulletU, 90);
            bulletD = ImageUtils.rotateImage(bulletU, 180);

            // 爆炸
            for (int i = 0; i < 16; i++) {
                explodes[i] = ImageIO.read(ResourceUtils.class.getClassLoader().getResourceAsStream("images/e" + (i + 1) + ".gif"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
