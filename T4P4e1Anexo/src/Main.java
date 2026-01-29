import Modulo.Coche;
import Modulo.Propietario;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String [] args) {
        // COCHES
        Coche c1 = new Coche("1234 ABC", "Toyota", 2018, 18000);
        Coche c2 = new Coche("5678 DEF", "BMW", 2015, 25000);
        Coche c3 = new Coche("9012 GHI", "Seat", 2012, 12000);

        Coche c4 = new Coche("3456 JKL", "Toyota", 2020, 22000);
        Coche c5 = new Coche("7890 MNO", "Audi", 2017, 30000);
        Coche c6 = new Coche("1122 PQR", "BMW", 2010, 15000);

        Coche c7 = new Coche("3344 STU", "Seat", 2019, 16000);
        Coche c8 = new Coche("5566 VWX", "Audi", 2014, 20000);
        Coche c9 = new Coche("7788 YZA", "Toyota", 2021, 24000);

        // PROPIETARIOS
        Propietario p1 = new Propietario(
                "Carlos",
                List.of(c1, c2, c3)
        );

        Propietario p2 = new Propietario(
                "Ana",
                List.of(c4, c5, c6)
        );

        Propietario p3 = new Propietario(
                "Luis",
                List.of(c7, c8, c9)
        );
        List<Coche> coches = List.of(c1, c2, c3, c4, c5, c6, c7, c8);
        List<Propietario> propietarios = List.of(p1, p2, p3);

        //1. Obtener una lista con las matrículas de los coches
        List<String> matriculaCoches = coches.stream()
                .map(Coche::getMatricula)
                .toList();
        System.out.println("Matricula de coches: " + matriculaCoches);

        for (Coche m : coches) {
            System.out.println(m.getMatricula());
        }
        System.out.println("_____________________________________________________");
        //2. Contar cuantos coches tiene el propietario
        propietarios.forEach(p -> System.out.println(p.getNombre() + " tiene " + p.getCoches().stream().count() + " coches"));

        for (Propietario p : propietarios) {
            System.out.println("Propietario: " + p.getNombre() + " tiene " + p.getCoches().size() + " coches");
        }

        System.out.println("_____________________________________________________");

        //3. Obtener coches posteriores a 2015.
        List<Coche> posteriores = coches.stream()
                .filter(n -> n.getAno() > 2015)
                .toList();
        System.out.println("Coches posteriores a 2015: ");
        posteriores.forEach(c -> System.out.println(c.getMatricula() + " - " + c.getMarca() + " - " + c.getAno())
        );

        System.out.println("___");

        for (Coche c : posteriores) {
            if (c.getAno() > 2015) {
                System.out.println("Coches post 2015: " + c.getMatricula() + " - " + c.getMarca() + " - " + c.getAno());
            }
        }

        System.out.println("_____________________________________________________");
        //4. Calcular el precio medio de los coches
        double avg = coches.stream()
                .mapToDouble(Coche::getPrecio)
                .average()
                .orElse(0);
        System.out.println("Precio medio: " + avg);

        double precioTotal = 0;
        for (Coche c : coches) {
            precioTotal += c.getPrecio();
        }
        System.out.println("Precio medio: " + precioTotal / coches.size());

        System.out.println("_____________________________________________________");
        //5. Obtener el coche mas caro.
        Coche cocheMasCaro = List.of(c1, c2, c3, c4, c5, c6, c7, c8, c9).stream()
                .max(Comparator.comparingDouble(Coche::getPrecio))
                .orElse(null);

        System.out.println("Coche más caro:");
        System.out.println(cocheMasCaro.getMatricula() + " - " + cocheMasCaro.getMarca() + " - " + cocheMasCaro.getPrecio());


        Coche masCaro = coches.get(0);
        for (Coche c : coches) {
            if (c.getPrecio() > masCaro.getPrecio()) {
                masCaro = c;
            }
        }

        System.out.println("Coche más caro:");
        System.out.println(masCaro.getMatricula() + " - " + masCaro.getMarca() + " - " + masCaro.getPrecio());

        System.out.println("_____________________________________________________");
        //6. Comprobar si algun coche es de marca ”BMW”
        Boolean buscar = List.of(c1,c2,c3,c4,c5,c6,c7,c8,c9).stream()
                .anyMatch(n-> n.getMarca().equalsIgnoreCase("BMW"))
                ;
        System.out.println("¿ Hay BMW ? "+ buscar);


        for(Coche c : coches) {
            if(c.getMarca().equalsIgnoreCase("BMW")){
                System.out.println("Marca: " + c.getMarca() + " - " + c.getAno());
            }
        }

    }
}