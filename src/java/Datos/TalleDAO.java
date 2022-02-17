/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import Modelo.Rubro;
import Modelo.Talle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class TalleDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public Talle getTalle(int Ntalle){
        Talle ta = new Talle();
        String sql = "select *from talle where Ntalle=?";
        try{
           con=cn.Conexion();
           ps=con.prepareStatement(sql);
           ps.setInt(1, Ntalle);
           rs=ps.executeQuery();
           while (rs.next()){
               ta.setNtalle(rs.getInt("Ntalle"));
               ta.setDescripcion(rs.getString("descripcion"));
               ta.setTalle(rs.getString("talle"));
            }
           }catch ( SQLException e){
           }
           return ta;
    }
     public ArrayList<Talle> listar(){
     ArrayList<Talle> Listta;
      Listta = new ArrayList<>();
       String sql ="select *from talle";
       try{
           con=cn.Conexion();
           ps=con.prepareStatement(sql);
           rs=ps.executeQuery();
           while (rs.next()){
               Talle ta = new Talle();
               ta.setNtalle(rs.getInt("Ntalle"));
               ta.setDescripcion(rs.getString("descripcion"));
               ta.setTalle(rs.getString("talle"));

           Listta.add(ta);

        } 
            }catch ( SQLException e){
            }
       return Listta;
}
}
