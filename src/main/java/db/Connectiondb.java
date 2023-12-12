package db;

import java.sql.*;

public class Connectiondb {
    private static String url = "jdbc:postgresql://localhost:5432/LibreriaFra";
    private static String user = "postgres";
    private static String pass = "1234.";

    public static Connection conectar() throws SQLException{
        return DriverManager.getConnection(url,user,pass);
    }
}
