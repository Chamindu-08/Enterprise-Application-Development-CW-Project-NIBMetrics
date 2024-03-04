package com.NIBMetrics.DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnection {
    public void DBConnection(){

        String url = "jdbc:mysql://localhost:3350/nibm";
        String username = "root";
        String password = "MySql@1nibm57";

        try{
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

            Connection con = DriverManager.getConnection(url, username, password);

            Statement stat = con.createStatement();
        }
        catch (Exception e){
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
