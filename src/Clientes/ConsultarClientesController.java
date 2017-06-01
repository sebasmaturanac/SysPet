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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Gabriel
 */
public class ConsultarClientesController {
    public Clientes modelo;
    public ConsultarClientesView vista;
    
    public ConsultarClientesController(Clientes modelo, ConsultarClientesView vista){
        this.modelo = modelo;
        this.vista = vista; 
        
        this.init();
    }
    
    
    
    public void init(){
        
        JButton btnConsultar = this.vista.getBtnConsultar();
      
        
        btnConsultar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(vista, "cochi en sovos");
                consultarClientes();
                
            }
        });
                
        
        
        
        
    }

    
    public void consultarClientes(){
        
        
        
        /*
        
                String query = "SELECT "
                    + "ID, "
                    + "DESCRIPCION, "
                    + "proveedorID, "
                    + "rubroID, "
                    + "subrubroID, "
                    + "marcaID, "                   
                    + "precioCosto, "
                    + "precioLista, "
                    + "PrecioMayorista, "
                    + "FechaModificacion, "
                    + "CtrlCode "
                    + "FROM "
                    + "productos1 p "
//                  + "productos1 LEFT JOIN "
//                  + "barcodes ON barcodes.ProductoID = productos.ID "
                    + "WHERE p.CtrlCode <> " + CODE_DELETED + " "
                    + "ORDER BY ID "
                    + "LIMIT 500 ";
        
        
        
        */
        
        //consultar datos desde db
        
        JTextField fdClientDNI = this.vista.getFdClienteDNI();
        
        String clienteDNI = fdClientDNI.getText();
        
                
        DBConnection db = new MySQLDBManager("localhost", "syspet", "root", "");
        
        String sql = "SELECT * FROM Clientes "
                + "JOIN LEFT Mascotas "
                + "ON Clientes.DNI = Mascotas.ClienteDNI "
                + "WHERE Clientes.DNI = '"+clienteDNI+"'";
        
        ResultSet result = db.executeQuery(sql);
        
        
        // recorrer datos y cargarlos al objeto Clientes (lista)
        
        try{
            
            while(result.next()){
                String apellido = result.getString("Apellido");
                String dni = result.getString("DNI");
                
                Cliente cliente = new Cliente(dni, apellido);
                
                
                this.modelo.getClientes().add(cliente);
            }


            // Actualizar el modelo de la tabla
            
            try{
            DefaultTableModel tbClientesModel = new DefaultTableModel();
            tbClientesModel.setColumnCount(0);
            tbClientesModel.setNumRows(0);
            tbClientesModel.addColumn("DNI");
            tbClientesModel.addColumn("Nombre");

        
        Iterator iter = this.modelo.getClientes().iterator();
        while (iter.hasNext()) {
            Cliente cliente = (Cliente) iter.next();
            Object[] fila = new Object[2];
            fila[0] = cliente.getDni();
            fila[1] = cliente.getNombre();

            tbClientesModel.addRow(fila);
        };
        
        this.vista.getTbClientes().setModel(tbClientesModel);
        
        //TableRowSorter tProductos = new TableRowSorter<TableModel>(tProductosModel);
        //        orden.setRowFilter(RowFilter.regexFilter(filtro, 1));
        //view.setTblProductos(tProductosModel, tProductos);
 
//        tFormasDePago.getColumnModel().getColumn(0).setPreferredWidth(5);
//        tFormasDePago.getColumnModel().getColumn(1).setPreferredWidth(40);

//            view.getTblProductos().requestFocus();


            }catch(Exception ex){
                System.out.println("Producto - loadForm - " + ex);
            }
           
            
        }catch(Exception ex){
            System.out.println("Exception -> " + ex);
      }
                 
                
    }
  

    
}
