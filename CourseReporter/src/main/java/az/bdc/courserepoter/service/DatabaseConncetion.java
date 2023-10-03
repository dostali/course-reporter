package az.bdc.courserepoter.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DatabaseConncetion {

    private static final String URL = "jdbc:mysql://localhost:3306/bdc_course";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "12345678";

    public Connection connect(){
        try {
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
