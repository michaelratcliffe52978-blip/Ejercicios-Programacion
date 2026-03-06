package Vista;

import Modelo.Pasajero;
import Utilidades.EntradaDatos;

import java.util.Scanner;

public class MenuGestionarVuelos {
    private Scanner sc;
    private Pasajero pasajero;

    public MenuGestionarVuelos() {
        sc = new Scanner(System.in);
    }

    public void mostrarMenu(){
        int opcion;
        do {
            System.out.println("\n------ MENÚ GESIÓN DE VUELOS ------");
            System.out.println("1. Dar de alta un vuelo");
            System.out.println("2. Dar de baja un vuelo");
            System.out.println("3. Modificar un vuelo");
            System.out.println("0. Salir");

            opcion = EntradaDatos.leerEntero(sc, "Opcion: ");
            switch (opcion){
                case 1 -> darAltaVuelo();
                case 2 -> darBajaVuelo();
                case 3 -> modificarVuelo();
                case 0 -> System.out.println("Saliendo al menú principal...");
                default -> System.out.println("Opción inválida.");
            }
        }while (opcion!=0);
    }

    public void darAltaVuelo(){
        System.out.println("\n------ DAR DE ALTA UN VUELO ------");


    }
    public void darBajaVuelo(){

    }
    public void modificarVuelo(){

    }

}