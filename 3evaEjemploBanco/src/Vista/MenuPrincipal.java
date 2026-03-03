package Vista;

import Controladores.TitularController;
import Utilidades.EntradaDatos;

import java.util.Scanner;

public class MenuPrincipal {
    private TitularController titularController;
    private Scanner sc;

    public MenuPrincipal() {
        this.titularController = new TitularController();
        this.sc = new Scanner(System.in);
    }

    public void mostrarMenu()
    {
        int opcion;
        do
        {
            System.out.println("====== MENÚ PRINCIPAL  ======");
            System.out.println("1. MENÚ TITULARES");
            System.out.println("2. MENÚ CUENTAS Y TITULARES");
            System.out.println("3. MENÚ TRANSACCIONES");
            System.out.println("0. Salir");

            opcion = EntradaDatos.leerEntero(sc, "Elige opción: ");

            switch (opcion) {
                case 1 -> {
                    MenuTitulares menu = new MenuTitulares();
                    menu.mostrarMenu();
                }
                case 2 -> {
                    MenuCuentasTitulares menuCuentasTitulares = new MenuCuentasTitulares();
                    menuCuentasTitulares.mostrarMenu();

                }
                case 3 -> {
                    MenuCuentas menuTransacciones = new MenuCuentas();
                    menuTransacciones.mostrarMenu();
                }
                case 0 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }

}


