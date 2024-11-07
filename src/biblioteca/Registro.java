package biblioteca;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Registro extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    public Registro() {
        setTitle("Registro de Usuario");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        usernameField = new JTextField(15);
        passwordField = new JPasswordField(15);
        JButton registerButton = new JButton("Registrar");

        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                BibliotecaApp.addUser(new UserController(username, password).getUser());
                JOptionPane.showMessageDialog(null, "Usuario registrado exitosamente");
                dispose();
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Usuario:"));
        panel.add(usernameField);
        panel.add(new JLabel("Contraseña:"));
        panel.add(passwordField);
        panel.add(registerButton);

        add(panel);
    }
}