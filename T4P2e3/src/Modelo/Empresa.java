package Modelo;

import java.util.List;

public class Empresa {
    //ATRIBUTOS
    private String nombre;
    private List<Cliente> listaClientes;
    private List<Empleado> listaEmpleados;

    //CONSTRUCTOR
    public Empresa(String nombre, List<Cliente> listaClientes, List<Empleado> listaEmpleados) {
        this.nombre = nombre;
        this.listaClientes = listaClientes;
        this.listaEmpleados = listaEmpleados;
    }

    //GETTER AND SETTER
    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public List<Cliente> getListaClientes() {return listaClientes;}
    public void setListaClientes(List<Cliente> listaClientes) {this.listaClientes = listaClientes;}

    public List<Empleado> getListaEmpleados() {return listaEmpleados;}
    public void setListaEmpleados(List<Empleado> listaEmpleados) {this.listaEmpleados = listaEmpleados;}

    //toSTRING
    public String mostrarEmpresa() {
        return "Empresa{" +
                "nombre='" + nombre + '\'' +
                ", listaClientes=" + listaClientes +
                ", listaEmpleados=" + listaEmpleados +
                '}';
    }
}
