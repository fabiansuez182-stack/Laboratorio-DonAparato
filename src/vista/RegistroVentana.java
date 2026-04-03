package vista;

import controlador.RegistroControlador;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistroVentana extends JFrame implements ActionListener {

    private RegistroControlador controlador;

    private JTextField txtNombre, txtApellido, txtEdad, txtTelefono;
    private JComboBox<String> cmbTipo;
    private JButton btnGuardar, btnVolver;

    public RegistroVentana() {
        setTitle("DON APARATO - Registro de Usuario");
        setSize(420, 380);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);
        getContentPane().setBackground(new Color(245, 245, 250));

        iniciarComponentes();
    }

    private void iniciarComponentes() {
        Font fuenteLabel = new Font("Arial", Font.BOLD, 12);
        Font fuenteCampo = new Font("Arial", Font.PLAIN, 12);

        JPanel panelForm = new JPanel();
        panelForm.setBounds(15, 10, 375, 260);
        panelForm.setLayout(null);
        panelForm.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(0, 123, 255)),
                "Datos del Nuevo Usuario",
                TitledBorder.LEFT, TitledBorder.TOP, fuenteLabel, new Color(0, 123, 255)));
        panelForm.setBackground(Color.WHITE);
        add(panelForm);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setFont(fuenteLabel);
        lblNombre.setBounds(20, 30, 80, 20);
        panelForm.add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(110, 30, 240, 25);
        txtNombre.setFont(fuenteCampo);
        panelForm.add(txtNombre);

        JLabel lblApellido = new JLabel("Apellido:");
        lblApellido.setFont(fuenteLabel);
        lblApellido.setBounds(20, 70, 80, 20);
        panelForm.add(lblApellido);

        txtApellido = new JTextField();
        txtApellido.setBounds(110, 70, 240, 25);
        txtApellido.setFont(fuenteCampo);
        panelForm.add(txtApellido);

        JLabel lblEdad = new JLabel("Edad:");
        lblEdad.setFont(fuenteLabel);
        lblEdad.setBounds(20, 110, 80, 20);
        panelForm.add(lblEdad);

        txtEdad = new JTextField();
        txtEdad.setBounds(110, 110, 80, 25);
        txtEdad.setFont(fuenteCampo);
        panelForm.add(txtEdad);

        JLabel lblTelefono = new JLabel("Teléfono:");
        lblTelefono.setFont(fuenteLabel);
        lblTelefono.setBounds(20, 150, 80, 20);
        panelForm.add(lblTelefono);

        txtTelefono = new JTextField();
        txtTelefono.setBounds(110, 150, 240, 25);
        txtTelefono.setFont(fuenteCampo);
        panelForm.add(txtTelefono);

        JLabel lblTipo = new JLabel("Tipo:");
        lblTipo.setFont(fuenteLabel);
        lblTipo.setBounds(20, 190, 80, 20);
        panelForm.add(lblTipo);

        cmbTipo = new JComboBox<>(new String[] { "Ninguno", "A", "B", "C" });
        cmbTipo.setBounds(110, 190, 100, 25);
        cmbTipo.setFont(fuenteCampo);
        panelForm.add(cmbTipo);

        JLabel lblTipoInfo = new JLabel("(A=40%, B=20%, C=10% descuento)");
        lblTipoInfo.setFont(new Font("Arial", Font.ITALIC, 11));
        lblTipoInfo.setForeground(new Color(108, 117, 125));
        lblTipoInfo.setBounds(220, 190, 200, 20);
        panelForm.add(lblTipoInfo);

        btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(55, 290, 140, 35);
        btnGuardar.setFont(new Font("Arial", Font.BOLD, 12));
        btnGuardar.setBackground(new Color(40, 167, 69));
        btnGuardar.setForeground(Color.WHITE);
        btnGuardar.setFocusPainted(false);
        btnGuardar.addActionListener(this);
        add(btnGuardar);

        btnVolver = new JButton("Volver al Login");
        btnVolver.setBounds(215, 290, 140, 35);
        btnVolver.setFont(new Font("Arial", Font.BOLD, 12));
        btnVolver.setBackground(new Color(108, 117, 125));
        btnVolver.setForeground(Color.WHITE);
        btnVolver.setFocusPainted(false);
        btnVolver.addActionListener(this);
        add(btnVolver);
    }

    public void setControlador(RegistroControlador controlador) {
        this.controlador = controlador;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnVolver) {
            controlador.volverAlLogin();
        } else if (e.getSource() == btnGuardar) {
            controlador.guardarUsuario(
                    txtNombre.getText().trim(),
                    txtApellido.getText().trim(),
                    txtEdad.getText().trim(),
                    txtTelefono.getText().trim(),
                    (String) cmbTipo.getSelectedItem());
        }
    }

    public void mostrarMensaje(String msg) {
        JOptionPane.showMessageDialog(this, msg);
    }
}