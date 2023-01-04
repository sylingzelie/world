package com.sy.world.controller;

import org.springframework.util.Assert;

public class AsertFoo {
    public static void main(String[] args) {
        Assert.isTrue(true, "///");
        System.out.println(1);

        try{
//            Assert.isTrue(false, "----");
            assert false : "sss";
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        System.out.println(2);
    }
}
