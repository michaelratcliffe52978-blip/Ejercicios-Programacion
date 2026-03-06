package Vista;

import Modelo.Pasajero;
import Utilidades.EntradaDatos;

import java.util.Scanner;

public class MenuAerolinea {
    private Scanner sc;

    public MenuAerolinea() {
        sc = new Scanner(System.in);
    }

    public void mostrarMenu(){
        int opcion;
        do {
            System.out.println("\n------ MENÚ AEROLÍNEA ------");
            System.out.println("1. Datos de un vuelo a través del código");
            System.out.println("2. Datos de un pasajero a través del dni");
            System.out.println("3. Vuelos a un destino concreto");
            System.out.println("4. Vuelos por origen");
            System.out.println("5. Vuelo que ha realizado o va a realizar un pasajero");
            System.out.println("6. Lista de pasajeros de un vuelo");
            System.out.println("7. Lista de vuelos para una fecha concreta");
            System.out.println("0. Salir");

            opcion = EntradaDatos.leerEntero(sc, "Opcion: ");
            switch (opcion){
                case 1 -> datosVueloXCod();
                case 2 -> datosPasajeroXdni();
                case 3 -> vuelosXdestino();
                case 4 -> vuelosXorigen();
                case 5 -> vuelosXpasajero();
                case 6 -> listaDePasajerosDeUnVuelo();
                case 7 -> listaVuelosParaUnafecha();
                case 0 -> System.out.println("Saliendo al menú principal...");
                default -> System.out.println("Opción inválida.");
            }
        }while (opcion!=0);
    }

    public void datosVueloXCod(){

    }
    public void datosPasajeroXdni(){

    }
    public void vuelosXdestino(){

    }
    public void vuelosXorigen(){

    }
    public void vuelosXpasajero(){

    }
    public void listaDePasajerosDeUnVuelo(){

    }
    public void listaVuelosParaUnafecha(){

    }

}
