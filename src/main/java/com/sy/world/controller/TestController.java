package com.sy.world.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {

    @RequestMapping("t")
    public String t(@RequestParam("massge") String massge){
        System.out.println(massge);
        return "收到消息：" + massge;
    }

}
