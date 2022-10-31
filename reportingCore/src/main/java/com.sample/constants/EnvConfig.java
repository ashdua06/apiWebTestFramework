package com.sample.constants;


import com.sample.exceptions.EnvConfigFileException;
import com.sample.utils.PropertyUtils;

public class EnvConfig {
    public static final String browser;
    public static final String environment;
    public static final String platform;
    public static final String Viewport;
    public static final String Brand;
    public static final String domain;
    public static final String language;
    public static final String incognito;
    public static final String UILiteFlag;
    static {
        try {
            PropertyUtils.getInstance().loadProperties("env.properties");
            environment=PropertyUtils.getInstance().getValue("environment", EnvConstants.Default_environment);
            platform = PropertyUtils.getInstance().getValue("platform", EnvConstants.Default_platform);
            Viewport = PropertyUtils.getInstance().getValue("Viewport", EnvConstants.Default_Viewport);
            Brand = PropertyUtils.getInstance().getValue("Brand", EnvConstants.Default_Brand);
            domain = PropertyUtils.getInstance().getValue("domain", EnvConstants.Default_domain);
            language = PropertyUtils.getInstance().getValue("language", EnvConstants.Default_language);
            browser = PropertyUtils.getInstance().getValue("browser", EnvConstants.Default_browser);
            incognito = PropertyUtils.getInstance().getValue("incognito", EnvConstants.Default_incognito);
            UILiteFlag=PropertyUtils.getInstance().getValue("UILiteFlag", EnvConstants.Default_UILiteFlag);
        }
        catch (Exception e){
            throw new EnvConfigFileException("Error in loading env.property file, make sure it exist in src/main/resources",e);
        }
    }

}
