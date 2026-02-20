import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private final static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Persona> personas = new ArrayList<>();

        Persona p1 = new Persona("Mike", 6, 6, 2007, "C/ Ernestina de Champourcin", "01010", "Vitoria-Gasteiz");
        Persona p2 = new Persona("Markel", 30, 4, 2010, "C/ Ernestina de Lolilin", "02020", "Vitoria-Gasteiz");
        Persona p3 = new Persona("Yyaron", 12, 1, 2006, "C/ Ernestina de Caricin", "03030", "Las Palmas de Gran Canaria");
        Persona p4 = new Persona("Lucia", 17, 9, 2002, "C/ Ernestina de Popiron", "04040", "Elche");
        Persona p5 = new Persona("Pedro", 22, 11, 2014, "C/ Ernestina de Wereren", "05050", "Elche");

        //Las añado a la lista:
        personas.add(p1);
        personas.add(p2);
        personas.add(p3);
        personas.add(p4);
        personas.add(p5);


        //1.
        int edadMax = 0;
        String nombreMayor = "";

        for (Persona p : personas) {
            int edad = p.calcularEdad();
            if (edad > edadMax) {
                edadMax = edad;
                nombreMayor = p.getNombre();
            }
        }
        System.out.println("\nPersona de mayor edad: " + nombreMayor + " (" + edadMax + " años)");

        //2.
        System.out.println("\nPersonas que viven en Elche:");
        for (Persona p : personas) {
            if (p.getCiudad().equalsIgnoreCase("Elche")) {
                System.out.println(p.getNombre());
            }
        }

        //3.
        int contadorMayores = 0;
        for (Persona p: personas) {
            if(p.isMayorEdad()){
                contadorMayores++;
            }
        }
        System.out.println("\nNúmero de personas mayores de edad: " + contadorMayores);

    }
}