package Modelo;


public class Titular {
    //ATRIBUTOS
    private int id;
    private String dni;
    private String nombre;

    //CONSTRUCTORES
    public Titular(String dni, String nombre) {
    }

    public Titular(int id, String dni, String nombre) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
    }

    //GETTERS Y SETTERS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //TO STRING
    @Override
    public String toString() {
        return "Titular{" +
                "id='" + id + '\'' +
                ", dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
