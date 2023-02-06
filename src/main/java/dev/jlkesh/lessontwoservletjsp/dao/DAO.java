package dev.jlkesh.lessontwoservletjsp.dao;

import org.postgresql.Driver;

import java.sql.Connection;
import java.sql.DriverAction;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DAO {

    private final ThreadLocal<Connection> connectionThreadLocal = ThreadLocal.withInitial(
            () -> {
                try {
                    DriverManager.registerDriver(new Driver());
                    return DriverManager.getConnection(
                            "jdbc:postgresql://localhost:5432/jakartaee",
                            "postgres",
                            "123"
                    );
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
    );

    protected Connection getConnection() {
        return connectionThreadLocal.get();
    }
}
