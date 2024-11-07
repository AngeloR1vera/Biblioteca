package biblioteca;

import javax.swing.*;
import java.awt.*;

public class LoginInterface extends JPanel {
    public LoginInterface(BibliotecaApp app) {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Crear los componentes
        JLabel usernameLabel = new JLabel("Usuario:");
        JTextField usernameField = new JTextField(15);

        JLabel passwordLabel = new JLabel("Contraseña:");
        JPasswordField passwordField = new JPasswordField(15);

        JButton loginButton = new JButton("Iniciar Sesión");
        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            if (BibliotecaApp.authenticate(username, password)) {
                JOptionPane.showMessageDialog(this, "Inicio de sesión exitoso");
                // Volver a la pantalla principal
                app.showMainPanel();
            } else {
                JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos");
            }
        });

        // Botón para regresar al panel principal
        JButton backButton = new JButton("Volver");
        backButton.addActionListener(e -> app.showMainPanel());

        // Configurar el layout
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(usernameLabel, gbc);

        gbc.gridx = 1;
        add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(passwordLabel, gbc);

        gbc.gridx = 1;
        add(passwordField, gbc);

        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(loginButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(backButton, gbc);  // Añadir botón Volver
    }
}