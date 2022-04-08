package com.sy.world.controller;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.sy.world.entity.Student;
import lombok.Builder;
import lombok.Data;
import org.apache.tomcat.util.buf.StringUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class test extends Observable {
    public static void main(String[] args) {

//        List<String> list = Arrays.asList("abc", " ", "bc", "efg", "abcd"," ", "jkl");
//        List<String> collect = list.stream().map(i -> i.substring(1)).collect(Collectors.toList());


        List<Student> students = new ArrayList<>();
        students.add(Student.builder().age(18).address("2").name("sy").build());
        students.add(Student.builder().age(19).address("3").name("zs").build());
        students.add(Student.builder().age(20).address("2").name("ls").build());
        students.add(Student.builder().age(21).address("3").name("ww").build());
        students.add(Student.builder().age(22).address("4").name("al").build());
        students.add(Student.builder().age(23).address("").name("sq").build());
        students.add(Student.builder().age(24).address("").name("xb").build());


//        students.stream().filter(student -> "2".equals(student.getAddress())).collect(Collectors.toList()).forEach(r ->{
//            System.out.println(r.getName());
//        });

//        int sum = students.stream().filter(student -> "2".equals(student.getAddress())).mapToInt(Student::getAge).sum();

        Map<String, List<Student>> collect1 = students.stream()
                .filter(student -> !student.getAddress().isEmpty())
                .collect(Collectors.groupingBy(Student::getAddress));

        System.out.println();


    }




}
