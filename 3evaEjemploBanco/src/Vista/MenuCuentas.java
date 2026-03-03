package Vista;

import Utilidades.EntradaDatos;

import java.util.Scanner;

public class MenuCuentas {

    private final static Scanner sc = new Scanner(System.in);

        public void mostrarMenu() {
            int opcion;
            do {
                System.out.println("\n====== MENÚ CUENTAS ======");

                opcion = EntradaDatos.leerEntero(sc, "Elige opción: ");

                switch (opcion) {
                    case 0 -> System.out.println("Saliendo del programa...");
                    default -> System.out.println("Opción inválida.");
                }

            } while (opcion != 0);

        }

}

