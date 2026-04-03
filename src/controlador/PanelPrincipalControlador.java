package controlador;

import modelo.DAO.CompraDAO;
import modelo.DTO.CompraDTO;
import modelo.DTO.UsuarioDTO;
import modelo.operaciones.Procesos;
import vista.PanelPrincipalVentana;

/**
 * Controlador del Panel Principal de ventas.
 * Gestiona la compra, muestra datos del usuario y limpia la pantalla.
 */
public class PanelPrincipalControlador {

    private PanelPrincipalVentana vista;
    private UsuarioDTO usuarioSesion;
    private Procesos misProcesos;
    private CompraDAO miCompraDAO;

    public PanelPrincipalControlador(PanelPrincipalVentana vista, UsuarioDTO usuarioSesion) {
        this.vista = vista;
        this.usuarioSesion = usuarioSesion;
        this.misProcesos = new Procesos();
        this.miCompraDAO = new CompraDAO();
    }

    /**
     * Carga los datos del usuario en la vista y muestra la ventana.
     */
    public void iniciar() {
        vista.cargarDatosUsuario(usuarioSesion);
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
    }

    /**
     * Procesa una compra:
     * 1. Asigna el ID del usuario que compra.
     * 2. Calcula descuentos según el tipo de afiliación.
     * 3. Guarda en base de datos.
     * 4. Muestra el ticket en las etiquetas de la vista.
     */
    public void procesarCompra(CompraDTO miCompra) {
        // 1. Asignar el ID del usuario que está comprando
        miCompra.setIdUsuario(usuarioSesion.getId());

        // 2. Enviar a lógica para calcular descuento según tipo A, B, C
        misProcesos.calcularTotales(miCompra, usuarioSesion);

        // 3. Guardar en Base de Datos
        String resultado = miCompraDAO.registrarCompra(miCompra);

        if (resultado.equals("OK")) {
            // 4. Mostrar ticket con nombre, tipo, totales y descuento
            vista.mostrarTicket(usuarioSesion, miCompra);
        } else {
            vista.mostrarMensaje("Error al registrar compra: " + resultado);
        }
    }

    /**
     * Muestra los datos básicos del usuario en etiquetas de la vista.
     * Si no hay datos ingresados, muestra mensaje de campos vacíos.
     */
    public void mostrarDatosUsuario() {
        if (usuarioSesion == null || usuarioSesion.getNombre() == null) {
            vista.mostrarMensaje("Los campos se encuentran vacíos.");
            return;
        }
        vista.mostrarDatosUsuarioEnEtiquetas(usuarioSesion);
    }
}