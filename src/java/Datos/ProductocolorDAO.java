/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import Modelo.Color;
import Modelo.Productocolor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class ProductocolorDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public Productocolor getProductocolor( int id){
       Productocolor proc= new Productocolor();
       String sql = "select *from productocolor where id=?";
       try{
           con=cn.Conexion();
           ps=con.prepareStatement(sql);
           ps.setInt(1, id);
           rs=ps.executeQuery();
           while (rs.next()){
               
               proc.setIdproducto(rs.getInt("idproducto"));
               proc.setIdColor(rs.getInt("idColor"));
              
        } 
            }catch ( SQLException e){
            }
       return proc;
    }
    
    public ArrayList<Productocolor> listarColores(int idproducto){
     ArrayList<Productocolor> Listproc;
      Listproc = new ArrayList<>();
      String sql ="select * from productocolor as pc left join color as c on pc.idColor = c.idColor where pc.idproducto=?";
       
       try{
           con=cn.Conexion();
           ps=con.prepareStatement(sql);
           ps.setInt(1, idproducto);
           rs=ps.executeQuery();
           while (rs.next()){
               Color c = new Color();
               Productocolor proc = new Productocolor();
               proc.setId(rs.getInt("pc.id"));
               proc.setIdproducto(rs.getInt("pc.idproducto"));
               proc.setIdColor(rs.getInt("pc.idColor"));
               
               
               c.setIdColor(rs.getInt("c.idColor"));
               c.setDescripcion(rs.getString("c.descripcion"));
               proc.setColor(c);
               
               
           Listproc.add(proc);

        } 
            }catch ( SQLException e){
            }
       return Listproc;
    }
    public int agregar(Productocolor proc){
            
       String sql = "insert into productocolor (id,idproducto,idColor) values(null,?,?)";
       try{
           con=cn.Conexion();
           ps=con.prepareStatement(sql);
           ps.setInt(1, proc.getIdproducto());
           ps.setInt(2, proc.getIdColor());
           ps.execute();
           
        
            }catch ( SQLException e){
            }
       return r;
     }
    public void eliminar (int id){
       String sql ="delete from productocolor where id="+id;
          try{
                 con=cn.Conexion();
                 ps=con.prepareStatement(sql);
                 ps.executeUpdate();
              }catch ( SQLException e){
                 }
           
     }
}
