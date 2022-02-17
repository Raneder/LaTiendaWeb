/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import Modelo.Rubro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class RubroDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public Rubro getRubro( int idRubro){
       Rubro ru = new Rubro();
       String sql = "select *from rubro where idrubro=?";
       try{
           con=cn.Conexion();
           ps=con.prepareStatement(sql);
           ps.setInt(1, idRubro);
           rs=ps.executeQuery();
           while (rs.next()){
               ru.setIdrubro(rs.getInt("idrubro"));
               ru.setDescripcion(rs.getString("descripcion"));
            } 
        }catch ( SQLException e){
            }
       return ru;
    } 

    public ArrayList<Rubro> listar(){
     ArrayList<Rubro> Listru;
      Listru = new ArrayList<>();
       String sql ="select *from rubro";
       try{
           con=cn.Conexion();
           ps=con.prepareStatement(sql);
           rs=ps.executeQuery();
           while (rs.next()){
               Rubro ru = new Rubro();
               ru.setIdrubro(rs.getInt("idrubro"));
               ru.setDescripcion(rs.getString("descripcion"));

           Listru.add(ru);

        } 
            }catch ( SQLException e){
            }
       return Listru;
}
}
