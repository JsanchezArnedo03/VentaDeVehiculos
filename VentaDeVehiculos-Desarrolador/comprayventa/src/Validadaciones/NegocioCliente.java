/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Validadaciones;

import Persistencia.ClienteCRUD;
import entidades.Cliente;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 *
 * @author jssa3
 */
public class NegocioCliente {

    ClienteCRUD clienteCRUD = new ClienteCRUD();

    public boolean crearCliente(Cliente cliente) {
        return clienteCRUD.crearCliente(cliente);
    }

    public DefaultComboBoxModel cargarComboMarcas(JComboBox c) {
        DefaultComboBoxModel combo = new DefaultComboBoxModel();
        c.setModel(combo);
        ArrayList<String> listadoDocumento = clienteCRUD.CargarTipoDocumento();
        for (int i = 0; i < listadoDocumento.size(); i++) {
            combo.addElement(listadoDocumento.get(i));
        }
        return combo;
    }
}
