/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import BaseDatos.Conexion;
import entidades.Cliente;
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
public class ClienteCRUD {

    private Connection con = null;
    private ResultSet rs = null;
    private PreparedStatement ps = null;

    public boolean crearCliente(Cliente cliente) {
        con = Conexion.getConnection();

        String sql = "";
        try {
            ps = con.prepareCall(sql);
            //TODA PERSISTENCIA DE DATOS VA AQUI PARA CREAR UN NUEVO CLIENTE
            rs = ps.executeQuery();

        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public boolean actualizarInfo(Cliente cliente) {
        String sql = "";
        try {
            ps = con.prepareCall(sql);
            //TODA INFORMACION QUE SE VAYA A ACTUALIZAR VA AQUI DENTRO
            rs = ps.executeQuery();
        } catch (SQLException e) {
        }
        return true;
    }
}
