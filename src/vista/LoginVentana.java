package vista;

import controlador.LoginControlador;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Ventana de Login para la tienda DON APARATO.
 * Permite al usuario ingresar con su nombre o ir al registro.
 */
public class LoginVentana extends JFrame implements ActionListener {

    private LoginControlador controlador;
    private JTextField txtUsuario;
    private JButton btnIngresar, btnRegistro;

    public LoginVentana() {
        setTitle("DON APARATO - Inicio de Sesión");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);
        getContentPane().setBackground(new Color(245, 245, 250));

        iniciarComponentes();
    }

    private void iniciarComponentes() {
        // Título de bienvenida
        JLabel lblTitulo = new JLabel("Bienvenido a DON APARATO", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        lblTitulo.setForeground(new Color(33, 37, 41));
        lblTitulo.setBounds(20, 15, 300, 30);
        add(lblTitulo);

        // Etiqueta "Usuario:"
        JLabel lblUsuario = new JLabel("Nombre de usuario:");
        lblUsuario.setFont(new Font("Arial", Font.PLAIN, 13));
        lblUsuario.setBounds(40, 60, 150, 20);
        add(lblUsuario);

        // Campo de texto
        txtUsuario = new JTextField();
        txtUsuario.setBounds(40, 85, 260, 28);
        txtUsuario.setFont(new Font("Arial", Font.PLAIN, 13));
        add(txtUsuario);

        // Botón Ingresar
        btnIngresar = new JButton("Ingresar");
        btnIngresar.setBounds(40, 125, 125, 30);
        btnIngresar.setFont(new Font("Arial", Font.BOLD, 12));
        btnIngresar.setBackground(new Color(40, 167, 69));
        btnIngresar.setForeground(Color.WHITE);
        btnIngresar.setFocusPainted(false);
        btnIngresar.addActionListener(this);
        add(btnIngresar);

        // Botón Registrarse
        btnRegistro = new JButton("Registrarse");
        btnRegistro.setBounds(175, 125, 125, 30);
        btnRegistro.setFont(new Font("Arial", Font.BOLD, 12));
        btnRegistro.setBackground(new Color(0, 123, 255));
        btnRegistro.setForeground(Color.WHITE);
        btnRegistro.setFocusPainted(false);
        btnRegistro.addActionListener(this);
        add(btnRegistro);
    }

    public void setControlador(LoginControlador controlador) {
        this.controlador = controlador;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnIngresar) {
            controlador.validarIngreso(txtUsuario.getText().trim());
        } else if (e.getSource() == btnRegistro) {
            controlador.abrirRegistro();
        }
    }

    public void mostrarMensaje(String msg) {
        JOptionPane.showMessageDialog(this, msg);
    }
}