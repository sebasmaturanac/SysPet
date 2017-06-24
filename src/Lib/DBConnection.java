/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Lib;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Cesar
 */
public abstract class DBConnection {
    //ATRIBUTOS
    private Connection connection;
    private Statement statement;
    private String server;
    private String database;
    private String user;
    private String password;
    private ResultSet result;
    private String query;
    //
    public boolean response = false;
    
    //CONSTANTES
    public final int SQLCODE_SUCCESS = 1;
    public final int SQLCODE_ERROR = 0;
    
    //CONSTRUCTORES
    public DBConnection(){}
    
    public DBConnection(String server, String database, String user, String password){
        this.server = server;
        this.database = database;
        this.user = user;
        this.password = password;
    }
    
    //METODOS
    public abstract void connect() throws SQLException, ClassNotFoundException;
    
    public abstract ResultSet executeQuery();
    
    public abstract ResultSet executeQuery(String query);
    
    public abstract int executeUpdate();
    
    public abstract int executeUpdate(String query);
    
    public abstract void transactionStart();
    public abstract void begin();
    public abstract void commit();
    public abstract void rollback();
    
    
    
    public void disconnect(){
       try {
                getStatement().close();
                getConnection().close();
            } catch (SQLException ex) {
                System.err.println("No puede cerrar conexion a la Base de Datos.");
                System.err.println(ex.getMessage());
                JOptionPane.showMessageDialog(null, "Error Cerrar BD...",
                        "ADVERTENCIA", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void close(){
        try {
                this.getResult().close();
            } catch (SQLException ex){
                System.err.println("No puede cerrar ResultSet.");
                System.err.println(ex.getMessage());
                JOptionPane.showMessageDialog(null, "Error Cerrar ResultSet...",
                        "ADVERTENCIA", JOptionPane.ERROR_MESSAGE);
            }
     }
    
    
    public boolean isConnected(){
        try{
            return (!this.getConnection().isClosed());
        }catch(Exception ex){
            System.out.println("DBConnection::isConnected() @ " + ex);
           return false;
        }

    }

    //GETTERS & SETTERS
    /**
     * @return the connection
     */
    public Connection getConnection() {
        return connection;
    }

    /**
     * @param connection the connection to set
     */
    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    /**
     * @return the statement
     */
    public Statement getStatement() {
        return statement;
    }

    /**
     * @param statement the statement to set
     */
    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    /**
     * @return the server
     */
    public String getServer() {
        return server;
    }

    /**
     * @param server the server to set
     */
    public void setServer(String server) {
        this.server = server;
    }

    /**
     * @return the database
     */
    public String getDatabase() {
        return database;
    }

    /**
     * @param database the database to set
     */
    public void setDatabase(String database) {
        this.database = database;
    }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the result
     */
    public ResultSet getResult() {
        return result;
    }

    /**
     * @param result the result to set
     */
    public void setResult(ResultSet result) {
        this.result = result;
    }

    /**
     * @return the response
     */
    public boolean isResponse() {
        return response;
    }
    
    public boolean getResponse() {
        return response;
    }    

    /**
     * @param response the response to set
     */
    public void setResponse(boolean response) {
        this.response = response;
    }

    /**
     * @return the query
     */
    public String getQuery() {
        return query;
    }

    /**
     * @param query the query to set
     */
    public void setQuery(String query) {
        this.query = query;
    }
    
        public static String quotate(String content) {
        return "'" + content + "'";
    } // end quotate()
    
}
