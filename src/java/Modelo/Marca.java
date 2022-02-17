/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Usuario
 */
public class Marca {
    int idMarca;
    String descripcion;
    Producto producto;

    public Marca() {
        this.producto=null;
    }

    public Marca(int idMarca, String descripcion, Producto producto) {
        this.idMarca = idMarca;
        this.descripcion = descripcion;
        this.producto = producto;
    }

    public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public void setDescripcion(int idmarca) {
        this.idMarca = idmarca;
    }
    
    
    
}
