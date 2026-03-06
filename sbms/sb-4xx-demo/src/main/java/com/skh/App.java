package com.skh;

import com.skh.models.EmployeeVO;
import com.skh.models.EmployeeVOWithAddressVO;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

public class App {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.convertValue(EmployeeVOWithAddressVO.fetchAllEmployees().get(0), JsonNode.class);

        System.out.println(jsonNode);

    }
}
