package com.sy.world;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIoc {
    public static void main(String[] args) {
        // 读取Spring配置文件，创建Spring容器
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        context.getBean("");
        // 从容器中获取Bean实例
//        MyBean obj = (MyBean) context.getBean("myBean");

        // 使用Bean
//        obj.setMessage("Hello Spring!");
//        obj.getMessage();
    }
}
