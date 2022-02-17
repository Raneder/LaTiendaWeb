/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Usuario
 */
public class Productocolor {
    int id;
    int idproducto;
    int idcolor;
    Color color;
    
    public Productocolor(int id, int idproducto, int idcolor, Color color){
    this.id = id;
    this.idproducto = idproducto;
    this.idcolor = idcolor;
    this.color = color;
    }
    public Productocolor() {
      color = null;  
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

    public int getIdColor() {
        return idcolor;
    }

    public void setIdColor(int idcolor) {
        this.idcolor = idcolor;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    
}
