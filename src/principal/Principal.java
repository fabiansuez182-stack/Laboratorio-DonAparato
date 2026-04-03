package principal;

import vista.LoginVentana;
import controlador.LoginControlador;

public class Principal {
    public static void main(String[] args) {

        LoginVentana ventanaLogin = new LoginVentana();
        LoginControlador controladorLogin = new LoginControlador(ventanaLogin);

        ventanaLogin.setControlador(controladorLogin);
        ventanaLogin.setVisible(true);
        ventanaLogin.setLocationRelativeTo(null);
    }
}