/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Usuario
 */
public class Conexion {
    Connection conectar; 
   
    public Connection Conexion(){
        try {
           Class.forName("com.mysql.jdbc.Driver");
            conectar = DriverManager.getConnection("jdbc:mysql://localhost:3306/latienda?" +
                                   "user=root&password=");
        } catch (ClassNotFoundException | SQLException e) {
        }
        return conectar;
                }
        Connection getConnection() {
        return conectar; 
}
}
