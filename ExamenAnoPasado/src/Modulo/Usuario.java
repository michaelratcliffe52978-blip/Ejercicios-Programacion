package Modulo;

public class Usuario {
    //Atributos
    private String nome;
    private String email;

    //Constructor
    public Usuario() {
    }
    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    //Getter and Setter
    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

}
