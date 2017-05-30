/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mascota;

/**
 *
 * @author Sebas
 */
public class Mascota {
    private String nombre;
    private String color;
    private String raza;
    private String fechaNacimiento;
    private String sexo;

    public Mascota() {
    }
/**
 Agregar otros atributos si es necesario y modificar la View
  
**/
    
    /**
     * Agregar otros atributos si es necesario y modificar la View
     * 
     * @param nombre
     * @param color
     * @param raza
     * @param fechaNacimiento
     * @param sexo
     */
    public Mascota(String nombre, String color, String raza, String fechaNacimiento, String sexo) {
 
        this.nombre = nombre;
        this.color = color;
        this.raza = raza;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
    }
}
