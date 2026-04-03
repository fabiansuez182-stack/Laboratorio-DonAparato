package controlador;

import modelo.DAO.UsuarioDAO;
import modelo.DTO.UsuarioDTO;
import vista.LoginVentana;
import vista.PanelPrincipalVentana;
import vista.RegistroVentana;

/**
 * Controlador de la ventana de Login.
 * Valida el ingreso del usuario y navega al panel principal o al registro.
 */
public class LoginControlador {

    private LoginVentana vista;
    private UsuarioDAO usuarioDAO;

    public LoginControlador(LoginVentana vista) {
        this.vista = vista;
        this.usuarioDAO = new UsuarioDAO();
    }

    /**
     * Busca al usuario por nombre en la BD.
     * Si existe, abre el panel principal con sus datos precargados.
     * Si no existe, muestra un mensaje de error.
     */
    public void validarIngreso(String nombreUsuario) {
        if (nombreUsuario.isEmpty()) {
            vista.mostrarMensaje("Por favor ingrese su nombre de usuario.");
            return;
        }

        UsuarioDTO usuarioLogueado = usuarioDAO.validarLogin(nombreUsuario);

        if (usuarioLogueado != null) {
            vista.dispose();

            // Abrimos el Panel Principal y le pasamos el usuario logueado
            PanelPrincipalVentana principalVista = new PanelPrincipalVentana();
            PanelPrincipalControlador principalControlador =
                    new PanelPrincipalControlador(principalVista, usuarioLogueado);
            principalVista.setControlador(principalControlador);
            principalControlador.iniciar();
        } else {
            vista.mostrarMensaje("Error: Usuario no encontrado en la base de datos.");
        }
    }

    /**
     * Cierra el login y abre la ventana de registro.
     */
    public void abrirRegistro() {
        vista.dispose();
        RegistroVentana registroVista = new RegistroVentana();
        RegistroControlador registroControlador = new RegistroControlador(registroVista);
        registroVista.setControlador(registroControlador);
        registroVista.setVisible(true);
        registroVista.setLocationRelativeTo(null);
    }
}