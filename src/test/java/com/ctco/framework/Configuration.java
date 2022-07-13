package com.ctco.framework;

import com.ctco.framework.utils.PropertiesResourceManager;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Configuration {

    private static ThreadLocal<Configuration> instance = new InheritableThreadLocal<>();
    private final String CONFIG_PROPERTY = "configuration.properties";

    public static Configuration getInstance() {
        if (instance.get() == null) {
            instance.set(new Configuration());
        }
        return instance.get();
    }

    public String getProperty(final String key) {
        return new PropertiesResourceManager(CONFIG_PROPERTY).getProperty(key);
    }
}
