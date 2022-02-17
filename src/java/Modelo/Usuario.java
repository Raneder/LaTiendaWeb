/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Datos.EmpleadoDAO;
import Datos.TipousuarioDAO;

/**
 *
 * @author Usuario
 */
public class Usuario {
  int idUsuario;
  String NombreUsuario;
  String Clave;
  int idEmpleado;
  int idtipoUsuario;
  Empleado empleado;
  Tipousuario tipousuario;

    public Usuario() {
        this.empleado=null;
        this.tipousuario=null;
    }

    public Usuario(int idUsuario, String NombreUsuario, String Clave, int idEmpleado, int tipoUsuario, Empleado empleado, Tipousuario tipousuario) {
        this.idUsuario = idUsuario;
        this.NombreUsuario = NombreUsuario;
        this.Clave = Clave;
        this.idEmpleado = idEmpleado;
        this.idtipoUsuario = tipoUsuario;
        this.empleado = empleado;
        
    }

    public Usuario(int idTu) {
        TipousuarioDAO tuDAO = new TipousuarioDAO(); //To change body of generated methods, choose Tools | Templates.
        this.tipousuario=tuDAO.getTipousuario(idTu);
    }

    public Tipousuario getTipousuario() {
        return tipousuario;
    }

    public void setTipousuario(Tipousuario tipousuario) {
        this.tipousuario = tipousuario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

public Empleado getEmpleado(){
	//si no hay empelado, lo cargamos de la DB
        return empleado;
}
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return NombreUsuario;
    }

    public void setNombreUsuario(String NombreUsuario) {
        this.NombreUsuario = NombreUsuario;
    }

    public String getClave() {
        return Clave;
    }

    public void setClave(String Clave) {
        this.Clave = Clave;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getidTipoUsuario() {
        return idtipoUsuario;
    }

    public void setidTipoUsuario(int tipoUsuario) {
        this.idtipoUsuario = tipoUsuario;
    }

    void setUsuario(Tipousuario aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  
      
}
