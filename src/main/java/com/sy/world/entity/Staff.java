package com.sy.world.entity;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@ConfigurationProperties(prefix = "staff")
@Component
public
class Staff {
    @Value("${name:@null}") private String name;
    private int age;
    private int sex;
    private String address;
}