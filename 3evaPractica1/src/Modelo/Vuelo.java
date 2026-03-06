package Modelo;

import java.time.LocalDate;

public class Vuelo {
    //ATRIBUTOS
    private String cod_vuelo;
    private LocalDate fecha_salida;;
    private String destino;
    private String procedencia;

    //CONSTRUCTORES
    public Vuelo() {
    }
    public Vuelo(String cod_vuelo, LocalDate fecha_salida, String destino, String procedencia) {
        this.cod_vuelo = cod_vuelo;
        this.fecha_salida = fecha_salida;
        this.destino = destino;
        this.procedencia = procedencia;
    }

    //GETTERS Y SETTERS
    public String getCod_vuelo() {return cod_vuelo;}
    public void setCod_vuelo(String cod_vuelo) {this.cod_vuelo = cod_vuelo;}

    public LocalDate getFecha_salida() {return fecha_salida;}
    public void setFecha_salida(LocalDate fecha_salida) {this.fecha_salida = fecha_salida;}

    public String getDestino() {return destino;}
    public void setDestino(String destino) {this.destino = destino;}

    public String getProcedencia() {return procedencia;}
    public void setProcedencia(String procedencia) {this.procedencia = procedencia;}

    //TO STRING
    @Override
    public String toString() {
        return "Vuelo{" +
                "cod_vuelo='" + cod_vuelo + '\'' +
                ", fecha_salida=" + fecha_salida +
                ", destino='" + destino + '\'' +
                ", procedencia='" + procedencia + '\'' +
                '}';
    }
}
