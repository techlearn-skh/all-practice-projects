package com.skh.controllers;

import com.skh.objectmapper.YamlServiceImpl;
import com.skh.read.yaml.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class YAMLController {

    @Autowired
    private ReadIndividualProperties  individualProperties;

    @Autowired
    private ReadYAMLListProperties yamlListProperties;

    @Autowired
    private ReadYAMLEmployeeListProperties yamlMapProperties;

    @Autowired
    private ReadYAMLEmployeeMapProperties yamlEmployeeMapProperties;

    @RequestMapping("/individual")
    public void readIndividualProperties(){
        individualProperties.readIndividualProperties();;
    }

    @RequestMapping("/list-yaml")
    public ReadYAMLListProperties readListOfYAMLProperties(){
        return yamlListProperties;
    }

    @RequestMapping("/list-emp")
    public ReadYAMLEmployeeListProperties readListOfEmployeeYAMLProperties(){
        return yamlMapProperties;
    }

    @RequestMapping("/emp-map")
    public ReadYAMLEmployeeMapProperties yamlEmployeeMapProperties(){
        return yamlEmployeeMapProperties;
    }
}
