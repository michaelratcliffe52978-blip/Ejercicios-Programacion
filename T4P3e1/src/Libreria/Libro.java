package Libreria;

public class Libro {
    //Atributos
    private String titulo;
    private String editorial;
    private int numeroPaginas;

    //Constructor
    public Libro() {
    }
    public Libro(String titulo, String editorial, int numeroPaginas) {
        this.titulo = titulo;
        this.editorial = editorial;
        this.numeroPaginas = numeroPaginas;
    }

    //Getter and Setter
    public String getTitulo() {return titulo;}
    public void setTitulo(String titulo) {this.titulo = titulo;}

    public String getEditorial() {return editorial;}
    public void setEditorial(String editorial) {this.editorial = editorial;}

    public int getNumeroPaginas() {return numeroPaginas;}
    public void setNumeroPaginas(int numeroPaginas) {
        if (numeroPaginas > 0) {
            this.numeroPaginas = numeroPaginas;
        } else {
            System.out.println("Las páginas deben ser mayores que 0");
            this.numeroPaginas = 1;
        }}

    //toString
    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", editorial='" + editorial + '\'' +
                ", numeroPaginas=" + numeroPaginas +
                '}';
    }
}
