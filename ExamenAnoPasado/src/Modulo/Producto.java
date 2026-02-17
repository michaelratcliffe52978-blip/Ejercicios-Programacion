package Modulo;

public class Producto {
    //Atributos
    private String nombre;
    private Double precio;
    private int Stock;

    //Constructor
    public Producto() {
    }
    public Producto(String nombre, Double precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        Stock = stock;
    }

    //Getter and Setter
    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public Double getPrecio() {return precio;}
    public void setPrecio(Double precio) {this.precio = precio;}

    public int getStock() {return Stock;}
    public void setStock(int stock) {Stock = stock;}


}
