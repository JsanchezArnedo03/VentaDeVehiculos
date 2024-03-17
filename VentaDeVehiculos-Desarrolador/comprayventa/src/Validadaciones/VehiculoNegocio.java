/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Validadaciones;

import Persistencia.VehiculoCRUD;
import entidades.Producto;

/**
 *
 * @author jssa3
 */
public class VehiculoNegocio {
    VehiculoCRUD vCRUD = new VehiculoCRUD();
    public boolean CrearVehiculo(Producto vehiculo) {
        return vCRUD.crearvehiculo(vehiculo);
    }
}
