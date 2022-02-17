/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import Modelo.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class ColorDAO {
     Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public Color getColor(int idColor){
        Color co = new Color();
        String sql = "select *from color where idColor=?";
        try{
           con=cn.Conexion();
           ps=con.prepareStatement(sql);
           ps.setInt(1, idColor);
           rs=ps.executeQuery();
           while (rs.next()){
               co.setIdColor(rs.getInt("idColor"));
               co.setDescripcion(rs.getString("descripcion"));
               
            }
           }catch ( SQLException e){
           }
           return co;
    }
     public ArrayList<Color> listar(){
     ArrayList<Color> Listco;
      Listco = new ArrayList<>();
       String sql ="select * from color";
       try{
           con=cn.Conexion();
           ps=con.prepareStatement(sql);
           rs=ps.executeQuery();
           while (rs.next()){
               Color co = new Color();
               co.setIdColor(rs.getInt("idColor"));
               co.setDescripcion(rs.getString("descripcion"));
               //co.setColor(rs.getString("color"));

           Listco.add(co);

        } 
            }catch ( SQLException e){
            }
       return Listco;
}
}
