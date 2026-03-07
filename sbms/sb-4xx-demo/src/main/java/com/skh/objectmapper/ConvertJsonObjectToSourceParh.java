package com.skh.objectmapper;

import com.skh.models.EmployeeVOWithAddressVO;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.node.ArrayNode;
import tools.jackson.databind.node.ObjectNode;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class ConvertJsonObjectToSourceParh {
    public static void main(String[] args) {
        Map<String,JsonNode> outPut = new HashMap<>();
        String sourceFieldsPath = "";
        ObjectMapper objectMapper = new ObjectMapper();
        EmployeeVOWithAddressVO employeeVOWithAddressVO = EmployeeVOWithAddressVO.fetchAllEmployees().get(0);
        JsonNode jsonNode = objectMapper.convertValue(employeeVOWithAddressVO, JsonNode.class);
        formatAndFlatterJson(jsonNode, outPut, sourceFieldsPath);
        System.out.println(outPut);
    }

    public static void formatAndFlatterJson(JsonNode jsonNode, Map<String,JsonNode> outPut, String path){
        if(jsonNode.isObject()){
            ObjectNode objectNode = (ObjectNode) jsonNode;
            objectNode.properties().forEach(entry -> formatAndFlatterJson(entry.getValue(), outPut,path+"/"+entry.getKey()));
        } else if (jsonNode.isArray()) {
            ArrayNode arrayNode = (ArrayNode) jsonNode;
            AtomicInteger atomicInteger = new AtomicInteger();
            arrayNode.elements().forEach(item -> formatAndFlatterJson(item, outPut,path+"/"+atomicInteger.getAndIncrement()));
        }else {
            outPut.put(path, jsonNode);
        }

    }

}
