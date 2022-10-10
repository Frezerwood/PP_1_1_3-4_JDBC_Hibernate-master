package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        // реализуйте алгоритм здесь
        Util.getInstance().getConnection();
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Vasya", "Ivanoff", (byte) 33);
        userService.saveUser("Petya", "Petroff", (byte) 34);
        userService.saveUser("Kolya", "Sokoloff", (byte) 35);
        userService.saveUser("Ivan", "Sidoroff", (byte) 36);
        userService.getAllUsers();
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
