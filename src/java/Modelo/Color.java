/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Usuario
 */
public class Color {
    int idColor;
    String Descripcion;
    
    Producto producto;
    int idProducto;
    
    public Color(){
    this.producto=null;
    }
     public Color(int idColor, String Descripcion, Producto producto,int idProducto) {
        this.idColor=idColor;
        this.Descripcion=Descripcion;
        
        this.idProducto=idProducto;
        this.producto=producto;
    }
    public Color(int idProducto) {
        this.idProducto = idProducto;
    }
    public Color(int idColor, String Descripcion,String Color) {
        this.idColor=idColor;
        this.Descripcion=Descripcion;
        
        this.producto=null;
    }
    public Color(int idColor, String Descripcion,String Color,int idProducto) {
        this.idColor=idColor;
        this.Descripcion=Descripcion;
       
        this.idProducto=idProducto;
    }
    
    public int getIdColor() {
        return idColor;
    }

    public void setIdColor(int idColor) {
        this.idColor = idColor;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
    
    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }
}
