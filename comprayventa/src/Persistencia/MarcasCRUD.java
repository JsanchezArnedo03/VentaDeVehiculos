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

    PreparedStatement ps;
    ResultSet rs;
    ArrayList<Marcas> listadoMarcas = new ArrayList<>();
    Marcas marca = new Marcas();
    Connection con = Conexion.getConnection();

    public ArrayList cargarComboMarcas() {
        try {
            String sql = "SELECT nombre FROM MARCAS;";
            ps = con.prepareCall(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                marca.setNombre(rs.getString(1));
                listadoMarcas.add(marca);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MarcasCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listadoMarcas;
    }

}
