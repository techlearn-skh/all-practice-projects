package com.skh.controllers;

import com.skh.objectmapper.YamlServiceImpl;
import com.skh.read.yaml.ReadIndividualProperties;
import com.skh.read.yaml.ReadYAMLEmployeeListProperties;
import com.skh.read.yaml.ReadYAMLEmployeeMapProperties;
import com.skh.read.yaml.ReadYAMLListProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ObjectMapperController {

    @Autowired
    private YamlServiceImpl yamlService;

    @RequestMapping("/param-list")
    public void fetchAllFieldFromYaml(){
        yamlService.fetchAllFieldFromYaml();
    }



}
