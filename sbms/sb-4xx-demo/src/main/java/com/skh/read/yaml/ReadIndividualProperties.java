package com.skh.read.yaml;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ReadIndividualProperties {


    @Value("${app.name}")
    private String appName;

    @Value("${app.version}")
    private String version;

    public void readIndividualProperties() {
        System.out.println(appName);
        System.out.println(version);
    }
}