/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Validadaciones;

import Persistencia.MarcasCRUD;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 *
 * @author jssa3
 */
public class NegocioMarcas {

    MarcasCRUD mCRUD = new MarcasCRUD();

    public DefaultComboBoxModel cargarComboMarcas(JComboBox c) {
        DefaultComboBoxModel combo = new DefaultComboBoxModel();
        c.setModel(combo);
        ArrayList<String> marcas = mCRUD.cargarComboMarcas();
        for (int i = 0; i < marcas.size(); i++) {
            combo.addElement(marcas.get(i));
        }
        return combo;
    }

    public DefaultComboBoxModel cargarComboModelo(JComboBox d) {
        DefaultComboBoxModel combo = new DefaultComboBoxModel();
        d.setModel(combo);
        ArrayList<String> modelos = mCRUD.cargarComboModelos();
        for (int i = 0; i < modelos.size(); i++) {
           combo.addElement(modelos.get(i));
        }
        return combo;
    }
}
