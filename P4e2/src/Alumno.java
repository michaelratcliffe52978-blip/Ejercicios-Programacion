public class Alumno {
    private int codigo;
    private String nombre;
    private String domicilio;
    private int telefono;

    //CONSTRUCTOR

    public Alumno() {
    }
    public Alumno(int codigo, String nombre, String domicilio, int telefono) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.telefono = telefono;
    }

    //GETTER AND SETTER
    public int getCodigo() { return codigo; }

    public void setCodigo(int codigo) { this.codigo = codigo; }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDomicilio() { return domicilio; }

    public void setDomicilio(String domicilio) { this.domicilio = domicilio; }

    public int getTelefono() { return telefono; }

    public void setTelefono(int telefono) { this.telefono = telefono; }

    //TO STRING
    @Override
    public String toString() {
        return "El alumno '" +nombre+"' con el codigo "+ codigo+" vive en "+domicilio+" y su nº de telefono es"+ telefono;
    }


}
