package modelo.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final String BD = "bd_don_aparato";
    private static final String URL = "jdbc:mysql://localhost:3306/" + BD + "?serverTimezone=UTC";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() {
        Connection conexion = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);

            System.out.println("Conexión exitosa a la base de datos: " + BD);

        } catch (ClassNotFoundException e) {
            System.out.println("Error: Driver JDBC no encontrado. Verifica tu Build Path. " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error de conexión SQL: " + e.getMessage());
        }

        return conexion;
    }
}