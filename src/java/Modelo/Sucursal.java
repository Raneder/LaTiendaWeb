/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Datos.EmpleadoDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class Sucursal {
    int idSucursal;
    String Descripcion;
    String Domicilio;
    String Telefono;
    // clases unidireccionales
    List<Empleado> Empleados;
 

    public Sucursal() {
        this.Empleados = new ArrayList<>();
    }

    public Sucursal(int idSucursal, String Descripcion, String Domicilio, String Telefono, List<Empleado> Empleados) {
        this.idSucursal = idSucursal;
        this.Descripcion = Descripcion;
        this.Domicilio = Domicilio;
        this.Telefono = Telefono;
        this.Empleados = Empleados;
    }

    public String getDescripcion() {
        return this.Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public int getIdSucursal() {
        return this.idSucursal;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }

    public String getDomicilio() {
        return this.Domicilio;
    }

    public void setDomicilio(String Domicilio) {
        this.Domicilio = Domicilio;
    }

    public String getTelefono() {
        return this.Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public List<Empleado> getEmpleados() {
        return this.Empleados;
    }

    public void setEmpleados(List<Empleado> Empleados) {
        this.Empleados = Empleados;
    }
}
