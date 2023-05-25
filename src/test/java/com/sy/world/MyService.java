package com.sy.world;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MyService {
    public void methodA() throws SQLException {
        Threadlocal.startTransaction();
        try {
            methodB();
            Threadlocal.commitTransaction();
        } catch (Exception e) {
            Threadlocal.rollbackTransaction();
        }
    }

    public void methodB() {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            executor.submit(() -> {
                try {
                    Connection connection = Threadlocal.getConnection();
                    // 在这里执行数据库操作
                    // 如果发生异常，会自动回滚整个事务
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });
        }
        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

