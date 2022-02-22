/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Usuario
 */
class Cliente {
    int idCliente;
    String CUIT;
    String ApyNom;
    int idcondiciontributaria;
    Condiciontributaria condiciontributaria;

    public Cliente(){
    this.condiciontributaria=null;
    }
    public Cliente(int idCliente, String CUIT, String ApyNom, int idcondiciontributaria, Condiciontributaria condiciontributaria) {
        this.idCliente = idCliente;
        this.CUIT = CUIT;
        this.ApyNom = ApyNom;
        this.idcondiciontributaria = idcondiciontributaria;
        this.condiciontributaria = condiciontributaria;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getCUIT() {
        return CUIT;
    }

    public void setCUIT(String CUIT) {
        this.CUIT = CUIT;
    }

    public String getApyNom() {
        return ApyNom;
    }

    public void setApyNom(String ApyNom) {
        this.ApyNom = ApyNom;
    }

    public int getIdcondiciontributaria() {
        return idcondiciontributaria;
    }

    public void setIdcondiciontributaria(int idcondiciontributaria) {
        this.idcondiciontributaria = idcondiciontributaria;
    }

    public Condiciontributaria getCondiciontributaria() {
        return condiciontributaria;
    }

    public void setCondiciontributaria(Condiciontributaria condiciontributaria) {
        this.condiciontributaria = condiciontributaria;
    }
    
    
}
