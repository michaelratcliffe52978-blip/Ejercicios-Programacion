package Modulo;

public class Producto {
    //Atributos
    private String nombre;
    private Float precio;
    private int Stock;

    //Constructor
    public Producto() {
    }

    public Producto(String nombre, Float precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        Stock = stock;
    }

    //Getter and Setter
    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public Float getPrecio() {return precio;}
    public void setPrecio(Float precio) {this.precio = precio;}

    public int getStock() {return Stock;}
    public void setStock(int stock) {Stock = stock;}


}
