/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Validadaciones;

import Persistencia.VehiculoCRUD;
import entidades.Producto;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jssa3
 */
public class VehiculoNegocio {

    VehiculoCRUD vCRUD = new VehiculoCRUD();

    public boolean CrearVehiculo(Producto vehiculo) {
        return vCRUD.crearvehiculo(vehiculo);
    }

    public Producto validarExistencia(int id) {
        return vCRUD.validarExistencia(id);
    }

    public DefaultTableModel listadoDeVehiculos(JTable table) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("id Producto");
        model.addColumn("Marca");
        model.addColumn("Modelo");
        model.addColumn("Precio");
        model.addColumn("Usado o nuevo");

        table.setModel(model);

        return model;
    }
    
    public DefaultComboBoxModel cargarComboMarcas(JComboBox c) {
        DefaultComboBoxModel combo = new DefaultComboBoxModel();
        c.setModel(combo);
        ArrayList<String> marcas = vCRUD.cargarComboMarcas();
        for (int i = 0; i < marcas.size(); i++) {
            combo.addElement(marcas.get(i));
        }
        return combo;
    }

    public DefaultComboBoxModel cargarComboModelo(JComboBox d) {
        DefaultComboBoxModel combo = new DefaultComboBoxModel();
        d.setModel(combo);
        ArrayList<String> modelos = vCRUD.cargarComboModelos();
        for (int i = 0; i < modelos.size(); i++) {
           combo.addElement(modelos.get(i));
        }
        return combo;
    }

}
