package Modelo;

import java.util.List;

public class Directivo extends Empleado{
    //ATRIBUTOS
    private String categoria;
    //Relacion con Empleado
    private List<Empleado> subordinados;

    //CONSTRUCTOR
    public Directivo(double sueldoBruto, String categoria, List<Empleado> subordinados) {
        super(sueldoBruto);
        this.categoria = categoria;
        this.subordinados = subordinados;
    }

    public Directivo(String nombre, int edad, double sueldoBruto, String categoria, List<Empleado> subordinados) {
        super(nombre, edad, sueldoBruto);
        this.categoria = categoria;
        this.subordinados = subordinados;
    }

    //GETTER AND SETTER
    public String getCategoria() {return categoria;}
    public void setCategoria(String categoria) {this.categoria = categoria;}

    public List<Empleado> getSubordinados() {return subordinados;}
    public void setSubordinados(List<Empleado> subordinados) {this.subordinados = subordinados;}

    //toSTRING
    public String mostrar() {
        return "Directivo{" +
                "categoria='" + categoria + '\'' +
                ", subordinados=" + subordinados +
                '}';
    }
}
