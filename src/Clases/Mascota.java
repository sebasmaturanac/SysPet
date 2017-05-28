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
    private String dni;
    private String nombreMas;
    private String color;
    private String sexo;
    private String raza;
    private String edad;
    private double peso;
    private int dia;
    private int mes;
    private int año;
   

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
        return dni;
    }

    public void setDni(String Dni) {
        this.dni = Dni;
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
    
    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
     
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

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int setdia (){
        return dia;
    }
    
    public void getdia (int dia){
        this.dia = dia;
    }
    
      public int setmes (){
        return mes;
    }
    
    public void getmes (int mes){
        this.mes = mes;
    }
    
      public int setaño (){
        return año;
    }
    
    public void getaño (int año){
        this.año = año;
    }

    public String getaño() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
