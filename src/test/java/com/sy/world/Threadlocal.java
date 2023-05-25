package com.sy.world;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Threadlocal {
    private static final ThreadLocal<Connection> connectionHolder = new ThreadLocal<>();

    public static Connection getConnection() throws SQLException {
        Connection connection = connectionHolder.get();
        if (connection == null) {
            connection = createConnection();
            connectionHolder.set(connection);
        }
        return connection;
    }

    public static void startTransaction() throws SQLException {
        Connection connection = getConnection();
        connection.setAutoCommit(false);
    }

    public static void commitTransaction() throws SQLException {
        Connection connection = getConnection();
        connection.commit();
        connectionHolder.remove();
    }

    public static void rollbackTransaction() throws SQLException {
        Connection connection = getConnection();
        connection.rollback();
        connectionHolder.remove();
    }

    private static Connection createConnection() throws SQLException {
        // 创建数据库连接
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "user", "password");
    }
}

