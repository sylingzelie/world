package com.sy.world.entity;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Student{
    private String name;
    private int age;
    private String address;
}