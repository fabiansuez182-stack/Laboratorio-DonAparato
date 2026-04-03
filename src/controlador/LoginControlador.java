package controlador;

import modelo.DAO.UsuarioDAO;
import modelo.DTO.UsuarioDTO;
import vista.LoginVentana;
import vista.PanelPrincipalVentana;
import vista.RegistroVentana;

public class LoginControlador {

    private LoginVentana vista;
    private UsuarioDAO usuarioDAO;

    public LoginControlador(LoginVentana vista) {
        this.vista = vista;
        this.usuarioDAO = new UsuarioDAO();
    }

    public void validarIngreso(String nombreUsuario) {
        if (nombreUsuario.isEmpty()) {
            vista.mostrarMensaje("Por favor ingrese su nombre de usuario.");
            return;
        }

        UsuarioDTO usuarioLogueado = usuarioDAO.validarLogin(nombreUsuario);

        if (usuarioLogueado != null) {
            vista.dispose();

            PanelPrincipalVentana principalVista = new PanelPrincipalVentana();
            PanelPrincipalControlador principalControlador = new PanelPrincipalControlador(principalVista,
                    usuarioLogueado);
            principalVista.setControlador(principalControlador);
            principalControlador.iniciar();
        } else {
            vista.mostrarMensaje("Error: Usuario no encontrado en la base de datos.");
        }
    }

    public void abrirRegistro() {
        vista.dispose();
        RegistroVentana registroVista = new RegistroVentana();
        RegistroControlador registroControlador = new RegistroControlador(registroVista);
        registroVista.setControlador(registroControlador);
        registroVista.setVisible(true);
        registroVista.setLocationRelativeTo(null);
    }
}