/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clientes;

import Lib.DBConnection;
import Lib.MySQLDBManager;
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
        
        JButton btnGuardarCliente;
        btnGuardarCliente = this.view.getBtnGuardarCliente();
        
        btnGuardarCliente.addActionListener((ActionEvent e) -> {
            registrarCliente();
        });
    }
    
    private void registrarCliente(){
        JTextField fdApellido = this.view.getFdApellido();
        JTextField fdNombre = this.view.getFdNombre();
        JTextField fdDni = this.view.getFdClienteDNI();
        JTextField fdDireccion = this.view.getFdDireccion();
        JTextField fdCelular = this.view.getFdCelular();
        JTextField fdTelefono = this.view.getFdTelefono ();
        JTextField fdEmail = this.view.getFdEmail ();

        
        
        this.model.setApellido(fdApellido.getText());
        this.model.setNombre(fdNombre.getText());
        this.model.setDni(fdDni.getText());
        this.model.setDireccion(fdDireccion.getText());
        this.model.setCelular(fdCelular.getText());
        this.model.setTelefono(fdTelefono.getText());
        this.model.setEmail(fdEmail.getText());
        
        DBConnection db = new MySQLDBManager("localhost", "syspet", "root", "");
       
        String query = "INSERT INTO Cliente (ApellidoC, NombreC, DNI, Direccion, Celular, Telefono, Email) VALUES ("
                + db.quotate(this.model.getApellido()) + ","
                + db.quotate(this.model.getNombre()) + ","
                + db.quotate(this.model.getDni()) + ","
                + db.quotate(this.model.getDireccion()) + ","
                + db.quotate(this.model.getCelular()) + ","
                + db.quotate(this.model.getTelefono()) + ","
                + db.quotate(this.model.getEmail()) + ")";          
        int result = db.executeUpdate(query);
        
        if(result > 0){
            JOptionPane.showMessageDialog(view, "Se Registro " + result + "nuevo Cliente en la Base de Datos");
        }else{
            JOptionPane.showMessageDialog(view, "Ocurrio un problema al intentar registrar un nuevo Cliente");
        }
 
    }
    
    
    
}
