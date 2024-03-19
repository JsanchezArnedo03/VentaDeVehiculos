/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import BaseDatos.Conexion;
import entidades.Cliente;
import entidades.TipoDocumento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ClienteCRUD {

    private final Connection con = Conexion.getConnection();
    private PreparedStatement ps = null;

    public boolean crearCliente(Cliente cliente) {

        String sql = "insert into cliente(documentoIdentidad ,\n"
                + "    primerNombre,\n"
                + "    segundoNombre,\n"
                + "    primerApellido ,\n"
                + "    segundoApellido ,\n"
                + "    telefono ,\n"
                + "    email)values(?,?,?,?,?,?,?);";
        try {
            ps = con.prepareCall(sql);
            //TODA PERSISTENCIA DE DATOS VA AQUI PARA CREAR UN NUEVO CLIENTE
            ps.setString(1, cliente.getDocumento());
            ps.setString(2, cliente.getPrimerNombre());
            ps.setString(3, cliente.getSegundoNombre());
            ps.setString(4, cliente.getPrimerApellido());
            ps.setString(5, cliente.getSegundoApellido());
            ps.setString(6, cliente.getTelefono());
            ps.setString(7, cliente.getEmail());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean actualizarInfo(Cliente cliente) {
        String sql = "";

        try {
            ps = con.prepareCall(sql);
            //TODA INFORMACION QUE SE VAYA A ACTUALIZAR VA AQUI DENTRO
            ps.execute();
        } catch (SQLException e) {
        }
        return true;
    }

    public ArrayList CargarTipoDocumento() {

        ArrayList<String> listadoDocumentos = null;
        String sql = "SELECT NOMBRE FROM Tipodocumento;";
        try {
            ps = con.prepareCall(sql);
            ResultSet rs;
            listadoDocumentos = new ArrayList<>();
            rs = ps.executeQuery();
            while (rs.next()) {
                TipoDocumento tDocumento = new TipoDocumento();
                tDocumento.setNombre(rs.getString(1));
                listadoDocumentos.add(tDocumento.getNombre());
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listadoDocumentos;
    }
}
