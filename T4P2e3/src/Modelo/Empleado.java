package Modelo;

public class Empleado extends Persona {
    //ATRIBUTOS
    private double SueldoBruto;

    //CONSTRUCTOR
    public Empleado(double sueldoBruto) {
        SueldoBruto = sueldoBruto;
    }

    public Empleado(String nombre, int edad, double sueldoBruto) {
        super(nombre, edad);
        SueldoBruto = sueldoBruto;
    }

    //GETTER AND SETTER
    public double getSueldoBruto() {return SueldoBruto;}
    public void setSueldoBruto(double sueldoBruto) {SueldoBruto = sueldoBruto;}

    //toSTRING
    public String mostrarEmpleado() {
        return "El Modelo.Empleado tiene un sueldo bruto de " + SueldoBruto +"€.";
    }

}
