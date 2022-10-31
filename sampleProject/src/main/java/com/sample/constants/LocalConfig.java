package com.sample.constants;


import com.sample.utils.PropertyUtils;

public class LocalConfig {
    public static final String USER_GENERATOR_URL;
    public static final String QA_WEBSITE_URL;

    static {
        try {
            PropertyUtils.getInstance().load("config.properties");
            USER_GENERATOR_URL= System.getProperty("USER_GENERATOR_URL",PropertyUtils.getInstance().getValue("USER_GENERATOR_URL"));
            QA_WEBSITE_URL=System.getProperty("QA_WEBSITE_URL",PropertyUtils.getInstance().getValue("QA_WEBSITE_URL"));
        } catch (Throwable t) {
            t.printStackTrace();
            throw new RuntimeException("Something wrong !!! Check configurations.", t);
        }
    }
}
