package com.sample.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtils {
    private static PropertyUtils configs;
    private Properties properties;
    private PropertyUtils(){
        properties=new Properties();
    }

    public static synchronized PropertyUtils getInstance() {
        if (configs == null) {
            configs = new PropertyUtils();
        }
        return configs;
    }

    public Properties loadProperties(String fileName) {
        InputStream input;
        try {
            input =getClass().getClassLoader().getResourceAsStream(fileName);
            properties.load(input);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return properties;
    }

    public void load(String fileName) {
        InputStream input;
        System.out.println("File name in CSV is "+fileName);

        input = getClass().getClassLoader().getResourceAsStream(fileName);
        try {
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public String getValue(String key) {
        return properties.getProperty(key).trim();
    }

    public String getValue(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue).trim();
    }
}
