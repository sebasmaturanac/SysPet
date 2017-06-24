/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clientes;

import Lib.DBConnection;
import Lib.MySQLDBManager;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Gabriel
 */
public class RegistrarClienteController {
    
    public RegistrarClientesView view;
    public Cliente model;
    
    public RegistrarClienteController(RegistrarClientesView view, Cliente model){
        this.view = view;
        this.model = model;
        this.view.setVisible(true);
        
        
        this.init();
    }
    
    private void init(){
        
        JButton btnRegistrarCliente = this.view.getBtnGuardarCliente();
        
        btnRegistrarCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarCliente();
            }
        });
    }
    
    private void registrarCliente(){
        JTextField fdApellido = this.view.getFdApellido();
        JTextField fdNombre = this.view.getFdNombre();
        JTextField fdDni = this.view.getFdClienteDNI();
        JTextField fdDireccion = this.view.getFdDireccion();
        JTextField fdCelular = this.view.getFdCelular();
        
        this.model.setApellidos(fdApellido.getText());
        this.model.setNombre(fdNombre.getText());
        this.model.setDni(fdDni.getText());
        this.model.setDireccion(fdDireccion.getText());
        this.model.setTelefono(fdCelular.getText());
        
        DBConnection db = new MySQLDBManager("localhost", "syspet", "root", "");
       
        String query = "INSERT INTO Cliente (ApellidoC, NombreC, DNI, Direccion, Telefono) VALUES ("
                + db.quotate(this.model.getApellidos()) + ","
                + db.quotate(this.model.getNombre()) + ","
                + db.quotate(this.model.getDni()) + ","
                + db.quotate(this.model.getDireccion()) + ","
                + db.quotate(this.model.getTelefono()) + ")";
            
        int result = db.executeUpdate(query);
        
        if(result > 0){
            JOptionPane.showMessageDialog(view, "Se han insertado " + result + "registro(s)");
        }else{
            JOptionPane.showMessageDialog(view, "Ocurrio un problema al intentar insertar un registro.");
        }
 
    }
    
    
    
}
