/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.Serializable;

/**
 *
 * @author SebastianMaturanac
 */
public class Persona implements Serializable{
    private Cliente nombre;
    private Cliente apellidos;
    private Cliente direccion;
    private Cliente telefono;

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

    public Cliente getDireccion() {
        return direccion;
    }

    public void setDireccion(Cliente direccion) {
        this.direccion = direccion;
    }

    public Cliente getTelefono() {
        return telefono;
    }

    public void setTelefono(Cliente telefono) {
        this.telefono = telefono;
    }
    
    
}
