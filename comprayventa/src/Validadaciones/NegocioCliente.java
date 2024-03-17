/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Validadaciones;

import Persistencia.ClienteCRUD;
import entidades.Cliente;

/**
 *
 * @author jssa3
 */
public class NegocioCliente {

    ClienteCRUD clienteCRUD = new ClienteCRUD();

    public boolean crearCliente(Cliente cliente) {
        return clienteCRUD.crearCliente(cliente);
    }
}
