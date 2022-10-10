package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД
    private final Connection connection;
    private static volatile Util instance;
    final String connectionUrl = "jdbc:mysql://localhost:3306/kata";
    final String userName = "root";
    final String passWord = "8RCDNjQUwpGg";
    private Util() {
        try {
            connection = DriverManager.getConnection(connectionUrl, userName, passWord);
            connection.setAutoCommit(false);
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Connection getConnection() {
        return connection;
    }
    public static Util getInstance() {
        if (instance == null) {
            synchronized (Util.class) {
                if (instance == null) {
                    instance = new Util();
                }
            }
        }
        return instance;
    }
}
