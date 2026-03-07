package com.skh.read.yaml;

import com.skh.objectmapper.FieldsDetailsVo;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "params")

public class ReadYAMLEmployeeParamsList {
    private List<FieldsDetailsVo> employeeParamNames;

    public List<FieldsDetailsVo> getEmployeeParamNames() {
        return employeeParamNames;
    }

    public void setEmployeeParamNames(List<FieldsDetailsVo> employeeParamNames) {
        this.employeeParamNames = employeeParamNames;
    }
}