import java.util.List;

public class Pelicula {
    //Atributos
    private String titulo;
    private int ano;
    private int duracionM;
    private String tipo;

    //Constructor
    public Pelicula() {
    }

    public Pelicula(String titulo, int ano, int duracionM, String tipo) {
        this.titulo = titulo;
        this.ano = ano;
        this.duracionM = duracionM;
        this.tipo = tipo;
    }

    public Pelicula(List<Estudio> estudios) {
        this.estudios = estudios;
    }

    //Getter and Setter
    public String getTitulo() {return titulo;}

    public void setTitulo(String titulo) {this.titulo = titulo;}

    public int getAno() {return ano;}

    public void setAno(int ano) {this.ano = ano;}

    public int getDuracionM() {return duracionM;}

    public void setDuracionM(int duracionM) {this.duracionM = duracionM;}

    public String getTipo() {return tipo;}

    public void setTipo(String tipo) {this.tipo = tipo;}

    //GETTER AND SETTER DE ESTUDIOS (para poder hacer que una película ya pueda tener varios estudios)
    public List<Estudio> getEstudios() {
        return estudios;
    }
    public void setEstudios(List<Estudio> estudios) {
        this.estudios = estudios;
    }

    //RELACIÓN: Pelicula producida por uno o más estudios
    private List<Estudio> estudios;

    public void setListaEstudios(Estudio e){

    }

}
