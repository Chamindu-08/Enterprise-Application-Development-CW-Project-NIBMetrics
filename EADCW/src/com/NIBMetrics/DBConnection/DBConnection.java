package com.NIBMetrics.DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBConnection {
    public Connection DBConnection() {
        String url = "jdbc:mysql://localhost:3350/nibmetrics";
        String username = "root";
        String password = "MySql@1nibm57";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database!");
            return con;
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
            return null;
        }
    }
}
