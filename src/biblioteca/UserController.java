package biblioteca;

public class UserController {
    private User user;

    // Constructor principal que recibe todos los datos
    public UserController(String name, String program, String id, String phone, String email, String username, String password) {
        this.user = new User(name, program, id, phone, email, username, password);
    }

    // Constructor alternativo para solo username y password
    public UserController(String username, String password) {
        this.user = new User("", "", "", "", "", username, password);
    }

    // Método para obtener el objeto User
    public User getUser() {
        return this.user;
    }
}