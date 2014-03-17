/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Demo.Conexion.jsf;

import java.sql.*;

/**
 *
 * @author Yuli
 */
public class Conexion {
    private Connection conn=null;
    private Statement st;
    
    
    public Conexion() throws SQLException,Exception{
        crearConexion();
        System.out.println("metodo conexion");
    }
        
    private void crearConexion()throws SQLException,Exception{
        String url = "jdbc:sqlserver://localhost;databaseName=BDAdmin;integratedSecurity=true";
        System.out.println(url);
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
            conn = DriverManager.getConnection(url);
//            System.out.println("connected");
            st = conn.createStatement();
             System.out.println(st + "creo conexion");
        }catch (SQLException sqlError) {
            System.out.println("Error: " + sqlError.getMessage());
             System.out.println("fatal conexion");
        } 
    }
    
    public void ejecutarSQL(String sentencia)throws SQLException,Exception{
        try{
            st.execute(sentencia);	
            
        }catch (SQLException sqlError) {
            System.out.println("Error: " + sqlError.getMessage());
        }	
    }

    public ResultSet ejecutarSQL(String sentencia,boolean retorno)throws SQLException,Exception{
        ResultSet rs = null;
        try{
            rs = st.executeQuery(sentencia);
            
        }catch (SQLException sqlError) {
            System.out.println("Error: " + sqlError.getMessage());
        }
        return rs;
    }
	
    public void iniciarTransaccion()throws java.sql.SQLException{
        try{
            conn.setAutoCommit(false);
        }catch (SQLException sqlError) {
            System.out.println("Error: " + sqlError.getMessage());
        }
    }

    public void terminarTransaccion()throws java.sql.SQLException{
        try{
            conn.setAutoCommit(true);
        }catch (SQLException sqlError) {
            System.out.println("Error: " + sqlError.getMessage());
        }
    }
	
    public void aceptarTransaccion()throws java.sql.SQLException{
        try{
            conn.commit();
        }catch (SQLException sqlError) {
            System.out.println("Error: " + sqlError.getMessage());
        }
    }
	
    public void deshacerTransaccion()throws java.sql.SQLException{
        try{
            conn.rollback();
        }catch (SQLException sqlError) {
            System.out.println("Error: " + sqlError.getMessage());
        }
    }

    protected void finalize() throws Exception{
        try {
            conn.close();	
        }catch(Exception e){
            throw e;
        }
    }
}
