package Modulo;

import java.util.ArrayList;

public class Usuario {
    //Atributos
    private String nombre;
    private String email;
    private ArrayList<Pedido> pedidos;

    //Constructor
    public Usuario() {
    }

    public Usuario(String nome, String email, ArrayList<Pedido> pedidos) {
        this.nombre = nome;
        this.email = email;
        this.pedidos = pedidos;
    }

    //Getter and Setter
    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public void setPedido(Pedido pedido){
        this.pedidos.add(pedido);
    }
}
