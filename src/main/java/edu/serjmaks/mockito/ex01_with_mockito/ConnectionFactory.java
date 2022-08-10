package edu.serjmaks.mockito.ex01_with_mockito;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String DRIVER_CLASS_NAME = "org.h2.Driver";
    private static final String URL = "jdbc:h2:mem:poll;" +
                                      "MODE=PostgreSQL;" +
                                      "INIT=runscript from 'classpath:/schema_init.sql';" +
                                      "DB_CLOSE_DELAY=-1;" +
                                      "DB_CLOSE_ON_EXIT=FALSE";

    public Connection getConnection() throws SQLException {
        try {
            Class.forName(DRIVER_CLASS_NAME);
            return DriverManager.getConnection(URL);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
