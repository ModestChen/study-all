package com.hfut.study.web.manager;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author chenjia
 * @create 2017-11-14 16:51
 * @desc
 **/
@Component
@ConfigurationProperties("girl")
public class Girl {


    private Map<String, String> carFactoryMap;
    private String name;
    private String cupSize;

    public Map<String, String> getCarFactoryMap() {
        return carFactoryMap;
    }

    public void setCarFactoryMap(Map<String, String> carFactoryMap) {
        this.carFactoryMap = carFactoryMap;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }
}
