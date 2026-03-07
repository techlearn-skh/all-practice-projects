package com.skh.read.yaml;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "emp-list")
@Data
@NoArgsConstructor
@ToString
public class ReadYAMLEmployeeListProperties {
    private List<YamlEmployeeVO> employees;
}