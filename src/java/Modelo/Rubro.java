/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Usuario
 */
public class Rubro {
    int idrubro;
    String descripcion;
    Producto producto;
    
    public Rubro(){
    this.producto=null;
    }

    public Rubro(int idrubro, String descripcion, Producto producto) {
        this.idrubro = idrubro;
        this.descripcion = descripcion;
        this.producto = producto;
    }

    public int getIdrubro() {
        return idrubro;
    }

    public void setIdrubro(int idrubro) {
        this.idrubro = idrubro;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
}

