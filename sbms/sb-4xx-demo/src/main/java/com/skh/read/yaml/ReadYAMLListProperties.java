package com.skh.read.yaml;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "list")
public class ReadYAMLListProperties {
    private String name;
    private List<String> servers;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getServers() {
        return servers;
    }

    public void setServers(List<String> servers) {
        this.servers = servers;
    }

    @Override
    public String toString() {
        return "ReadYAMLListProperties{" +
                "name='" + name + '\'' +
                ", servers=" + servers +
                '}';
    }
}