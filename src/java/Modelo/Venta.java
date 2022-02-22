/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Date;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class Venta {
    int idventa;
    Date fecha;
    int idCliente;
    Cliente cliente;
    List detalleVenta;
    
  public Venta() {
        this.detalleVenta=null;
        this.cliente= null;
    }
  
public Venta(int idventa, Date fecha, int idCliente, Cliente cliente) {
        this.idventa = idventa;
        this.fecha = fecha;
        this.idCliente = idCliente;
        this.cliente = cliente;
    }


    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List getDetalleVenta() {
        return detalleVenta;
    }

    public void setDetalleVenta(List detalleVenta) {
        this.detalleVenta = detalleVenta;
    }

    public int getIdventa() {
        return idventa;
    }

    public void setIdventa(int idventa) {
        this.idventa = idventa;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    
}
