package com.connectionProvider;

import java.sql.*;

public class createConnection {
    private static Connection con;

    public static Connection getConnection() {

        if (con == null) {
            try {

                Class.forName("com.mysql.cj.jdbc.Driver");
                // create connection with database
                String url = "jdbc:mysql://localhost:3306/jdbc_tutorial";
                String user = "root";
                String password = "RbSp@302241";
                con = DriverManager.getConnection(url, user, password);
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return con;
    }
}
