package com.util;

import java.sql.*;

public class DBConnection {
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(DBConfig.URL, DBConfig.USERNAME, DBConfig.PASSWORD);
    }
}
