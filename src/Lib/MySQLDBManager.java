/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Lib;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author Cesar
 */
public final class MySQLDBManager extends DBConnection{
    //ATRIBUTOS
    private int affetedRows;
    
    
    //CONSTRUCTORES
    public MySQLDBManager(){}
    
    public MySQLDBManager(String server, String database, String user, String password){
        super(server, database, user, password);
        
        try 
        {
            this.connect();
        } catch (Exception ex) {
            System.out.println("MySQLDBManager(String server, String database, String user, String password) - ex: "+ ex);
        } 
    }

    
    //METODOS
    @Override
    public void connect() throws SQLException, ClassNotFoundException
    {
        System.out.println("Conectando...");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://" + this.getServer() + "/" + this.getDatabase();
            setConnection(DriverManager.getConnection(url, this.getUser(), this.getPassword()));
            setStatement(getConnection().createStatement());
            System.out.println("conexion OK!");
            this.setResponse(true);
        } catch (ClassNotFoundException ex) {
            System.err.println("No encuentra Clase Driver Base de Datos.");
            System.err.println(ex.getMessage());
            JOptionPane.showMessageDialog(null,
                    "Error Driver Base de Datos...", "ADVERTENCIA",
                    JOptionPane.ERROR_MESSAGE);
            throw (ex);
        } catch (SQLException ex) {
            System.err.println("No puede conectar a la Base de Datos.");
            System.err.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error en Conección...",
                    "ADVERTENCIA", JOptionPane.ERROR_MESSAGE);
            throw (ex);
        }  
    }
    
    
    @Override
    public ResultSet executeQuery()
    {
        try
        {
            this.setResult(this.getStatement().executeQuery(this.getQuery()));
            this.setResponse(true);
            System.out.println("Consulta: OK!\n"+ this.getQuery());
        }catch(SQLException ex)
        {
            System.err.println("No puede realizar la consulta");
            System.err.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error al Consultar DB",
                    "ADVERTENCIA", JOptionPane.ERROR_MESSAGE);  
        }
        
        return this.getResult();
    }
    
    @Override
    public int executeUpdate() {
        this.setResponse(false);
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
    public void mostrarMensajes(String query, String result){
      int columnas = 0;
      
      if(query.length() >= result.length()){
         columnas = query.length();
      }else{
          columnas = result.length();
      }
      
      String separadorH = "+";
      String separadorV = "|";
      String separadorH2 = "+";
      for(int i=-1; i<=columnas; i++){
          separadorH += "-";
          separadorV += " ";
          separadorH2 += "-";
      }
      separadorH += "+\n";
      separadorV += "|\n";
      separadorH2 += "+\n";

      
      String content = "";
      content += separadorH;
      content += separadorV;
      content += "| " + alinear(query, columnas) + " |\n";
      content += separadorV;
      content += separadorH;
      
      content += separadorV;
      content += "| " + alinear(result, columnas) + " |\n";
      content += separadorV;
      content += separadorH2;
      
      System.out.println(content);
    }
    
    public String alinear(String palabra, int columnas){
        int totalEspacios = columnas - palabra.length();
       /*CENTRADO
        int mod = totalEspacios % 2;
        int nroEspacios = 0;
        if(mod == 0){
            nroEspacios = totalEspacios / 2;
        }else{
            nroEspacios = (totalEspacios + 1) / 2;
        }
        String espacios = "";
 
        for(int i=0; i < nroEspacios; i++){
            espacios += " ";
        }
        String linea = "";
        linea += espacios; 
        linea += palabra;
        linea += espacios;
        */
        String linea = "";
        String espacios = "";
        for(int i=0; i < totalEspacios; i++) espacios += " ";
        linea += palabra;
        linea += espacios;
        return linea;
    }
    
    
    @Override
    public ResultSet executeQuery(String query)
    {
        //SELECT
        String msg = "";
        
        try
        {
            this.setResult(this.getStatement().executeQuery(query));
            msg += "Status: OK";
            this.setResponse(true);
        }catch(SQLException ex){
            msg += "Exception: " + ex;
            JOptionPane.showMessageDialog(null, "Error al Consultar DB",
                    "ADVERTENCIA", JOptionPane.ERROR_MESSAGE);  
        }
        
        this.mostrarMensajes(query, msg);
        return this.getResult();
    }    

    @Override
    public int executeUpdate(String query)
    {
        //UPDATE, INSERT DELETE
        String msg = "";
        
        int result = 0;
        
        try
        {
            result = this.getStatement().executeUpdate(query);
            this.setResponse(true);
            
            this.setAffetedRows(this.getStatement().getUpdateCount());
            
            msg += "Resultado: ["+ result + "] - Affected Rows: " + this.getAffetedRows();

        }catch(SQLException ex)
        {
            msg += "Exception: " + ex;
            
            JOptionPane.showMessageDialog(null, "Error al Consultar DB",
                    "ADVERTENCIA", JOptionPane.ERROR_MESSAGE);  
        }
        
        this.mostrarMensajes(query, msg);
        return result;
    }
    
    
    
    @Override
    public void transactionStart(){
        try{    
            this.executeQuery("START TRANSACTION");
        }catch(Exception ex){
            System.out.println("MySQLDBManager::transactionStart() - Ex: " + ex);
        }        
    }
    
    @Override
    public void begin(){
        try{
            this.executeQuery("BEGIN");
        }catch(Exception ex){
            System.out.println("MySQLDBManager::begin() - Ex: " + ex);
        }
    }
    
    @Override
    public void commit(){
        try{
           this.executeQuery("COMMIT;"); 
        }catch(Exception ex){
            System.out.println("MySQLDBManager::commit() - Ex: " + ex);
        }
        
    }
    
    @Override
    public void rollback(){
        try{    
            this.executeQuery("ROLLBACK;");
        }catch(Exception ex){
            System.out.println("MySQLDBManager::rollback() - Ex: " + ex);
        }        
    }    
    
    public int getInsertID(){ return 0; }

    

    //GETTERS & SETTERS
    public int getAffetedRows() {
        return affetedRows;
    }

    public void setAffetedRows(int affetedRows) {
        this.affetedRows = affetedRows;
    }
    
    
    public int getLastInsertID(){
        String query = "SELECT LAST_INSERT_ID() AS Last_Insert_ID";
        int id = 0;
        try{
               ResultSet rs = this.executeQuery(query);
               
               if(!rs.next()){
                   System.out.println("Last_Insert_ID");
               }else{
                    do{
                        id = rs.getInt("Last_Insert_ID") ;
                    }while(rs.next());
               }
              
               System.out.println("MySQLManager.getLastInsertID() - Result: "  + id);
        }catch(Exception ex){
            System.out.println("MySQLManager.getLastInsertID() - Msg: Exception - Ref: " + ex);
        }
        return id;
    }
    
  public void executePreparedStatement(String[] args) throws Exception {
    String url = "jdbc:mysql://localhost/testdb";
    String username = "root";
    String password = "";
    Class.forName("com.mysql.jdbc.Driver");
    Connection conn = null;
    try {
      conn = DriverManager.getConnection(url, username, password);
      conn.setAutoCommit(false);

      Statement st = conn.createStatement();
      st.execute("INSERT INTO orders (username, order_date) VALUES ('java', '2007-12-13')",
          Statement.RETURN_GENERATED_KEYS);

      ResultSet keys = st.getGeneratedKeys();
      int id = 1;
      while (keys.next()) {
        id = keys.getInt(1);
      }
      PreparedStatement pst = conn.prepareStatement("INSERT INTO order_details (order_id, product_id, quantity, price) VALUES (?, ?, ?, ?)");
      pst.setInt(1, id);
      pst.setString(2, "1");
      pst.setInt(3, 10);
      pst.setDouble(4, 100);
      pst.execute();

      conn.commit();
      System.out.println("Transaction commit...");
    } catch (SQLException e) {
      if (conn != null) {
        conn.rollback();
        System.out.println("Connection rollback...");
      }
      e.printStackTrace();
    } finally {
      if (conn != null && !conn.isClosed()) {
        conn.close();
      }
    }
  }
  
  
  //07-05-13 Exportar/Importar tablas
  
  public void  exportar(String table, String file){
      //file: contiene el path completo "/" con la extension del archivo
      String query = "SELECT * INTO "
                    + "OUTFILE '"+ file +"' "
                    + "FIELDS TERMINATED BY ',' "
                    + "OPTIONALLY ENCLOSED BY '\"' "
                    + "LINES TERMINATED BY '\r\n' "
                    + "FROM " + table;
      try{
          int rs = this.executeUpdate(query);
      }catch(Exception ex){
          System.out.println("Exception: No se pudo guardar el archivo");
          System.out.println("MySQLDBManager.Exportar() -> " + ex);
          
      }
  }
  
  public void importar(String table, String file){
      //file: contiene el path completo "/" con la extension del archivo
      String query = "LOAD DATA LOCAL "
                    + "INFILE '"+ file +"' "
                    + "INTO TABLE "+ table + " "
                    + "FIELDS TERMINATED BY ',' "
                    + "OPTIONALLY ENCLOSED BY '\"' "
                    + "LINES TERMINATED BY '\r\n' ";
      try{
          int rs = this.executeUpdate(query);
      }catch(Exception ex){
          System.out.println("Exception: No se importaron datos");
          System.out.println("MySQLDBManager.Importar() -> " + ex);
      }

  }
  

  
    
    
}
