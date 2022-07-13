package com.ctco.framework.configuration;

import com.ctco.framework.Configuration;

public enum Urls {
    EN("/en");

    private static final Configuration CONFIG = Configuration.getInstance();
    private final String urlPart;

    Urls(String urlPart) {
        this.urlPart = urlPart;
    }

    public static String getHomeUrl() {
        return CONFIG.getProperty("url.home");
    }

    public String getUrl() {
        return getHomeUrl() + urlPart;
    }
}
