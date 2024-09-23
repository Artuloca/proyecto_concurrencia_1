// File: src/main/java/io/bootify/my_app/Visual/PantallaMenu.java
package io.bootify.my_app.Visual;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaMenu extends JFrame {

    private JTextField nombreUsuarioField;
    private JPasswordField contraseñaField;
    private JButton submitButton;

    public PantallaMenu() {
        setTitle("Pantalla de Menú");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear los componentes
        nombreUsuarioField = new JTextField(15);
        contraseñaField = new JPasswordField(15);
        submitButton = new JButton("Enviar");

        // Configurar el layout
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Añadir los componentes al frame
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Nombre de Usuario:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        add(nombreUsuarioField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Contraseña:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        add(contraseñaField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        add(submitButton, gbc);

        // Añadir el ActionListener al botón
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreUsuario = nombreUsuarioField.getText();
                String contraseña = new String(contraseñaField.getPassword());

                // Aquí puedes agregar la lógica para manejar el nombre de usuario y la contraseña
                System.out.println("Usuario: " + nombreUsuario);
                System.out.println("Contraseña: " + contraseña);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PantallaMenu().setVisible(true);
            }
        });
    }
}