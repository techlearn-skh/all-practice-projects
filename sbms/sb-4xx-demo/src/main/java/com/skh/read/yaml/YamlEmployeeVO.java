package com.skh.read.yaml;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class YamlEmployeeVO {
    private int id;
    private String name;
    private String department;
}
