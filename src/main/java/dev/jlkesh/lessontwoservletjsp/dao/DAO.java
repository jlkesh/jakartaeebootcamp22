package dev.jlkesh.lessontwoservletjsp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DAO {

    private ThreadLocal<Connection> connection = ThreadLocal.withInitial(
            () -> {
                try {
                    return DriverManager.getConnection(
                            "jdbc:postgresql//localhost:5432/jakartaee?currentSchema=lessontwo",
                            "postgres",
                            "123"
                    );
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
    );

    protected Connection getConnection() {
        return connection.get();
    }
}
