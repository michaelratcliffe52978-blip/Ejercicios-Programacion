package Libreria;

import java.time.LocalDate;

public class Alumno {
    //Atributos
    private String nombreAlumno;
    private String dniAlumno;
    private LocalDate fechaAlumno;
    private String paisNacimientoAlumno;

    //Constructor
    public Alumno() {
    }
    public Alumno(String nombreAlumno, String dniAlumno, LocalDate fechaAlumno, String paisNacimientoAlumno) {
        this.nombreAlumno = nombreAlumno;
        this.dniAlumno = dniAlumno;
        this.fechaAlumno = fechaAlumno;
        this.paisNacimientoAlumno = paisNacimientoAlumno;
    }

    //Getter and Setter

    public String getNombreAlumno() {return nombreAlumno;}
    public void setNombreAlumno(String nombreAlumno) {this.nombreAlumno = nombreAlumno;}

    public String getDniAlumno() {return dniAlumno;}
    public void setDniAlumno(String dniAlumno) {this.dniAlumno = dniAlumno;}

    public LocalDate getFechaAlumno() {return fechaAlumno;}
    public void setFechaAlumno(LocalDate fechaAlumno) {this.fechaAlumno = fechaAlumno;}

    public String getPaisNacimientoAlumno() {return paisNacimientoAlumno;}
    public void setPaisNacimientoAlumno(String paisNacimientoAlumno) {this.paisNacimientoAlumno = paisNacimientoAlumno;}

    //toString
    @Override
    public String toString() {
        return "Alumno{" +
                "nombreAlumno='" + nombreAlumno + '\'' +
                ", dniAlumno='" + dniAlumno + '\'' +
                ", fechaAlumno=" + fechaAlumno +
                ", paisNacimientoAlumno='" + paisNacimientoAlumno + '\'' +
                '}';
    }
}
