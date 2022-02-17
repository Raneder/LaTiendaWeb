/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Datos.SucursalDAO;

/**
 *
 * @author Usuario
 */
public class Empleado {
    int idEmpleado;
    String Nombre;
    String Apellido;
    String DNI;
    String Domicilio;
    String Telefono;
    int idSucursal;
    Usuario usuario;
    Sucursal sucursal;

    public Empleado() {
        this.usuario=null;
        this.sucursal=null;
    }

    public Empleado(int idEmpleado, String Nombre, String Apellido, String DNI, String Domicilio, String Telefono, int idSucursal, Usuario usuario, Sucursal sucursal) {
        this.idEmpleado = idEmpleado;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.DNI = DNI;
        this.Domicilio = Domicilio;
        this.idSucursal = idSucursal;
        this.Telefono = Telefono;
        this.usuario= usuario;
        this.sucursal= sucursal;
        
    }

    public Empleado(int idSucursal) {
        this.idSucursal = idSucursal;
    }
    
    public Empleado(int idEmpleado, String Nombre, String Apellido, String DNI, String Domicilio, String Telefono) {
        this.idEmpleado = idEmpleado;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.DNI = DNI;
        this.Domicilio = Domicilio;
        this.Telefono = Telefono;
        this.usuario= null;
        this.sucursal=null;
    }
    
    public Empleado(int idEmpleado, String Nombre, String Apellido, String DNI, String Domicilio, String Telefono,int idSucursal) {
        this.idEmpleado = idEmpleado;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.DNI = DNI;
        this.Domicilio = Domicilio;
        this.Telefono = Telefono;
        this.idSucursal=idSucursal;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getNombreCompleto() {
        return  this.Nombre+" "+this.Apellido;
    }

    public void setNombreCompleto(String Nombre, String Apellido) {
        this.Nombre = Nombre;
        this.Apellido = Apellido;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getDomicilio() {
        return Domicilio;
    }

    public void setDomicilio(String Domicilio) {
        this.Domicilio = Domicilio;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

      public int getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }
    
}
