package biblioteca;

public class User {
    private String name;
    private String program;
    private String id;
    private String phone;
    private String email;
    private String username;
    private String password;

    // Constructor
    public User(String name, String program, String id, String phone, String email, String username, String password) {
        this.name = name;
        this.program = program;
        this.id = id;
        this.phone = phone;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public User(String name, String program, String id, String phone, String email) {
    }

    // Getters para los atributos
    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public boolean validatePassword(String password) {
        return this.password.equals(password);
    }
}
