package com.sy.world;

import com.sy.world.controller.test;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Mgr03 {
    private static final AtomicReference<Mgr03> INSTANCE1 = new AtomicReference<Mgr03>();

    private static Mgr03 INSTANCE;

    private Mgr03() {
    }

    static Lock lock = new ReentrantLock();

    public static Mgr03 getInstance() {
        synchronized (Mgr03.class) {
            if (INSTANCE == null) {
                try {
                    Thread.sleep(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                INSTANCE = new Mgr03();
            }
            return INSTANCE;
        }
    }

    class test{
        public String t1;

    }

    public static void main(String[] args) {

    }
}
