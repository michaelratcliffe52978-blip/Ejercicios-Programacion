package Vista;

import Utilidades.EntradaDatos;

import java.util.Scanner;

public class MenuPrincipal {
    private Scanner sc;

    public MenuPrincipal() {
        this.sc = new Scanner(System.in);
    }

    public void mostrarMenu()
    {
        int opcion;
        do
        {
            System.out.println("====== MENÚ PRINCIPAL  ======");
            System.out.println("1. MENÚ GESTIÓN DE VUELOS");
            System.out.println("2. MENÚ GESTIÓN DE PASAJEROS");
            System.out.println("3. MENÚ CONSULTAS AEROLÍNEA");
            System.out.println("0. Salir");

            opcion = EntradaDatos.leerEntero(sc, "Elige opción: ");

            switch (opcion) {
                case 1 -> {
                    MenuGestionarVuelos menu = new MenuGestionarVuelos();
                    menu.mostrarMenu();

                }
                case 2 -> {
                    MenuGestionarPasajeros menu = new MenuGestionarPasajeros();
                    menu.mostrarMenu();
                }
                case 3 -> {
                    MenuAerolinea menu = new MenuAerolinea();
                    menu.mostrarMenu();
                }
                case 0 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }


}
