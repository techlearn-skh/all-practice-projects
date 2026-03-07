package com.skh.objectmapper;

import com.skh.models.EmployeeVOWithAddressVO;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.node.ArrayNode;
import tools.jackson.databind.node.ObjectNode;

import java.util.concurrent.atomic.AtomicInteger;

public class App {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        String fieldPath = "";
        EmployeeVOWithAddressVO employeeVOWithAddressVO = EmployeeVOWithAddressVO.fetchAllEmployees().get(0);
        JsonNode jsonNode = objectMapper.convertValue(employeeVOWithAddressVO, JsonNode.class);
        printObjectsFromJsonNode(jsonNode, fieldPath);

    }

    private static void printObjectsFromJsonNode( JsonNode jsonNode, String fieldPath){
        int arrayIndex = 0;
        if(jsonNode.isObject()){
            ObjectNode objectNode = (ObjectNode) jsonNode;
            objectNode.properties().forEach(entry -> printObjectsFromJsonNode(entry.getValue(), fieldPath+"/"+entry.getKey()));
        } else if (jsonNode.isArray()) {
            AtomicInteger atomicInteger = new AtomicInteger();
            ArrayNode arrayNode = (ArrayNode) jsonNode;
            arrayNode.elements().forEach(item -> printObjectsFromJsonNode(item, fieldPath+"/"+atomicInteger.getAndIncrement()));
        }else {
            System.out.println(fieldPath + " : " +jsonNode);
        }
    }
}
