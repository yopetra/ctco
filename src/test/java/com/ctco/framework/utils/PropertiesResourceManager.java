package com.ctco.framework.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

import static java.lang.String.format;

public final class PropertiesResourceManager {

    private Properties properties;

    public PropertiesResourceManager(final String resourceName) {
        properties = new Properties();
        appendFromResource(properties, resourceName);
    }

    private void appendFromResource(final Properties properties, final String resourceName) {
        try (InputStream inStream = this.getClass().getClassLoader().getResourceAsStream(resourceName)) {
            if (inStream != null) {
                properties.load(new InputStreamReader(inStream, StandardCharsets.UTF_8));
            } else {
                System.out.println(format("Resource \"%1$s\" could not be found", resourceName));
            }
        } catch (IOException e) {
            System.out.println("Error occurred during appending resource file");
        }
    }

    public String getProperty(final String key) {
        return System.getProperty(key, properties.getProperty(key));
    }
}
