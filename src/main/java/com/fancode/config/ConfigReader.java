package com.fancode.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties = new Properties();

    // Static block to load properties file once when the class is loaded
    static {
        try (InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new RuntimeException("Unable to find config.properties");
            }
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load configuration properties", e);
        }
    }

    // Method to get the Base URL from properties file
    public static String getBaseUrl() {
        return properties.getProperty("base.url", "http://localhost");  // Default to localhost if not set
    }

    // Generic method to get any property from the config
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
