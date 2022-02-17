/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Datos.UsuarioDAO;

/**
 *
 * @author Usuario
 */
public class Tipousuario {
    int idTipoUsuario;
    String descripcion;
    int idUsuario;
    Usuario usuario;

    public Tipousuario(){
    this.usuario=null;
    }

    public int getIdTipoUsuario() {
        return idTipoUsuario;
    }
    public Usuario getUsuario(){
	//si no hay empelado, lo cargamos de la DB
        return usuario;
}
    public void setIdTipoUsuario(int idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }


    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Tipousuario(int idTipoUsuario, String descripcion, int idUsuario, Usuario usuario) {
        this.idTipoUsuario = idTipoUsuario;
        this.descripcion = descripcion;
        this.idUsuario = idUsuario;
        this.usuario = usuario;
    }

    public void setidUsuario(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
