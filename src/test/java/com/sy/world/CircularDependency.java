package com.sy.world;

import java.math.BigDecimal;

public class CircularDependency {



    public static void main(String[] args) {
        BigDecimal b = new BigDecimal("0.222");
        BigDecimal bigDecimal = b.setScale(2, BigDecimal.ROUND_UP);
        System.out.println(bigDecimal);
    }

    private static void a(int i){
        if(i > 0){
            System.out.println(i);
            b(--i);
        }
    }

    private static void b(int i){
        if(i > 0) {
            System.out.println(i);
            a(--i);
        }
    }
}
