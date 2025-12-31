package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {

    private static final String url="jdbc:postgresql://localhost:5432/hotel";
    private static final String user="DB_name";
    private static final String pass="DB_password";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,user,pass);
    }

}
