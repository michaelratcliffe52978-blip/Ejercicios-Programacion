//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Datos d1 = new Datos(5);

        d1.CalculoDeLongitud();
        System.out.println(d1.getLongitud());
        d1.CalculoDeArea();
        System.out.println(d1.getArea());
        d1.CalculoDeVolumen();
        System.out.println(d1.getVolumen());
    }
}