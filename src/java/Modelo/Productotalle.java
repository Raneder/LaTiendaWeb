/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Usuario
 */
public class Productotalle {
    int id;
    int idproducto;
    int Ntalle;
    Talle talle;
    
    public Productotalle(int id, int idproducto, int Ntalle, Talle talle){
    this.id = id;
    this.idproducto = idproducto;
    this.Ntalle = Ntalle;
    this.talle = talle;
    }

    public Productotalle() {
      talle = null;  
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public int getNtalle() {
        return Ntalle;
    }

    public void setNtalle(int Ntalle) {
        this.Ntalle = Ntalle;
    }

    public Talle getTalle() {
        return talle;
    }

    public void setTalle(Talle talle) {
        this.talle = talle;
    }
    
    
}
