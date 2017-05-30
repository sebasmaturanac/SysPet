/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clientes;

import java.util.ArrayList;

/**
 *
 * @author Gabriel
 */
public class Clientes {
    private ArrayList<Cliente> list;
    
   public Clientes(){
       list = new ArrayList<Cliente>();
   }
   
   public ArrayList<Cliente> getClientes(){
       return this.list;
   }
   
   public void setClientes(ArrayList<Cliente> clientes){
       this.list = clientes;
   }
   
   
    
}
