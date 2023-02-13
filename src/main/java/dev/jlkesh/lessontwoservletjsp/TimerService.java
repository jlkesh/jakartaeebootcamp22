package dev.jlkesh.lessontwoservletjsp;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.postgresql.ds.PGPoolingDataSource;

import java.sql.Connection;
import java.util.Date;

public class TimerService {
    public String currentTime() {

        /*HikariConfig configuration = new HikariConfig();
        configuration.setMinimumIdle(10);
        configuration.setMaximumPoolSize(100);
        configuration.setConnectionTimeout(10 * 1000);
        configuration.setIdleTimeout(40 * 1000);
        HikariDataSource hikariDataSource = new HikariDataSource(configuration);
        Connection connection = hikariDataSource.getConnection();*/
        PGPoolingDataSource pgPoolingDataSource = new PGPoolingDataSource();


        return new Date().toString();
    }
}
