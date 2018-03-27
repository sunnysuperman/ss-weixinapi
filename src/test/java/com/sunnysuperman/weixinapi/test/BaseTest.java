package com.sunnysuperman.weixinapi.test;

import java.io.File;
import java.io.InputStream;

import com.sunnysuperman.commons.config.PropertiesConfig;

import junit.framework.TestCase;

public class BaseTest extends TestCase {
    private static PropertiesConfig config;
    static {
        config = new PropertiesConfig(BaseTest.class.getResourceAsStream("/testresources/test.properties"));
    }

    protected String getString(String key) {
        return config.getString(key, "");
    }

    protected String findString(String key) {
        return config.getString(key, null);
    }

    public static InputStream getResourceAsStream(String fileName) {
        return BaseTest.class.getResourceAsStream("/testresources/" + fileName);
    }

    public static File getUserDir() {
        return new File(System.getProperty("user.dir"));
    }

}
