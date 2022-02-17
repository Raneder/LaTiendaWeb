/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Usuario
 */
public class Talle {
    int Ntalle;
    String Descripcion;
    String Talle;
    int idProducto;
    Producto producto;
    
    public Talle(){
    this.producto=null;
    }
    public Talle(int Ntalle, String Descripcion, String Talle, int idProducto, Producto producto) {
        this.Ntalle=Ntalle;
        this.Descripcion=Descripcion;
        this.Talle=Talle;
        this.idProducto=idProducto;
        this.producto=producto;
        
    }
    
    public Talle(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getNtalle() {
        return Ntalle;
    }

    public void setNtalle(int Ntalle) {
        this.Ntalle = Ntalle;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getTalle() {
        return Talle;
    }

    public void setTalle(String Talle) {


        this.Talle = Talle;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
   
     
}
