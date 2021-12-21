package com.sy.world.controller;


import com.sy.world.config.WebSocket;
import com.sy.world.tools.TestImpl;
import com.sy.world.tools.TestT;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {


    @RequestMapping("t")
    public String t(@RequestParam("massge") String massge){
        System.out.println(massge);
        return "收到消息了：" + massge;
    }

    public static void main(String[] args) {
        TestImpl t = new TestImpl();
        Object o = t.compareTo();
        System.out.println("test");
    }

}
