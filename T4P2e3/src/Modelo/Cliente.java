package Modelo;

public class Cliente extends Persona {
    //ATRIBUTOS
    protected String telefono;

    //CONSTRUCTOR
    public Cliente(String telefono) {
        this.telefono = telefono;
    }

    public Cliente(String nombre, int edad, String telefono) {
        super(nombre, edad);
        this.telefono = telefono;
    }

    //GETTER AND SETTER
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    //toSTRING
    public String mostrarCliente() {
        return "El cliente llamado '" + getNombre() +"' tiene "+ getEdad() +" años y su nº de telefono es"+ telefono;
    }
}