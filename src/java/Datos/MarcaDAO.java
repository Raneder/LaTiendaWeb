/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import Modelo.Marca;
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
public class MarcaDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public Marca getMarca( int idMarca){
       Marca m = new Marca();
       String sql = "select *from marca where idMarca=?";
       try{
           con=cn.Conexion();
           ps=con.prepareStatement(sql);
           ps.setInt(1, idMarca);
           rs=ps.executeQuery();
           while (rs.next()){
               m.setIdMarca(rs.getInt("idMarca"));
               m.setDescripcion(rs.getString("descripcion"));
            } 
        }catch ( SQLException e){
            }
       return m;
    }
    
    //OPERACIONES CRUD
    
    public ArrayList<Marca> listar(){
     ArrayList<Marca> Listma;
      Listma = new ArrayList<>();
       String sql ="select *from marca";
       try{
           con=cn.Conexion();
           ps=con.prepareStatement(sql);
           rs=ps.executeQuery();
           while (rs.next()){
               Marca ma = new Marca();
               ma.setIdMarca(rs.getInt("idMarca"));
               ma.setDescripcion(rs.getString("descripcion"));
               
           Listma.add(ma);

        } 
            }catch ( SQLException e){
            }
       return Listma;
}
   public Marca listarId(int id){
      Marca mar = new Marca();
      String sql = "select *from marca where idMarca=?";
      try {
         con=cn.Conexion();
         ps=con.prepareStatement(sql);
         ps.setInt(1, id);
         rs=ps.executeQuery();
         while (rs.next()){
             mar.setIdMarca(id);
             mar.setDescripcion(rs.getString("descripcion"));;
         }
      }catch (SQLException e){
          
      }
  return mar;
   }
   public int agregar(Marca ma){
       String sql = "insert into marca (idMarca, descripcion)values (null,?)";
       try {
            con = cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, ma.getDescripcion());
            ps.executeUpdate();
       }catch (SQLException e){
       }
       return r;
   }
   public int actualizar(Marca ma){
        String sql = "update marca set descripcion=? where idMarca =?";
       try {
            con = cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, ma.getDescripcion());
            ps.setInt(2,ma.getIdMarca());
            ps.executeUpdate();
       }catch (SQLException e){
       }
       return r;
   }
   public void eliminar (int idmarca){
      String sql ="delete from marca where idmarca =" +idmarca;
      try {
          con = cn.Conexion();
          ps=con.prepareStatement(sql);
          ps.executeUpdate();
      } catch ( SQLException e){
      
      }
   }
}