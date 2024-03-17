/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import BaseDatos.Conexion;
import entidades.Producto;
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
public class VehiculoCRUD {

    Connection con = null;
    PreparedStatement ps = null;

    public boolean crearvehiculo(Producto vehiculo) {
        con = Conexion.getConnection();
        String sql = "insert into Productos "
                + "(marca,modelo,descripcion,precio,estado) "
                + "values(?,?,?,?,?);";
        try {
            ps = con.prepareCall(sql);
            ps.setString(1, vehiculo.getMarca());
            ps.setString(2, vehiculo.getModelo());
            ps.setString(3, vehiculo.getDescripcion());
            ps.setFloat(4, vehiculo.getPrecio());
            ps.setBoolean(5, vehiculo.isEstado());
            ps.executeUpdate();
            con.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(VehiculoCRUD.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }

    public boolean vehiculoVendido(Producto vehiculo) {
        ResultSet rs = null;
        try {
            String sql = "";
            con.prepareCall(sql);
            //Enviamos el estado del vehiculo si esta vendido o en stock
            /*TRUE = VENDIDO
            FALSE = STOCK
             */
            ps.setBoolean(1, true);

            rs = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(VehiculoCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true;
    }
}
