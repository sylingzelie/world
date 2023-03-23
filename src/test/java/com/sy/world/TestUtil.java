package com.sy.world;

import sun.security.provider.MD5;

import java.util.Arrays;
import java.util.Random;
import java.util.function.Supplier;

public class TestUtil {

    public static void Poling(Supplier<Boolean> sup, int cnt, long slpMill) {
        for (int i = 0; i < cnt; i++) {
            Boolean flag = sup.get();
            if (flag) {
                break;
            }

            try {
                if (slpMill > 0) {
                    Thread.sleep(slpMill);
                }
            } catch (InterruptedException e) {
                //输出日志
                break;
            }
        }
    }

    public static void main(String[] args) {
//        Random random = new Random();
//        Poling(()->{
//            int num = random.nextInt(50);
//            System.out.println(num);
//            if (num < 3) {
//                return Boolean.TRUE;
//            }
//            return Boolean.FALSE;
//        }, 3, 2000);

    }
}
