package biblioteca;

public class Libros {
    private String titulo;
    private String autor;

    public Libros(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }
}