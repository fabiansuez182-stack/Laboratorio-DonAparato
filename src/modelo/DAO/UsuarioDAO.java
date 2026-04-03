package modelo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.conexion.Conexion;
import modelo.DTO.UsuarioDTO;

/**
 * Data Access Object para la tabla 'usuarios'.
 * Contiene las operaciones CRUD con la base de datos.
 */
public class UsuarioDAO {

    /**
     * Valida si un usuario existe en la base de datos buscando por nombre.
     * @param nombreUsuario Nombre ingresado en el login.
     * @return UsuarioDTO con todos los datos si existe, null si no se encontró.
     */
    public UsuarioDTO validarLogin(String nombreUsuario) {
        UsuarioDTO usuarioEncontrado = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = Conexion.getConnection();
            String sql = "SELECT * FROM usuarios WHERE nombre = ?";

            ps = con.prepareStatement(sql);
            ps.setString(1, nombreUsuario);

            rs = ps.executeQuery();

            if (rs.next()) {
                usuarioEncontrado = new UsuarioDTO();
                usuarioEncontrado.setId(rs.getInt("id"));
                usuarioEncontrado.setNombre(rs.getString("nombre"));
                usuarioEncontrado.setApellido(rs.getString("apellido"));
                usuarioEncontrado.setEdad(rs.getInt("edad"));
                usuarioEncontrado.setTelefono(rs.getString("telefono"));
                usuarioEncontrado.setTipo(rs.getString("tipo"));
            }

        } catch (SQLException e) {
            System.out.println("Error en la base de datos: " + e.getMessage());

        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar recursos: " + e.getMessage());
            }
        }
        return usuarioEncontrado;
    }

    /**
     * Registra un nuevo usuario en la base de datos.
     * @param usuario UsuarioDTO con los datos del formulario de registro.
     * @return "OK" si fue exitoso, o un mensaje de error.
     */
    public String registrarUsuario(UsuarioDTO usuario) {
        String resultado = "";
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = Conexion.getConnection();
            String sql = "INSERT INTO usuarios (nombre, apellido, edad, telefono, tipo) VALUES (?, ?, ?, ?, ?)";

            ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getApellido());
            ps.setInt(3, usuario.getEdad());
            ps.setString(4, usuario.getTelefono());
            ps.setString(5, usuario.getTipo());

            ps.executeUpdate();
            resultado = "OK";

        } catch (SQLException e) {
            resultado = "Error al registrar usuario: " + e.getMessage();

        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar recursos: " + e.getMessage());
            }
        }
        return resultado;
    }
}