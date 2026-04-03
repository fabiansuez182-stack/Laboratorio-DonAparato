package vista;

import controlador.PanelPrincipalControlador;
import modelo.DTO.CompraDTO;
import modelo.DTO.UsuarioDTO;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelPrincipalVentana extends JFrame implements ActionListener {

    private PanelPrincipalControlador controlador;

    private JTextField txtNombre, txtApellido, txtEdad, txtTelefono, txtTipo;
    private JTextField txtProducto, txtPrecio, txtCantidad;
    private JButton btnComprar, btnMostrarDatos, btnLimpiar;

    private JPanel panelTicket;
    private JLabel lblTicketUsuario, lblTicketTipo, lblTicketSubtotal;
    private JLabel lblTicketDescuento, lblTicketTotal;

    private JPanel panelDatosUsuario;
    private JLabel lblDatoNombre, lblDatoApellido, lblDatoEdad;
    private JLabel lblDatoTelefono, lblDatoTipo;

    public PanelPrincipalVentana() {
        setTitle("DON APARATO - Sistema de Ventas");
        setSize(600, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);
        getContentPane().setBackground(new Color(245, 245, 250));

        iniciarComponentes();
    }

    public void setControlador(PanelPrincipalControlador controlador) {
        this.controlador = controlador;
    }

    private void iniciarComponentes() {
        Font fuenteLabel = new Font("Arial", Font.BOLD, 12);
        Font fuenteCampo = new Font("Arial", Font.PLAIN, 12);

        JPanel panelCliente = new JPanel();
        panelCliente.setBounds(15, 10, 555, 110);
        panelCliente.setLayout(null);
        panelCliente.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(0, 123, 255)),
                "Datos del Cliente (Sesión Activa)",
                TitledBorder.LEFT, TitledBorder.TOP, fuenteLabel, new Color(0, 123, 255)));
        panelCliente.setBackground(Color.WHITE);
        add(panelCliente);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setFont(fuenteLabel);
        lblNombre.setBounds(15, 25, 70, 20);
        panelCliente.add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(85, 25, 150, 25);
        txtNombre.setEditable(false);
        txtNombre.setFont(fuenteCampo);
        txtNombre.setBackground(new Color(233, 236, 239));
        panelCliente.add(txtNombre);

        JLabel lblApellido = new JLabel("Apellido:");
        lblApellido.setFont(fuenteLabel);
        lblApellido.setBounds(260, 25, 70, 20);
        panelCliente.add(lblApellido);

        txtApellido = new JTextField();
        txtApellido.setBounds(335, 25, 150, 25);
        txtApellido.setEditable(false);
        txtApellido.setFont(fuenteCampo);
        txtApellido.setBackground(new Color(233, 236, 239));
        panelCliente.add(txtApellido);

        JLabel lblEdad = new JLabel("Edad:");
        lblEdad.setFont(fuenteLabel);
        lblEdad.setBounds(15, 60, 50, 20);
        panelCliente.add(lblEdad);

        txtEdad = new JTextField();
        txtEdad.setBounds(65, 60, 50, 25);
        txtEdad.setEditable(false);
        txtEdad.setFont(fuenteCampo);
        txtEdad.setBackground(new Color(233, 236, 239));
        panelCliente.add(txtEdad);

        JLabel lblTelefono = new JLabel("Teléfono:");
        lblTelefono.setFont(fuenteLabel);
        lblTelefono.setBounds(135, 60, 70, 20);
        panelCliente.add(lblTelefono);

        txtTelefono = new JTextField();
        txtTelefono.setBounds(210, 60, 120, 25);
        txtTelefono.setEditable(false);
        txtTelefono.setFont(fuenteCampo);
        txtTelefono.setBackground(new Color(233, 236, 239));
        panelCliente.add(txtTelefono);

        JLabel lblTipo = new JLabel("Tipo:");
        lblTipo.setFont(fuenteLabel);
        lblTipo.setBounds(355, 60, 40, 20);
        panelCliente.add(lblTipo);

        txtTipo = new JTextField();
        txtTipo.setBounds(395, 60, 80, 25);
        txtTipo.setEditable(false);
        txtTipo.setFont(fuenteCampo);
        txtTipo.setBackground(new Color(233, 236, 239));
        panelCliente.add(txtTipo);

        JPanel panelProducto = new JPanel();
        panelProducto.setBounds(15, 130, 555, 80);
        panelProducto.setLayout(null);
        panelProducto.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(40, 167, 69)),
                "Datos del Producto",
                TitledBorder.LEFT, TitledBorder.TOP, fuenteLabel, new Color(40, 167, 69)));
        panelProducto.setBackground(Color.WHITE);
        add(panelProducto);

        JLabel lblProducto = new JLabel("Producto:");
        lblProducto.setFont(fuenteLabel);
        lblProducto.setBounds(15, 30, 70, 20);
        panelProducto.add(lblProducto);

        txtProducto = new JTextField();
        txtProducto.setBounds(90, 30, 150, 25);
        txtProducto.setFont(fuenteCampo);
        panelProducto.add(txtProducto);

        JLabel lblPrecio = new JLabel("Precio Unit.:");
        lblPrecio.setFont(fuenteLabel);
        lblPrecio.setBounds(260, 30, 85, 20);
        panelProducto.add(lblPrecio);

        txtPrecio = new JTextField();
        txtPrecio.setBounds(350, 30, 80, 25);
        txtPrecio.setFont(fuenteCampo);
        panelProducto.add(txtPrecio);

        JLabel lblCantidad = new JLabel("Cant.:");
        lblCantidad.setFont(fuenteLabel);
        lblCantidad.setBounds(445, 30, 40, 20);
        panelProducto.add(lblCantidad);

        txtCantidad = new JTextField();
        txtCantidad.setBounds(490, 30, 50, 25);
        txtCantidad.setFont(fuenteCampo);
        panelProducto.add(txtCantidad);

        btnComprar = new JButton("Realizar Compra");
        btnComprar.setBounds(15, 220, 170, 35);
        btnComprar.setFont(new Font("Arial", Font.BOLD, 12));
        btnComprar.setBackground(new Color(40, 167, 69));
        btnComprar.setForeground(Color.WHITE);
        btnComprar.setFocusPainted(false);
        btnComprar.addActionListener(this);
        add(btnComprar);

        btnMostrarDatos = new JButton("Mostrar Datos del Usuario");
        btnMostrarDatos.setBounds(195, 220, 210, 35);
        btnMostrarDatos.setFont(new Font("Arial", Font.BOLD, 12));
        btnMostrarDatos.setBackground(new Color(0, 123, 255));
        btnMostrarDatos.setForeground(Color.WHITE);
        btnMostrarDatos.setFocusPainted(false);
        btnMostrarDatos.addActionListener(this);
        add(btnMostrarDatos);

        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setBounds(415, 220, 155, 35);
        btnLimpiar.setFont(new Font("Arial", Font.BOLD, 12));
        btnLimpiar.setBackground(new Color(220, 53, 69));
        btnLimpiar.setForeground(Color.WHITE);
        btnLimpiar.setFocusPainted(false);
        btnLimpiar.addActionListener(this);
        add(btnLimpiar);

        panelTicket = new JPanel();
        panelTicket.setBounds(15, 265, 555, 150);
        panelTicket.setLayout(null);
        panelTicket.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(255, 193, 7)),
                "Ticket de Compra",
                TitledBorder.LEFT, TitledBorder.TOP, fuenteLabel, new Color(255, 193, 7)));
        panelTicket.setBackground(new Color(255, 255, 240));
        panelTicket.setVisible(false);
        add(panelTicket);

        Font fuenteTicket = new Font("Arial", Font.PLAIN, 13);

        lblTicketUsuario = new JLabel();
        lblTicketUsuario.setFont(fuenteTicket);
        lblTicketUsuario.setBounds(15, 25, 400, 20);
        panelTicket.add(lblTicketUsuario);

        lblTicketTipo = new JLabel();
        lblTicketTipo.setFont(fuenteTicket);
        lblTicketTipo.setBounds(15, 50, 400, 20);
        panelTicket.add(lblTicketTipo);

        lblTicketSubtotal = new JLabel();
        lblTicketSubtotal.setFont(fuenteTicket);
        lblTicketSubtotal.setBounds(15, 75, 400, 20);
        panelTicket.add(lblTicketSubtotal);

        lblTicketDescuento = new JLabel();
        lblTicketDescuento.setFont(new Font("Arial", Font.BOLD, 13));
        lblTicketDescuento.setForeground(new Color(220, 53, 69));
        lblTicketDescuento.setBounds(15, 100, 400, 20);
        panelTicket.add(lblTicketDescuento);

        lblTicketTotal = new JLabel();
        lblTicketTotal.setFont(new Font("Arial", Font.BOLD, 14));
        lblTicketTotal.setForeground(new Color(40, 167, 69));
        lblTicketTotal.setBounds(15, 125, 400, 20);
        panelTicket.add(lblTicketTotal);

        panelDatosUsuario = new JPanel();
        panelDatosUsuario.setBounds(15, 425, 555, 150);
        panelDatosUsuario.setLayout(null);
        panelDatosUsuario.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(108, 117, 125)),
                "Información del Usuario",
                TitledBorder.LEFT, TitledBorder.TOP, fuenteLabel, new Color(108, 117, 125)));
        panelDatosUsuario.setBackground(Color.WHITE);
        panelDatosUsuario.setVisible(false);
        add(panelDatosUsuario);

        Font fuenteDatos = new Font("Arial", Font.PLAIN, 13);

        lblDatoNombre = new JLabel();
        lblDatoNombre.setFont(fuenteDatos);
        lblDatoNombre.setBounds(15, 25, 400, 20);
        panelDatosUsuario.add(lblDatoNombre);

        lblDatoApellido = new JLabel();
        lblDatoApellido.setFont(fuenteDatos);
        lblDatoApellido.setBounds(15, 50, 400, 20);
        panelDatosUsuario.add(lblDatoApellido);

        lblDatoEdad = new JLabel();
        lblDatoEdad.setFont(fuenteDatos);
        lblDatoEdad.setBounds(15, 75, 400, 20);
        panelDatosUsuario.add(lblDatoEdad);

        lblDatoTelefono = new JLabel();
        lblDatoTelefono.setFont(fuenteDatos);
        lblDatoTelefono.setBounds(15, 100, 400, 20);
        panelDatosUsuario.add(lblDatoTelefono);

        lblDatoTipo = new JLabel();
        lblDatoTipo.setFont(fuenteDatos);
        lblDatoTipo.setBounds(15, 125, 400, 20);
        panelDatosUsuario.add(lblDatoTipo);
    }

    public void cargarDatosUsuario(UsuarioDTO u) {
        txtNombre.setText(u.getNombre());
        txtApellido.setText(u.getApellido());
        txtEdad.setText(String.valueOf(u.getEdad()));
        txtTelefono.setText(u.getTelefono());

        String tipo = u.getTipo();
        if (tipo == null || tipo.trim().isEmpty()) {
            txtTipo.setText("Sin tipo");
        } else {
            txtTipo.setText(tipo);
        }
    }

    public void mostrarTicket(UsuarioDTO usuario, CompraDTO compra) {
        lblTicketUsuario.setText("Cliente: " + usuario.getNombre() + " " + usuario.getApellido());

        String tipo = usuario.getTipo();
        if (tipo == null || tipo.trim().isEmpty()) {
            lblTicketTipo.setText("Tipo de Cliente: Sin afiliación");
        } else {
            lblTicketTipo.setText("Tipo de Cliente: " + tipo);
        }

        lblTicketSubtotal.setText("Precio Total de la Compra: $" +
                String.format("%.2f", compra.getTotalBruto()));

        if (compra.getDescuentoAplicado() == 0) {
            lblTicketDescuento.setText("No se le realiza descuento");
        } else {
            lblTicketDescuento.setText("Descuento Aplicado: -$" +
                    String.format("%.2f", compra.getDescuentoAplicado()));
        }

        lblTicketTotal.setText("Precio Real a Pagar: $" +
                String.format("%.2f", compra.getTotalNeto()));

        panelTicket.setVisible(true);
        JOptionPane.showMessageDialog(this, "¡Compra registrada con éxito!");
    }

    public void mostrarDatosUsuarioEnEtiquetas(UsuarioDTO u) {
        lblDatoNombre.setText("Nombre: " + u.getNombre());
        lblDatoApellido.setText("Apellido: " + u.getApellido());
        lblDatoEdad.setText("Edad: " + u.getEdad());
        lblDatoTelefono.setText("Teléfono: " + u.getTelefono());

        String tipo = u.getTipo();
        if (tipo == null || tipo.trim().isEmpty()) {
            lblDatoTipo.setText("Tipo de Cliente: Sin afiliación");
        } else {
            lblDatoTipo.setText("Tipo de Cliente: " + tipo);
        }

        panelDatosUsuario.setVisible(true);
    }

    public void mostrarMensaje(String msg) {
        JOptionPane.showMessageDialog(this, msg);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnMostrarDatos) {
            controlador.mostrarDatosUsuario();

        } else if (e.getSource() == btnLimpiar) {
            txtProducto.setText("");
            txtPrecio.setText("");
            txtCantidad.setText("");
            // Ocultar los paneles de resultados
            panelTicket.setVisible(false);
            panelDatosUsuario.setVisible(false);

        } else if (e.getSource() == btnComprar) {
            if (txtProducto.getText().trim().isEmpty() ||
                    txtPrecio.getText().trim().isEmpty() ||
                    txtCantidad.getText().trim().isEmpty()) {
                mostrarMensaje("Los campos del producto se encuentran vacíos.");
                return;
            }
            try {
                CompraDTO c = new CompraDTO();
                c.setNombreProducto(txtProducto.getText().trim());
                c.setValorUnitario(Double.parseDouble(txtPrecio.getText().trim()));
                c.setCantidad(Integer.parseInt(txtCantidad.getText().trim()));
                controlador.procesarCompra(c);
            } catch (NumberFormatException ex) {
                mostrarMensaje("Error: El precio y la cantidad deben ser valores numéricos.");
            }
        }
    }
}