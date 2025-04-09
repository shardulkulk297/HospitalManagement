package app.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static Connection connection;
    public static Connection getConnection() throws SQLException {
            connection = DriverManager.getConnection(PropertyUtil.getPropertyString());

            return connection;
    }
}
