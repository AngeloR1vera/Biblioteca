package biblioteca;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    public Login() {
        setTitle("Inicio de Sesión");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        usernameField = new JTextField(15);
        passwordField = new JPasswordField(15);
        JButton loginButton = new JButton("Iniciar Sesión");

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if (BibliotecaApp.authenticate(username, password)) {
                    JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso");
                    dispose();  // Cierra la ventana de login
                    // Lógica para acceder a la biblioteca
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
                }
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Usuario:"));
        panel.add(usernameField);
        panel.add(new JLabel("Contraseña:"));
        panel.add(passwordField);
        panel.add(loginButton);

        add(panel);
    }
}