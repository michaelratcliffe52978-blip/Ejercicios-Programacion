import Modelo.Directivo;
import Modelo.Empleado;
import Modelo.Persona;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Empleado emp1 = new Empleado("Brian", 16, 1800);
        Empleado emp2 = new Empleado("Asier", 18, 1900);
        Empleado emp3 = new Empleado("Dani", 20, 2200);
        Empleado emp4 = new Empleado("Irati", 22, 2400);

        List<Empleado> sub1 = Arrays.asList(emp1, emp2);
        List<Empleado> sub2 = Arrays.asList(emp3, emp4, emp1);

        Directivo d1 = new Directivo("María", 40, 3000, "Alta", sub1);
        Directivo d2 = new Directivo("Laura", 38, 3200, "Media", sub2);

        List<Directivo> directivos = Arrays.asList(d1, d2);
        Directivo ganador = directivos.get(0);

        for (Directivo d : directivos) {
            if (d.getSubordinados().size() > ganador.getSubordinados().size()) {
                ganador = d;
            }
        }

        System.out.println("El directivo con más subordinados es: " + ganador.getNombre());
    }
}