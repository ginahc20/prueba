package database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ASUSROG
 */
public class AccesoDB {
    public static Connection getConnection() throws Exception {
        Connection cn = null;
        try {
            //1- cargar driver en memoria
            Class.forName("oracle.jdbc.OracleDriver");
            //url de la base de datos
            String url = "jdbc:oracle:thin:@localhost:1521:XE";
            // obtener la conexion
            cn = DriverManager.getConnection(url, "neptuno", "admin");

        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        }
        return cn;
    }
}
