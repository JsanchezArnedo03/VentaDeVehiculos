package Validadaciones;

import Persistencia.LoginCRUD;
import Vistas.FrmPrincipal;
import Vistas.FrmPrincipalVendedor;
import entidades.Login;
import javax.swing.JFrame;

/**
 *
 * @author jssa3
 */
public class LoginNegocio {

    LoginCRUD lcrud = new LoginCRUD();

    public JFrame ValidarIngreso(String username, String psw) {
        Login login = lcrud.validarIngreso(username,psw);
        JFrame pantallaPrincipal = null;
        if (login != null) {
            if (login.getCargo() == 1) {
                pantallaPrincipal = new FrmPrincipal();
            } else if (login.getTipoPersona() == 2) {
                pantallaPrincipal = new FrmPrincipalVendedor();
            }
        }
        return pantallaPrincipal;
    }
}
