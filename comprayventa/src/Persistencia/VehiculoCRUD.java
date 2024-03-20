/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import BaseDatos.Conexion;
import entidades.Marcas;
import entidades.Producto;
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
public class VehiculoCRUD {

    Connection con = Conexion.getConnection();
    PreparedStatement ps = null;
    ResultSet rs = null;
    Marcas marca = new Marcas();

    public boolean crearvehiculo(Producto vehiculo) {

        String sql = "insert into Productos "
                + "(marca,modelo,placa,descripcion,precio,estado) "
                + "values(?,?,?,?,?,?);";
        try {
            ps = con.prepareCall(sql);
            ps.setString(1, vehiculo.getMarca());
            ps.setString(2, vehiculo.getModelo());
            ps.setString(3, vehiculo.getPlaca());
            ps.setString(4, vehiculo.getDescripcion());
            ps.setFloat(5, vehiculo.getPrecio());
            ps.setBoolean(6, vehiculo.isEstado());
            ps.execute();
            con.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(VehiculoCRUD.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public Producto validarExistencia(int id) {
        Producto vehiculo = new Producto();
        try {
            String sql = "select id from producto;";
            ps = con.prepareCall(sql);
            rs = ps.executeQuery();
            if (rs != null) {
                vehiculo.setIdProducto(rs.getInt(1));
            }
            return vehiculo;
        } catch (SQLException ex) {
            Logger.getLogger(VehiculoCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vehiculo;
    }

    public Producto listadoVehiculos() {
        Producto vehiculo = new Producto();
        try {
            String sql = "";
            ps = con.prepareCall(sql);
            rs = ps.executeQuery();
            while (rs.next()) {

            }
        } catch (SQLException ex) {
            Logger.getLogger(VehiculoCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vehiculo;
    }

    public boolean vehiculoVendido(Producto vehiculo) {

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

    public ArrayList cargarComboModelos() {

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
            Logger.getLogger(VehiculoCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listadoModelos;
    }

    public ArrayList cargarComboMarcas() {

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
            Logger.getLogger(VehiculoCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listadoMarcas;
    }

}
