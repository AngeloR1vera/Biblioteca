package biblioteca;

import javax.swing.*;
import java.awt.*;

public class RegistroInterface extends JPanel {
    public RegistroInterface(BibliotecaApp app) {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Crear los componentes
        JLabel nameLabel = new JLabel("Nombre:");
        JTextField nameField = new JTextField(20);

        JLabel programLabel = new JLabel("Programa:");
        JTextField programField = new JTextField(20);

        JLabel idLabel = new JLabel("Identificación:");
        JTextField idField = new JTextField(20);

        JLabel phoneLabel = new JLabel("Celular:");
        JTextField phoneField = new JTextField(20);

        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField(20);

        JButton registerButton = new JButton("Registrar");
        registerButton.addActionListener(e -> {
            String name = nameField.getText();
            String program = programField.getText();
            String id = idField.getText();
            String phone = phoneField.getText();
            String email = emailField.getText();

            // Crear un nuevo usuario y añadirlo al sistema
            User newUser = new User(name, program, id, phone, email);
            BibliotecaApp.addUser(newUser);
            JOptionPane.showMessageDialog(this, "Usuario registrado exitosamente");
            // Volver a la pantalla principal
            app.showMainPanel();
        });

        // Botón para regresar al panel principal
        JButton backButton = new JButton("Volver");
        backButton.addActionListener(e -> app.showMainPanel());

        // Configurar el layout
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(nameLabel, gbc);

        gbc.gridx = 1;
        add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(programLabel, gbc);

        gbc.gridx = 1;
        add(programField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(idLabel, gbc);

        gbc.gridx = 1;
        add(idField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(phoneLabel, gbc);

        gbc.gridx = 1;
        add(phoneField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        add(emailLabel, gbc);

        gbc.gridx = 1;
        add(emailField, gbc);

        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 5;
        add(registerButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        add(backButton, gbc);  // Añadir botón Volver
    }
}