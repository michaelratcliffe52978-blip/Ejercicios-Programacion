public class Circunferencia {
    //Atributos
    private int radio;
    private double longitud;
    private double area;
    private double volumen;


    //Constructor
    public Circunferencia(int radio) {
        this.radio = radio;
    }
    //Getter and Setter
    public int getRadio() {
        return radio;
    }

    public void setRadio(int radio) {
        this.radio = radio;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getVolumen() {
        return volumen;
    }

    public void setVolumen(double volumen) {
        this.volumen = volumen;
    }

    //toString

    @Override
    public String toString() {
        return "Datos{" +
                "radio=" + radio +
                ", longitud=" + longitud +
                ", area=" + area +
                ", volumen=" + volumen +
                '}';
    }

    //Funciones
   public void CalculoDeLongitud(){
        longitud= 2 *Math.PI*radio;
   }

   public void CalculoDeArea(){
        area=Math.PI*radio*radio;
   }
   public void CalculoDeVolumen(){
        volumen=4*Math.PI*radio*radio*radio/3;
   }
}
