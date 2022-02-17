/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;


import Modelo.Tipousuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Usuario
 */
public class TipousuarioDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
   public Tipousuario getTipousuario(int idTipoUsuario ){
       Tipousuario tu = new Tipousuario();
       String sql = "select *from tipousuario where idTipoUsuario=?";
       try{
           con=cn.Conexion();
           ps=con.prepareStatement(sql);
           ps.setInt(1, idTipoUsuario);
           rs=ps.executeQuery();
           while (rs.next()){
               tu.setIdTipoUsuario(rs.getInt("idTipoUsuario"));
               tu.setDescripcion(rs.getString("Descripcion"));
               tu.setidUsuario(rs.getString("idUdsuario"));
            } 
        }catch ( SQLException e){
            }
       return tu;
    } 

    public Tipousuario validar(String usuario, String clave) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
