/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;


import Modelo.Producto;
import Datos.Conexion;
import Modelo.Marca;
import Modelo.Rubro;

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
public class ProductoDAO {
  Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public Producto getProducto( int idproducto){
       Producto pro= new Producto();
       String sql = "select *from producto where idproducto=?";
       try{
           con=cn.Conexion();
           ps=con.prepareStatement(sql);
           ps.setInt(1, idproducto);
           rs=ps.executeQuery();
           while (rs.next()){
               
               pro.setDescripcion(rs.getString("descripcion"));
               pro.setCosto(rs.getDouble("costo"));
               pro.setMargenGanancia(rs.getDouble("margenGanancia"));
               pro.setIVA(rs.getDouble("IVA"));
               pro.setMargenGanancia(rs.getInt("margenGanancia"));
        } 
            }catch ( SQLException e){
            }
       return pro;
    }
  

     //OPERACIONES CRUD

     public ArrayList<Producto> listar(){
     ArrayList<Producto> Listpro;
      Listpro = new ArrayList<>();
       String sql ="select *from producto as p,rubro as r,marca as m where p.idrubro=r.idrubro && p.idMarca=m.idMarca order by p.idproducto";
       try{
           con=cn.Conexion();
           ps=con.prepareStatement(sql);
           rs=ps.executeQuery();
           while (rs.next()){
               Producto pro = new Producto();
               pro.setIdproducto(rs.getInt("idproducto"));
               pro.setDescripcion(rs.getString("descripcion"));
               pro.setCosto(rs.getDouble("costo"));
               pro.setMargenGanancia(rs.getDouble("margenGanancia"));
               pro.setIVA(rs.getDouble("IVA"));
               pro.setNetoGravado(rs.getDouble("netoGravado"));
               Rubro ru = new Rubro();
               Marca m = new Marca();
               
               ru.setDescripcion(rs.getString("r.descripcion"));
               ru.setIdrubro(rs.getInt("r.idrubro"));
               m.setIdMarca(rs.getInt("m.idMarca"));
               m.setDescripcion(rs.getString("m.descripcion")); 
               pro.setRubro(ru);
               pro.setMarca(m);
               Listpro.add(pro);
        } 
            }catch ( SQLException e){
            }
       return Listpro;
     }
     public int agregar(Producto pro){
            
       String sql = "insert into producto (idproducto,descripcion,costo,margenGanancia,IVA,netoGravado,idrubro,idMarca)values (null,?,?,?,?,?,?,?)";
       try{
           con=cn.Conexion();
           ps=con.prepareStatement(sql);
           ps.setString(1, pro.getDescripcion());
           ps.setDouble(2, pro.getCosto());
           ps.setDouble(3, pro.getMargenGanancia());
           ps.setDouble(4, pro.getIVA());
           ps.setDouble(5, pro.getNetoGravado());
           ps.setInt(6, pro.getidRubro());
           ps.setInt(7, pro.getidMarca());
           
           //ps.setInt(6, pro.getRubro().);Armar Clase y dar valores update producto set campos = where idproducto - delete where idproducto
           //ps.setInt(7, pro.getMarca()); Armar Clase y dar valores
           ps.executeUpdate();
           
        
            }catch ( SQLException e){
            }
       return r;
     }
     public Producto listarId(int id){
       Producto pro = new Producto();
       String sql ="select *from producto where idproducto=?";
       try{
           con = cn.Conexion();
           ps = con.prepareStatement(sql);
           ps.setInt(1, id);
           rs = ps.executeQuery();
           while (rs.next()){
             pro.setIdproducto(rs.getInt("idproducto"));
             pro.setDescripcion(rs.getString("descripcion"));
             pro.setCosto(rs.getDouble("costo"));
             pro.setMargenGanancia(rs.getDouble("margenGanancia"));
             pro.setIVA(rs.getDouble("IVA"));
             pro.setNetoGravado(rs.getDouble("netoGravado"));
             //pro.calcularNetoGravado();
             Rubro ru = new Rubro();
             Marca m = new Marca();
             ru.setDescripcion(rs.getString("r.descripcion"));
             ru.setIdrubro(rs.getInt("r.idrubro"));
             m.setIdMarca(rs.getInt("m.idMarca"));
             m.setDescripcion(rs.getString("m.descripcion")); 
             pro.setRubro(ru);
             pro.setMarca(m);
          }
       } catch ( SQLException e){
       }
       return pro;
     }
     
     public int modificar ( Producto pro){
          String sql ="update producto set descripcion=?,costo=?,margenGanancia=?,IVA=?,netoGravado=?,idrubro=?,idMarca=? where idproducto=?";
          try{
           con=cn.Conexion();
           ps=con.prepareStatement(sql);
           ps.setString(1, pro.getDescripcion());
           ps.setDouble(2, pro.getCosto());
           ps.setDouble(3, pro.getMargenGanancia());
           ps.setDouble(4, pro.getIVA());
           ps.setDouble(5, pro.getNetoGravado());
           ps.setInt(6, pro.getidRubro());
           ps.setInt(7, pro.getidMarca());
           ps.setInt(8,pro.getIdproducto());
           
           //ps.setInt(6, pro.getRubro().);Armar Clase y dar valores update producto set campos = where idproducto - delete where idproducto
           //ps.setInt(7, pro.getMarca()); Armar Clase y dar valores
           ps.execute();
           
        
            }catch ( SQLException e){
            }
            return r;
     }
     
     public void eliminar (int idproducto){
       String sql ="delete from producto where idproducto="+idproducto;
          try{
                 con=cn.Conexion();
                 ps=con.prepareStatement(sql);
                 ps.executeUpdate();
              }catch ( SQLException e){
                 }
           
     }
}