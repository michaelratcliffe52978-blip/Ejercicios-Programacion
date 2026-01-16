package Modelo;

public class Persona {
    //ATRIBUTOS
    private String nombre;
    private int edad;

    //CONSTRUCTOR
    public Persona() {
    }
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
    //GETTER AND SETTER

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public int getEdad() {return edad;}
    public void setEdad(int edad) {this.edad = edad;}

    //toSTRING
    public String mostrar() {
        return "Se llama '" + nombre + "' y tiene "+edad+" años.";
    }
}
