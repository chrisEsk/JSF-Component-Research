/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Demo.Conexion.jsf;

import java.sql.ResultSet;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;

/**
 *
 * @author Yuli
 */
@ManagedBean(name = "login_bean")
@RequestScoped
public class login_bean implements Serializable {
    
    Conexion con;
    private String username;
    private String password;
    String response;


    /**
     * Creates a new instance of login_bean
     */
    public login_bean() throws Exception {
        con = new Conexion();
//        username = "Yuli";
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public boolean validarUsuario(String pusuario, String ppassword) throws Exception{
        boolean exist = true;
        
        String sql = "Select * " +
                     "From tblUser " +
                     "Where usuario = '" + pusuario +"'" + " and password = '" + ppassword + "'";
         System.out.println(sql);
        ResultSet rs = con.ejecutarSQL(sql, true);
        
        if (!rs.next() ) {
            exist = false;
        }
        rs.close();
        System.out.println(exist);
        return exist;
       
    }
        
    public String getResponse() throws Exception
    {
        boolean flagUser;
        
        flagUser = validarUsuario(username, password);
        System.out.println(flagUser);
        if (flagUser) {
            return "Bienvenida " + getUsername();
        }else{
            return "No existe el usuario o esta ingresando una contraseña invalida.";  
        }
    }
        
    public void probarConexion() throws Exception{
        System.out.println("hola");
        ResultSet rs = con.ejecutarSQL("select * from tblUser", true);
       
        String usuario;
        String password;
        
        while (rs.next()) {
            usuario = rs.getString("usuario");
            password = rs.getString("password");
            System.out.println(usuario + "\t" + password);
        }
        rs.close();
    }
}
