package db;

import java.sql.*;

public class Connectiondb {
    private static String url = "jdbc:postgresql://localhost:5432/LibreriaFra";
    private static String user = "postgres";
    private static String pass = "1234.";

    private static Connection conn;

    public static Connection conectar(){
        try {
            conn = DriverManager.getConnection(url,user,pass);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }
}
