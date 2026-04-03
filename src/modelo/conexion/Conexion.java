package modelo.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    // Parámetros de conexión (Ajusta el usuario y contraseña según tu entorno local)
    private static final String BD = "bd_don_aparato";
    private static final String URL = "jdbc:mysql://localhost:3306/" + BD + "?serverTimezone=UTC";
    private static final String USUARIO = "root";
    private static final String PASSWORD = ""; // Si tu MySQL tiene contraseña, escríbela aquí

    // Método estático para retornar la conexión a los DAO
    public static Connection getConnection() {
        Connection conexion = null;
        try {
            // Cargamos el driver actualizado para MySQL 8.x
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Establecemos la conexión
            conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);
            
            // Mensaje de control en consola (Opcional, útil para depurar)
            System.out.println("Conexión exitosa a la base de datos: " + BD);
            
        } catch (ClassNotFoundException e) {
            System.out.println("Error: Driver JDBC no encontrado. Verifica tu Build Path. " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error de conexión SQL: " + e.getMessage());
        }
        
        return conexion;
    }
}