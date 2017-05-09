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
public class PersistenciaCliente{
    
    public static void SaveData(ArrayList<Cliente> listProducto) {
        try {
            FileOutputStream file = new FileOutputStream("Cliente.ser");
            ObjectOutputStream stream = new ObjectOutputStream(file);
            stream.writeObject(listProducto);
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static ArrayList<Cliente> LoadData() {
        ArrayList<Cliente> listProducto = null;
        try {
            FileInputStream file = new FileInputStream("Cliente.ser");
            ObjectInputStream stream = new ObjectInputStream(file);
            listProducto = (ArrayList<Cliente>) stream.readObject();
            stream.close();
        } catch (Exception e) {
            e.printStackTrace();
            listProducto = null;
        }        
        return (listProducto!=null)? listProducto : 
                                new ArrayList<Cliente>();             
    }
    
}
