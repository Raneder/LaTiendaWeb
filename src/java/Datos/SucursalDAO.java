/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import Modelo.Empleado;
import Modelo.Sucursal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Usuario
 */
public class SucursalDAO {
   Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public Sucursal getSucursal( int idSucursal){
       Sucursal su = new Sucursal();
       String sql = "select *from sucursal where idSucursal=?";
       try{
           con=cn.Conexion();
           ps=con.prepareStatement(sql);
           ps.setInt(1, idSucursal);
           rs=ps.executeQuery();
           while (rs.next()){
               su.setIdSucursal(rs.getInt("idSucursal"));
               su.setDescripcion(rs.getString("Descripcion"));
               su.setDomicilio(rs.getString("Domicilio"));
               su.setTelefono(rs.getString("Telefono"));
            } 
        }catch ( SQLException e){
            }
       return su;
    } 
}
