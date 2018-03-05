package com.hfut.study.common.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by chenjia on 2017/7/17.
 */
public class ReadAppliactionUtils {
    public  Map readProperties(String propertiesFilePath) {
        Map<String, String> map = new HashMap<String, String>();
        ReadAppliactionUtils readAppliactionUtils = new ReadAppliactionUtils();
        InputStream in = this.getClass().getResourceAsStream(propertiesFilePath);
        Properties prop = new Properties();
        try {
            prop.load(in);
            Enumeration enumeration = prop.propertyNames();
            while (enumeration.hasMoreElements()) {
                String key = (String) enumeration.nextElement();
                String value = prop.getProperty(key);
                map.put(key, value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;

    }

    public static void main(String[] args) {
        System.out.println(new ReadAppliactionUtils().readProperties("/application.properties").get("porsche"));
    }
}

