package controlador;

import modelo.DAO.UsuarioDAO;
import modelo.DTO.UsuarioDTO;
import vista.LoginVentana;
import vista.RegistroVentana;

public class RegistroControlador {

    private RegistroVentana vista;
    private UsuarioDAO usuarioDAO;

    public RegistroControlador(RegistroVentana vista) {
        this.vista = vista;
        this.usuarioDAO = new UsuarioDAO();
    }

    public void guardarUsuario(String nombre, String apellido, String edadStr,
            String telefono, String tipo) {
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

        UsuarioDTO nuevoUsuario = new UsuarioDTO();
        nuevoUsuario.setNombre(nombre);
        nuevoUsuario.setApellido(apellido);
        nuevoUsuario.setEdad(edad);
        nuevoUsuario.setTelefono(telefono);

        if (tipo == null || tipo.equals("Ninguno")) {
            nuevoUsuario.setTipo(null);
        } else {
            nuevoUsuario.setTipo(tipo);
        }

        String resultado = usuarioDAO.registrarUsuario(nuevoUsuario);

        if (resultado.equals("OK")) {
            vista.mostrarMensaje("¡Usuario registrado exitosamente!");
            volverAlLogin();
        } else {
            vista.mostrarMensaje(resultado);
        }
    }

    public void volverAlLogin() {
        vista.dispose();
        LoginVentana loginVista = new LoginVentana();
        LoginControlador loginControlador = new LoginControlador(loginVista);
        loginVista.setControlador(loginControlador);
        loginVista.setVisible(true);
        loginVista.setLocationRelativeTo(null);
    }
}