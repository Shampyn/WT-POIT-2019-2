package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBController  {
    private String connectionUrl = "jdbc:mysql://localhost:3306/";
    private String db_username;
    private String db_password;

    public DBController(String db_name, String db_username, String db_password) {
        this.connectionUrl += db_name;
        this.db_username = db_username;
        this.db_password = db_password;
    }

    public Connection EstablishConnection() throws ClassNotFoundException {

        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Successfully connected!");
            return DriverManager.getConnection(connectionUrl, db_username, db_password);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
