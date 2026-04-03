package modelo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.conexion.Conexion;
import modelo.DTO.CompraDTO;

/**
 * Data Access Object para la tabla 'compras'.
 * Registra las compras realizadas en la base de datos.
 */
public class CompraDAO {

    /**
     * Inserta una nueva compra en la base de datos.
     * @param miCompra CompraDTO con todos los datos calculados.
     * @return "OK" si fue exitoso, o un mensaje de error.
     */
    public String registrarCompra(CompraDTO miCompra) {
        String resultado = "";
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = Conexion.getConnection();
            String sql = "INSERT INTO compras (nombre_producto, valor_unitario, cantidad, " +
                         "total_bruto, descuento_aplicado, total_neto, id_usuario) " +
                         "VALUES (?, ?, ?, ?, ?, ?, ?)";

            ps = con.prepareStatement(sql);
            ps.setString(1, miCompra.getNombreProducto());
            ps.setDouble(2, miCompra.getValorUnitario());
            ps.setInt(3, miCompra.getCantidad());
            ps.setDouble(4, miCompra.getTotalBruto());
            ps.setDouble(5, miCompra.getDescuentoAplicado());
            ps.setDouble(6, miCompra.getTotalNeto());
            ps.setInt(7, miCompra.getIdUsuario());

            ps.executeUpdate();
            resultado = "OK";

        } catch (SQLException e) {
            resultado = "Error al registrar la compra: " + e.getMessage();

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