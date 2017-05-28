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
public class Mascota implements Serializable{
    private int id;
    private String nombreCli;
    private String dniCli;
    private String nombreMas;
    private String color;
    private String sexo;
    private String raza;
    private String edad;
    private double peso;
    private Date fechaNac;
   

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    

    public String getNombreCli() {
        return nombreCli;
    }

    public void setNombreCli(String nombreCli) {
        this.nombreCli = nombreCli;
    }

    public String getDni() {
        return Dni;
    }

    public void setDni(String Dni) {
        this.Dni = Dni;
    }

    public String getNombreMas() {
        return nombreMas;
    }

    public void setNombreMas(String nombreMas) {
        this.nombreMas = nombreMas;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public double getPezo() {
        return peso;
    }

    public void setPezo(double pezo) {
        this.peso = pezo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    
    
}
