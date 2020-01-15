package cc.decat.dorm.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/test?useSSL=false";
    private static String username = "root";
    private static String password = "root";
    private static Connection conn;

    static {
        try {
            Class.forName(driver);
             conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConn() {
        return conn;
    }
}
