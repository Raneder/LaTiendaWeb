/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import Modelo.Productotalle;
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
public class ProductotalleDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
      
    public Productotalle getProductoTalle( int id){
       Productotalle prot= new Productotalle();
       String sql = "select *from productotalle where id=?";
       try{
           con=cn.Conexion();
           ps=con.prepareStatement(sql);
           ps.setInt(1, id);
           rs=ps.executeQuery();
           while (rs.next()){
               
               prot.setIdproducto(rs.getInt("idproducto"));
               prot.setNtalle(rs.getInt("Ntalle"));
              
        } 
            }catch ( SQLException e){
            }
       return prot;
    }
    public ArrayList<Productotalle> listarTalle(int idproducto){
     ArrayList<Productotalle> Listprot;
      Listprot = new ArrayList<>();
      String sql =" select *from productotalle as pt,talle as t where pt.idproducto=? && pt.Ntalle=t.Ntalle";
       
       try{
           con=cn.Conexion();
           ps=con.prepareStatement(sql);
           ps.setInt(1, idproducto);
           rs=ps.executeQuery();
           while (rs.next()){
               Talle t = new Talle();
               Productotalle prot = new Productotalle();
               prot.setId(rs.getInt("pt.id"));
               prot.setIdproducto(rs.getInt("pt.idproducto"));
               prot.setNtalle(rs.getInt("pt.Ntalle"));
               
               t.setNtalle(rs.getInt("t.Ntalle"));
               t.setDescripcion(rs.getString("t.descripcion"));
               t.setTalle(rs.getString("t.talle"));
               
               prot.setTalle(t);
           Listprot.add(prot);

        } 
            }catch ( SQLException e){
            }
       return Listprot;
    }
    public int agregar(Productotalle prot){
            
       String sql = "insert into productotalle (id,idproducto,Ntalle) values(null,?,?)";
       try{
           con=cn.Conexion();
           ps=con.prepareStatement(sql);
           ps.setInt(1, prot.getIdproducto());
           ps.setInt(2, prot.getNtalle());
           ps.execute();
           
        
            }catch ( SQLException e){
            }
       return r;
     }
    public void eliminar (int id){
       String sql ="delete from productotalle where id="+id;
          try{
                 con=cn.Conexion();
                 ps=con.prepareStatement(sql);
                 ps.executeUpdate();
              }catch ( SQLException e){
                 }
           
     }

     
        
      
}

