package Libreria;

import java.time.LocalDate;

public class Autor {
    //Atributos
    private String nombreAutor;
    private LocalDate fechaNacimientoAutor;
    private String paisNacimientoAutor;

    //Constructor
    public Autor() {
    }
    public Autor(String nombreAutor, LocalDate fechaNacimientoAutor, String paisNacimientoAutor) {
        this.nombreAutor = nombreAutor;
        this.fechaNacimientoAutor = fechaNacimientoAutor;
        this.paisNacimientoAutor = paisNacimientoAutor;
    }

    //Getter and Setter
    public String getNombreAutor() {return nombreAutor;}
    public void setNombreAutor(String nombreAutor) {this.nombreAutor = nombreAutor;}

    public LocalDate getFechaNacimientoAutor() {return fechaNacimientoAutor;}
    public void setFechaNacimientoAutor(LocalDate fechaNacimientoAutor) {this.fechaNacimientoAutor = fechaNacimientoAutor;}

    public String getPaisNacimientoAutor() {return paisNacimientoAutor;}
    public void setPaisNacimientoAutor(String paisNacimientoAutor) {this.paisNacimientoAutor = paisNacimientoAutor;}

    //toString
    @Override
    public String toString() {
        return "Autor{" +
                "nombreAutor='" + nombreAutor + '\'' +
                ", fechaNacimientoAutor=" + fechaNacimientoAutor +
                ", paisNacimientoAutor='" + paisNacimientoAutor + '\'' +
                '}';
    }
}
