/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import entidades.Vehiculo;
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

    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public boolean crearvehiculo(Vehiculo vehiculo) {
        String sql = "";
        try {
            con.prepareCall(sql);
            ps.setString(0, sql);
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(VehiculoCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public boolean vehiculoVendido(Vehiculo vehiculo) {
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
