package com.skh.objectmapper;

import com.skh.models.EmployeeVOWithAddressVO;
import com.skh.read.yaml.ReadYAMLEmployeeParamsList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.node.ArrayNode;
import tools.jackson.databind.node.ObjectNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

@Service
public class YamlServiceImpl {

    @Autowired
    ReadYAMLEmployeeParamsList yamlEmployeeParamsList;

    public void fetchAllFieldFromYaml(){
        String fieldPath = "";
        Map<String,JsonNode> outPutMap = new HashMap<>();
        EmployeeVOWithAddressVO employeeVOWithAddressVO = EmployeeVOWithAddressVO.fetchAllEmployees().get(0);
        JsonNode jsonNode = new ObjectMapper().convertValue(employeeVOWithAddressVO, JsonNode.class);
        Map<String, JsonNode> outPut = formatAndFlatterJson(jsonNode, outPutMap, fieldPath);

        for (FieldsDetailsVo fieldsDetailsVo: this.yamlEmployeeParamsList.getEmployeeParamNames()){
            for (Map.Entry<String, JsonNode> entries : outPut.entrySet()){
                if(Pattern.matches(fieldsDetailsVo.getSourcePath(), entries.getKey())){
                    System.out.println("path matched --> sourcePath: "+ fieldsDetailsVo.getSourcePath()
                    +", key: "+ entries.getKey()+", value: "+ entries.getValue());
                }
            }
        }
    }

    public static Map<String, JsonNode> formatAndFlatterJson(JsonNode jsonNode, Map<String,JsonNode> outPut, String path){
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
        return  outPut;

    }

}
