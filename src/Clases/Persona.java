/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.Serializable;

/**
 ***
 * @author SebastianMaturanac
 */
public class Persona implements Serializable{
    private Cliente nombre;
    private Cliente apellidos;
    private Cliente dni;
    private Cliente direccion;
    private Cliente celular;
    private Cliente correo;
    

    public Cliente getNombre() {
        return nombre;
    }

    public void setNombre(Cliente nombre) {
        this.nombre = nombre;
    }

    public Cliente getApellidos() {
        return apellidos;
    }

    public void setApellidos(Cliente apellidos) {
        this.apellidos = apellidos;
    }
    public Cliente getDni(){
        return dni;
    }
    
    public void setDni(Cliente dni){
        this.dni=dni;
    }

    public Cliente getDireccion() {
        return direccion;
    }

    public void setDireccion(Cliente direccion) {
        this.direccion = direccion;
    }

    public Cliente getCelular() {
        return celular;
    }

    public void setCelular(Cliente celular) {
        this.celular = celular;
    }
    
    
}
