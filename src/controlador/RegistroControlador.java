package controlador;

import modelo.DAO.UsuarioDAO;
import modelo.DTO.UsuarioDTO;
import vista.LoginVentana;
import vista.RegistroVentana;

/**
 * Controlador de la ventana de Registro.
 * Permite registrar un nuevo usuario en la base de datos.
 */
public class RegistroControlador {

    private RegistroVentana vista;
    private UsuarioDAO usuarioDAO;

    public RegistroControlador(RegistroVentana vista) {
        this.vista = vista;
        this.usuarioDAO = new UsuarioDAO();
    }

    /**
     * Lee los datos del formulario de registro, los valida,
     * arma un UsuarioDTO y lo guarda en la base de datos.
     */
    public void guardarUsuario(String nombre, String apellido, String edadStr,
                                String telefono, String tipo) {
        // Validar que los campos obligatorios no estén vacíos
        if (nombre.isEmpty() || apellido.isEmpty() || edadStr.isEmpty() || telefono.isEmpty()) {
            vista.mostrarMensaje("Todos los campos son obligatorios.");
            return;
        }

        int edad;
        try {
            edad = Integer.parseInt(edadStr);
        } catch (NumberFormatException e) {
            vista.mostrarMensaje("La edad debe ser un número válido.");
            return;
        }

        // Armar el DTO
        UsuarioDTO nuevoUsuario = new UsuarioDTO();
        nuevoUsuario.setNombre(nombre);
        nuevoUsuario.setApellido(apellido);
        nuevoUsuario.setEdad(edad);
        nuevoUsuario.setTelefono(telefono);

        // Si el tipo es "Ninguno", guardar null en la BD
        if (tipo == null || tipo.equals("Ninguno")) {
            nuevoUsuario.setTipo(null);
        } else {
            nuevoUsuario.setTipo(tipo);
        }

        // Guardar en la BD
        String resultado = usuarioDAO.registrarUsuario(nuevoUsuario);

        if (resultado.equals("OK")) {
            vista.mostrarMensaje("¡Usuario registrado exitosamente!");
            volverAlLogin();
        } else {
            vista.mostrarMensaje(resultado);
        }
    }

    /**
     * Cierra el registro y regresa al login.
     */
    public void volverAlLogin() {
        vista.dispose();
        LoginVentana loginVista = new LoginVentana();
        LoginControlador loginControlador = new LoginControlador(loginVista);
        loginVista.setControlador(loginControlador);
        loginVista.setVisible(true);
        loginVista.setLocationRelativeTo(null);
    }
}