package com.example.demo.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final String URL = "jdbc:mysql://yamanote.proxy.rlwy.net:48592/railway?useSSL=true&allowPublicKeyRetrieval=true
";
    private static final String USER = "root"; 
    private static final String PASSWORD = "NFLtDsIUQMYWdUaVcUKkzCVviCfgPppy";

    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión exitosa a Railway");
        } catch (SQLException e) {
            System.out.println("Error en la conexión: " + e.getMessage());
        }
        return conn;
    }
}


