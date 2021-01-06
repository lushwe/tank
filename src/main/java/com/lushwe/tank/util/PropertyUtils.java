package com.lushwe.tank.util;

import java.io.IOException;
import java.util.Properties;

/**
 * 说明：配置属性管理
 *
 * @author Jack Liu
 * @date 2020-11-24 22:38
 * @since 0.1
 */
public class PropertyUtils {

    static Properties props = new Properties();

    static {
        try {
            props.load(PropertyUtils.class.getClassLoader().getResourceAsStream("config"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Integer getInt(String key) {
        return Integer.parseInt(getString(key));
    }

    public static String getString(String key) {
        return (String) get(key);
    }

    public static Object get(String key) {
        if (props == null) {
            return null;
        }
        return props.get(key);
    }

    public static void main(String[] args) {
        System.out.println(PropertyUtils.get("initTankCount"));
    }
}
