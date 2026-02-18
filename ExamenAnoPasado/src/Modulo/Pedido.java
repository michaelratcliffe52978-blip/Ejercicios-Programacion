package Modulo;

import java.time.LocalDate;

public class Pedido {
    //Atributos
    private Usuario usuario;
    private Producto producto;
    private LocalDate fecha;

    //Getter and Setter
    public Pedido() {
    }

    public Pedido(Usuario usuario, Producto producto, LocalDate fecha) {
        this.usuario = usuario;
        this.producto = producto;
        this.fecha = fecha;
    }

    //Getter and Setter
    public Usuario getUsuario() {return usuario;}
    public void setUsuario(Usuario usuario) {this.usuario = usuario;}

    public Producto getProducto() {return producto;}
    public void setProducto(Producto producto) {this.producto = producto;}

    public LocalDate getFecha() {return fecha;}
    public void setFecha(LocalDate fecha) {this.fecha = fecha;}
}
