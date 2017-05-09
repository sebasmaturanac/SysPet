/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author SebastianMaturanac
 */
public class PersistenciaPersona{
    
        public static void SaveData(ArrayList<Persona> listProducto) {
        try {
            FileOutputStream file = new FileOutputStream("Persona.ser");
            ObjectOutputStream stream = new ObjectOutputStream(file);
            stream.writeObject(listProducto);
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static ArrayList<Persona> LoadData() {
        ArrayList<Persona> listProducto = null;
        try {
            FileInputStream file = new FileInputStream("Persona.ser");
            ObjectInputStream stream = new ObjectInputStream(file);
            listProducto = (ArrayList<Persona>) stream.readObject();
            stream.close();
        } catch (Exception e) {
            e.printStackTrace();
            listProducto = null;
        }        
        return (listProducto!=null)? listProducto : 
                                new ArrayList<Persona>();             
    }
    
}
