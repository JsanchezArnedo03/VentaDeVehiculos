/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import BaseDatos.Conexion;
import entidades.Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jssa3
 */
public class LoginCRUD {

    PreparedStatement ps;
    ResultSet rs;
    Connection con;

    public Login validarIngreso(String username, String psw) {
        String sql = "call login(?,?)";
        Login login = null;
        try {
            con = Conexion.getConnection();
            ps = con.prepareCall(sql);
            ps.setString(1, username);
            ps.setString(2, psw);
            rs = ps.executeQuery();
            if (rs.next()) {
                login = new Login();
                login.setCargo(rs.getInt(3));
                return login;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return login;
    }
}
