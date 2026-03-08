package Vista;

import Controladores.PasajeroController;
import Controladores.VueloController;
import Modelo.Pasajero;
import Modelo.Vuelo;
import Utilidades.EntradaDatos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
        String cod_vuelo = EntradaDatos.leerTexto(sc,"Ingrese el código del vuelo (Ej:AEA1-00001): ", "^[A-Z]{3}[0-9]{1}-[0-9]{5}$");
        if(cod_vuelo!=null){
            String fechaStr = EntradaDatos.validarFecha(sc, "Ingrese la fecha de salida (yyyy-MM-dd): ", "^[0-9]{4}-[0-9]{2}-[0-9]{2}$");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate fecha = LocalDate.parse(fechaStr, formatter);

            String destino = EntradaDatos.leerTexto(sc,"Ingrese el destino del vuelo: ", "^[A-Za-z ]+$");
            String procedencia = EntradaDatos.leerTexto(sc,"Ingrese la procedencia del vuelo: ", "^[A-Za-z ]+$");

            VueloController.crearVuelo(cod_vuelo, fecha, destino, procedencia);
            System.out.println("Vuelo creado correctamente.");

        }

    }

    public void darBajaVuelo(){
        System.out.println("\n------ DAR DE BAJA UN VUELO ------");
        String cod_vuelo = EntradaDatos.leerTexto(sc,"Ingrese el código del vuelo que quieres eliminar (Ej:AEA1-00001): ", "^[A-Z]{3}[0-9]{1}-[0-9]{5}$");

        if(cod_vuelo!=null){
            Vuelo vueloExistente = VueloController.obtenerVueloPorCod_vuelo(cod_vuelo);

            if(vueloExistente!=null){
                VueloController.eliminarVuelo(cod_vuelo);
                System.out.println("Vuelo eliminado con éxito.");
            }
            else {
                System.out.println("No se encontró ningún vuelo con el código" + cod_vuelo);
                System.out.println("Por favor, verifica que el código del vuelo sea correcto.");
            }
        }

    }

    public void modificarVuelo(){
        System.out.println("\n------ MODIFICAR UN VUELO ------");
        String cod_vuelo = EntradaDatos.leerTexto(sc,"Ingrese el código del vuelo que quieres modificar (Ej:AEA1-00001): ", "^[A-Z]{3}[0-9]{1}-[0-9]{5}$");

        if(cod_vuelo!=null){
            Vuelo vueloExistente = VueloController.obtenerVueloPorCod_vuelo(cod_vuelo);

            if(vueloExistente!=null){
                System.out.println("\nVuelo '"+vueloExistente.getCod_vuelo()+"' con origen "+vueloExistente.getProcedencia()+" y destino "+vueloExistente.getDestino()+" encontrado correctamente");


                System.out.println("¿Quieres modificar la fecha de salida? (si/no)");
                String respuesta = sc.nextLine().trim().toLowerCase();
                if(respuesta.equals("si")){
                    String nuevaFechaStr = EntradaDatos.validarFecha(sc, "Ingrese la nueva fecha de salida (yyyy-MM-dd): ", "^[0-9]{4}-[0-9]{2}-[0-9]{2}$");
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    LocalDate nuevaFecha = LocalDate.parse(nuevaFechaStr, formatter);
                    vueloExistente.setFecha_salida(nuevaFecha);
                }else {
                    System.out.println("No se modificará la fecha de salida.");
                }

                System.out.println("¿Quieres modificar el destino? (si/no)");
                String respuesta2 = sc.nextLine().trim().toLowerCase();
                if(respuesta2.equals("si")){
                    String nuevoDestino = EntradaDatos.leerTexto(sc,"Ingrese el nuevo destino del vuelo: ", "^[A-Za-z ]+$");
                    vueloExistente.setDestino(nuevoDestino);
                }else {
                    System.out.println("No se modificará el destino.");
                }

                System.out.println("¿Quieres modificar el origen? (si/no)");
                String respuesta3 = sc.nextLine().trim().toLowerCase();
                if(respuesta3.equals("si")){
                    String nuevaProcedencia = EntradaDatos.leerTexto(sc,"Ingrese la nueva procedencia del vuelo: ", "^[A-Za-z ]+$");
                    vueloExistente.setProcedencia(nuevaProcedencia);
                }else {
                    System.out.println("No se modificará la procedencia.");
                }

                VueloController.modificarVuelo(cod_vuelo, vueloExistente.getFecha_salida(), vueloExistente.getDestino(), vueloExistente.getProcedencia());
                System.out.println("\nEl vuelo '"+cod_vuelo+"' ha sido modificado correctamente.");

            }
            else {
                System.out.println("No se encontró ningún vuelo con el código" + cod_vuelo);
                System.out.println("Por favor, verifica que el código del vuelo sea correcto.");

            }

        }


    }

}