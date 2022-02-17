/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;


import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class Producto {
    int idproducto;
   
    String Descripcion;
    double costo;
    double margenGanancia;
    double netoGravado;
    double IVA;
    int idrubro;
    int idmarca;
    Rubro rubro;
    Marca marca;
    List<Talle> talles;
    List<Color> colores;

    public Producto() {
     
    }
    

    public Producto(int idproducto, String Descripcion, double costo, double margenGanancia, double netoGravado, double IVA, int idrubro, int idmarca, Rubro rubro, Marca marca,List<Talle> talles, List<Color> colores) {
        
        this.idproducto = idproducto;
        this.Descripcion = Descripcion;
        this.costo = costo;
        this.margenGanancia = margenGanancia;
        this.netoGravado = netoGravado;
        this.IVA = IVA;
        this.idrubro = idrubro;
        this.idmarca = idmarca;
        this.rubro = rubro;
        this.marca = marca;
        this.talles = talles;
        this.colores = colores;
        
        
    }

    public List<Talle> getTalles() {
        return talles;
    }

    public void setTalles(List<Talle> talles) {
        this.talles = talles;
    }

  

    public int getIdproducto() {
        return idproducto;
    }

    public Producto(int idrubro, int idmarca) {
        this.idrubro = idrubro;
        this.idmarca = idmarca;
       
    }

    

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }
  
    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public double getMargenGanancia() {
        return margenGanancia;
    }

    public void setMargenGanancia(double margenGanancia) {
        this.margenGanancia = margenGanancia;
    }

    public double getIVA() {
        return IVA;
    }

    public void setIVA(double IVA) {
        this.IVA = IVA;
    }

    public Rubro getRubro() {
        return rubro;
    }

    public void setRubro(Rubro rubro) {
        this.rubro = rubro;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

 

    public int getidRubro() {
        return idrubro;
    }

    public void setidRubro(int idrubro) {
        this.idrubro = idrubro;
    }

    public int getidMarca() {
        return idmarca;
    }

    public void setidMarca(int idmarca) {
        this.idmarca = idmarca;
    }

    public double getNetoGravado() {
        return this.costo+this.costo*margenGanancia/100;
    }

    public double calcularIVA() {
        return this.getNetoGravado()*this.IVA/100;
    }

    public double getPrecioVenta() {
        return this.getNetoGravado() + this.calcularIVA();
    }

    public List<Color> getColores() {
        return colores;
    }

    public void setColores(List<Color> colores) {
        this.colores = colores;
    }

    public void setNetoGravado(double netogravado) {
       this.netoGravado = netogravado;
    }

    
}  
