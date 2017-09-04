package com.kingyon.partybuild.config;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.SystemConfiguration;

import java.text.MessageFormat;

/**
 * <p>Title:Props</p>
 * <p>Description:系统配置属性加载工具类，用于加载应用系统的配置信息</p>
 * <p>Company:成都金翼致远科技有限公司</p>
 *
 * @author Jimmy
 * @date 2016-3-21 下午2:05:35
 */
public class Props {

    private static final String PROPS_FILE = "application.properties";

    private static final CompositeConfiguration config = new CompositeConfiguration();

    static {
        config.addConfiguration(new SystemConfiguration());
        try {
            config.addConfiguration(new PropertiesConfiguration(PROPS_FILE));
        } catch (ConfigurationException e) {

            throw new RuntimeException(e);
        }
    }

    public static int getInt(String key, int defaultValue) {

        return config.getInt(key, defaultValue);
    }

    public static long getLong(String key, long defaultValue) {

        return config.getLong(key, defaultValue);
    }

    public static String getString(String key, String defaultValue) {

        return config.getString(key, defaultValue);
    }

    public static String getString(String key) {

        return config.getString(key);
    }

    public static String getPatternString(String key, Object... arguments) {

        String pattern = getString(key, "");

        return MessageFormat.format(pattern, arguments);
    }

    public static float getFloat(String key, float defaultValue) {

        return config.getFloat(key, defaultValue);
    }

    public static double getDouble(String key, double defaultValue) {

        return config.getDouble(key, defaultValue);
    }
}
