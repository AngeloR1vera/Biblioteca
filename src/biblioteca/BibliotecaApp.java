package biblioteca;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BibliotecaApp {
    private static ArrayList<User> usuarios = new ArrayList<>();
    private JFrame frame;
    private CardLayout cardLayout;
    private JPanel mainPanel;

    public BibliotecaApp() {
        // Crear el marco de la aplicación
        frame = new JFrame("Biblioteca App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null); // Centrar la ventana

        // Crear el CardLayout y el panel principal
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Agregar el panel principal al frame
        frame.add(mainPanel);

        // Crear las pantallas
        mainPanel.add(createMainPanel(), "Main");
        mainPanel.add(new LoginInterface(this), "Login");
        mainPanel.add(new RegistroInterface(this), "Registro");

        // Mostrar la pantalla principal
        cardLayout.show(mainPanel, "Main");

        // Hacer la ventana visible
        frame.setVisible(true);
    }

    private JPanel createMainPanel() {
        // Crear el panel principal con los botones
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Botón de Iniciar Sesión
        JButton loginButton = new JButton("Iniciar Sesión");
        Font buttonFont = new Font("Arial", Font.BOLD, 16);
        loginButton.setFont(buttonFont);
        loginButton.setPreferredSize(new Dimension(150, 40));
        loginButton.addActionListener(e -> cardLayout.show(mainPanel, "Login"));

        // Botón de Registrar
        JButton registerButton = new JButton("Registrar");
        registerButton.setFont(buttonFont);
        registerButton.setPreferredSize(new Dimension(150, 40));
        registerButton.addActionListener(e -> cardLayout.show(mainPanel, "Registro"));

        // Añadir los botones al panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(loginButton, gbc);

        gbc.gridy = 1;
        panel.add(registerButton, gbc);

        return panel;
    }

    public static void addUser(User user) {
        usuarios.add(user);
    }

    public static boolean authenticate(String username, String password) {
        for (User user : usuarios) {
            if (user.getUsername().equals(username) && user.validatePassword(password)) {
                return true;
            }
        }
        return false;
    }

    // Método para mostrar el panel principal
    public void showMainPanel() {
        cardLayout.show(mainPanel, "Main");
    }

    // Método para obtener la ventana principal (frame)
    public JFrame getFrame() {
        return frame;
    }
}
