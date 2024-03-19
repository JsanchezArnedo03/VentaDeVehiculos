/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import BaseDatos.Conexion;
import entidades.IdeasDeinformes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jssa3
 */
public class InformesCRUD {

    Connection con = Conexion.getConnection();

    public String ReporteDeComprados() {
        DefaultTableModel model = new DefaultTableModel();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "Busqueda por rango de fecha";
        IdeasDeinformes informes = new IdeasDeinformes();
        try {
            ps = con.prepareCall(sql);
            ps.setDate(1, informes.getFechaDeCompra());
            rs = ps.executeQuery();
            while(rs.next()){
                
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return ""; 
    }
}
