package com.example.demo.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexion {
    private static String URL = "jdbc:mysql://root:ZIfAOHZPtIPKbwbuwxXLYISilHSLNeZp@maglev.proxy.rlwy.net:39367/railway";
        private static String USER = "railway";
        private static String PASSWORD = "ZIfAOHZPtIPKbwbuwxXLYISilHSLNeZp";

        public static Connection getConnection() {
            Connection conexion = null;
            try 
            {
                conexion = DriverManager.getConnection(URL, USER, PASSWORD);    
            } 
            catch (SQLException e) {
                e.getMessage();
            }
            return conexion;
        }
}

