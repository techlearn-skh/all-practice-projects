package com.skh.read.yaml;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "emp-map")
@Data
@NoArgsConstructor
@ToString
public class ReadYAMLEmployeeMapProperties {
    private Map<String, YamlEmployeeVO> employees;
}