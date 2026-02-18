import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int radio;
        boolean continuar = true;
        do {
            try {
                System.out.println("TECLEA EL RADIO");
                radio = sc.nextInt();

                if(radio < 0){
                    throw new ExceptionRadio();
                }
                 continuar = false;
            }catch(ExceptionRadio e) {
                System.out.println("ERROR: introduce el radio nuevamente.");
            }
        }while(continuar);
        Circunferencia c1 = new Circunferencia(radio)

        Circunferencia d1 = new Circunferencia(5);
        d1.CalculoDeLongitud();
        System.out.println(d1.getLongitud());
        d1.CalculoDeArea();
        System.out.println(d1.getArea());
        d1.CalculoDeVolumen();
        System.out.println(d1.getVolumen());
    }
}