 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;


import Modelo.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;


public class UsuarioDAO  {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public Usuario validar( String NombreUsuario, String Clave){
       Usuario us = null;
       String sql = "select *from usuario where NombreUsuario=? and Clave=?";
       try{
           con=cn.Conexion();
           ps=con.prepareStatement(sql);
           ps.setString(1, NombreUsuario);
           ps.setString(2, Clave);
           rs=ps.executeQuery();
           while (rs.next()){
               us= new Usuario(rs.getInt("idtipousuario"));
               us.setIdUsuario(rs.getInt("idUsuario"));
               us.setNombreUsuario(rs.getString("NombreUsuario"));
               us.setClave(rs.getString("Clave"));
               us.setIdEmpleado(rs.getInt("idEmpleado"));
               
           } 
            }catch ( SQLException e){
            }
       return us;
    }

    public Usuario getUsuario(int idUsuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
