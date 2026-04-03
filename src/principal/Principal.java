package principal;

import vista.LoginVentana;
import controlador.LoginControlador;

public class Principal {
    public static void main(String[] args) {
        // 1. Instanciamos la vista inicial
        LoginVentana ventanaLogin = new LoginVentana();
        
        // 2. Instanciamos su controlador y le pasamos la vista
        LoginControlador controladorLogin = new LoginControlador(ventanaLogin);
        
        // 3. Enlazamos el controlador a la vista
        ventanaLogin.setControlador(controladorLogin);
        
        // 4. Mostramos la ventana
        ventanaLogin.setVisible(true);
        ventanaLogin.setLocationRelativeTo(null);
    }
}