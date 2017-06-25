/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clientes;

/**
 *
 * @author SebasMaturana
 */
public class Cliente {

    private String dni;
    private String nombreC;
    private String apellidoC;
    private String direccion;
    private String telefono;
    private String celular;
    private String email;

    public Cliente() {
    }

    public Cliente(String dni, String nombre, String apellido, String direccion, String telefono, String celular, String email) {
        this.dni = dni;
        this.nombreC = nombre;
        this.apellidoC = apellido;
        this.direccion = direccion;
        this.celular = celular;
        this.telefono = telefono;
        this.email = email;
            
    }

    public Cliente(String dni, String nombre) {
        this.nombreC = nombreC;
        this.dni = dni;
    }

    /**
     * @return the dni
     */
    public String getDni() {
        return dni;
    }

    /**
     * @param dni the dni to set
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombreC;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombreC = nombreC;
    }

    /**
     * @return the apellidos
     */
    public String getApellido() {
        return apellidoC;
    }

    /**
     * @param apellido
     */
    public void setApellido(String apellido) {
               this.apellidoC = apellido;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public String getEmail() {
        return email;
    }

    /**
     * @param email the telefono to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    void setCelular(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    String getCelular() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    String geteEmail() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
