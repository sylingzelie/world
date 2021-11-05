package com.sy.world;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WorldApplicationTests {

    @Test
    void contextLoads() {
    }

    public static void main(String[] args) {
        System.out.println("15857186014".replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2"));
    }
}
