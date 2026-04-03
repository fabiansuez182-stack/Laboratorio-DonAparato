package controlador;

import modelo.DAO.CompraDAO;
import modelo.DTO.CompraDTO;
import modelo.DTO.UsuarioDTO;
import modelo.operaciones.Procesos;
import vista.PanelPrincipalVentana;

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

    public void iniciar() {
        vista.cargarDatosUsuario(usuarioSesion);
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
    }

    public void procesarCompra(CompraDTO miCompra) {
        miCompra.setIdUsuario(usuarioSesion.getId());
        misProcesos.calcularTotales(miCompra, usuarioSesion);

        String resultado = miCompraDAO.registrarCompra(miCompra);

        if (resultado.equals("OK")) {
            vista.mostrarTicket(usuarioSesion, miCompra);
        } else {
            vista.mostrarMensaje("Error al registrar compra: " + resultado);
        }
    }

    public void mostrarDatosUsuario() {
        if (usuarioSesion == null || usuarioSesion.getNombre() == null) {
            vista.mostrarMensaje("Los campos se encuentran vacíos.");
            return;
        }
        vista.mostrarDatosUsuarioEnEtiquetas(usuarioSesion);
    }
}