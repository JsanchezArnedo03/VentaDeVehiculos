/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import BaseDatos.Conexion;
import entidades.Marcas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jssa3
 */
public class MarcasCRUD {

    Marcas marca;
    Connection con = Conexion.getConnection();

    public ArrayList cargarComboMarcas() {
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<String> listadoMarcas = new ArrayList<>();
        try {
            String sql = "SELECT marca FROM Productos;";
            ps = con.prepareCall(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                marca = new Marcas();
                marca.setNombre(rs.getString(1));
                listadoMarcas.add(marca.getNombre().toUpperCase());
            }
        } catch (SQLException ex) {
            Logger.getLogger(MarcasCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listadoMarcas;
    }

    public ArrayList cargarComboModelos() {
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<String> listadoModelos = new ArrayList<>();
        try {
            String sql = "SELECT modelo FROM Productos;";
            ps = con.prepareCall(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                marca = new Marcas();
                marca.setModelo(rs.getString(1));
                listadoModelos.add(marca.getModelo());
            }
        } catch (SQLException ex) {
            Logger.getLogger(MarcasCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listadoModelos;
    }
}
