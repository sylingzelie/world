package com.sy.world;

import com.alibaba.fastjson.JSONObject;
import com.sy.world.entity.Test;
import com.sy.world.entity.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class stream {
    public static void main(String[] args) {
        List<String> s = new ArrayList<>();
        s.add("a");
        s.add("b");
        s.add("c");
        List<User> users = new ArrayList<>();
        User user1 = new User();
        user1.setName("sun");
        user1.setAge(10);
        User user2 = new User();
        user2.setName("shen");
        user2.setAge(11);
        User user3 = new User();
        user3.setName("zhou");
        user3.setAge(12);
        users.add(user1);
        users.add(user2);
        users.add(user3);
        List<Test> collect = s.stream().map(r -> users.stream().map(k -> {
            Test test = new Test();
            test.setName(k.getName());
            test.setFlag(r);
            return test;
        }).collect(Collectors.toList())).flatMap(Collection::stream).collect(Collectors.toList());
        System.out.println(JSONObject.toJSONString(collect));
    }
}
