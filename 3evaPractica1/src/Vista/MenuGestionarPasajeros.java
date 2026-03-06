package Vista;

import Controladores.PasajeroController;
import Modelo.Pasajero;
import Utilidades.EntradaDatos;

import java.util.Scanner;

public class MenuGestionarPasajeros {
    private Scanner sc;
    private Pasajero pasajero;

    public MenuGestionarPasajeros() {
        sc = new Scanner(System.in);
    }

    public void mostrarMenu(){
        int opcion;
        do {
            System.out.println("\n------ MENÚ GESIÓN DE PASAJEROS ------");
            System.out.println("1. Dar de alta un pasajero");
            System.out.println("2. Dar de baja un pasajero");
            System.out.println("3. Modificar un pasajero");
            System.out.println("0. Salir");

            opcion = EntradaDatos.leerEntero(sc, "Opcion: ");
            switch (opcion){
                case 1 -> darAltaPasajero();
                case 2 -> darBajaPasajero();
                case 3 -> modificarPasajero();
                case 0 -> System.out.println("Saliendo al menú principal...");
                default -> System.out.println("Opción inválida.");
            }
        }while (opcion!=0);
    }

    public void darAltaPasajero(){
        System.out.println("\n------ DAR DE ALTA UN PASAJERO ------");
        String dni = EntradaDatos.leerTexto(sc,"Ingrese el DNI del pasajero: ", "^[0-9]{8}[A-Za-z]$");
        if(dni!= null) {
            String nombre = EntradaDatos.leerTexto(sc,"Ingrese el nombre: ", "^[A-Za-z ]+$");
            String telefono = EntradaDatos.leerTexto(sc,"Ingrese el teléfono (Ej:674103123): ", "^[0-9]{9}$");
            String cod_vuelo= EntradaDatos.leerTexto(sc,"Ingrese el código del vuelo (Ej:AEA1-00001): ", "^[A-Z]{3}[0-9]{1}-[0-9]{5}$");

            PasajeroController.crearPasajero(dni, nombre, telefono, cod_vuelo);
            System.out.println("Pasajero creado correctamente.");
        }

    }

    public void darBajaPasajero(){
        System.out.println("\n------ DAR DE BAJA UN PASAJERO ------");
        System.out.println("Para saber si estabas previamente registrado en este vuelo...");
        String dni = EntradaDatos.leerTexto(sc,"Ingrese el DNI del pasajero: ", "^[0-9]{8}[A-Za-z]$");

        if (dni != null) {
            //buscamos si el pasajero existe
            Pasajero pasajeroExistente = PasajeroController.obtenerPasajeroPorDni(dni);

            if (pasajeroExistente != null) {
                System.out.println("\nPasajero '"+pasajeroExistente.getNombre()+"' con dni ("+pasajeroExistente.getDni()+") encontrado correctamente");

                PasajeroController.eliminarPasajero(dni);
                System.out.println("Pasajero eliminado con éxito.");

            } else {
                //si el pasajero no existe
                System.out.println("No se encontró ningún pasajero con el DNI: " + dni);
                System.out.println("Por favor, verifica que el DNI sea correcto.");
            }
        }
    }

    public void modificarPasajero(){
        System.out.println("\n------ MODIFICAR A UN PASAJERO ------");
            String dni = EntradaDatos.leerTexto(sc,"Ingrese el DNI del pasajero a modificar: ", "^[0-9]{8}[A-Za-z]$");

        if (dni != null) {
            //buscamos si el pasajero existe
            Pasajero pasajeroExistente = PasajeroController.obtenerPasajeroPorDni(dni);

            if (pasajeroExistente != null) {
                System.out.println("\nPasajero '"+pasajeroExistente.getNombre()+"' con dni ("+pasajeroExistente.getDni()+") encontrado correctamente");

                System.out.println("¿Quieres modificar el nombre? (si/no)");
                String respuesta = sc.nextLine().trim().toLowerCase();
                if (respuesta.equals("si")) {
                    String nuevoNombre = EntradaDatos.leerTexto(sc,"Ingrese el nuevo nombre: ", "^[A-Za-z ]+$");
                    pasajeroExistente.setNombre(nuevoNombre);
                }else {
                    System.out.println("No se modificará el nombre.");
                }

                System.out.println("¿Quieres modificar el nº de teléfono? (si/no)");
                String respuesta2 = sc.nextLine().trim().toLowerCase();
                if (respuesta2.equals("si")) {
                    String nuevoTelefono = EntradaDatos.leerTexto(sc,"Ingrese el nuevo teléfono (Ej:674103123): ", "^[0-9]{9}$");
                    pasajeroExistente.setTelefono(nuevoTelefono);
                }else {
                    System.out.println("No se modificará el teléfono.");
                }

                System.out.println("¿Quieres modificar el código del vuelo? (si/no)");
                String respuesta3 = sc.nextLine().trim().toLowerCase();
                if (respuesta3.equals("si")) {
                    String nuevoCodVuelo = EntradaDatos.leerTexto(sc,"Ingrese el nuevo código del vuelo (Ej:AEA1-00001): ", "^[A-Z]{3}[0-9]{1}-[0-9]{5}$");
                    pasajeroExistente.setCod_vuelo(nuevoCodVuelo);
                }else {
                    System.out.println("No se modificará el código del vuelo.");
                }

                PasajeroController.modificarPasajero(dni, pasajeroExistente.getNombre(), pasajeroExistente.getTelefono(), pasajeroExistente.getCod_vuelo());
                System.out.println("\nEl pasajero '"+pasajeroExistente.getNombre()+"' ha sido modificado correctamente");

            } else {
                //si el pasajero no existe
                System.out.println("No se encontró ningún pasajero con el DNI: " + dni);
                System.out.println("Por favor, verifica que el DNI sea correcto.");
            }
        }
    }

}