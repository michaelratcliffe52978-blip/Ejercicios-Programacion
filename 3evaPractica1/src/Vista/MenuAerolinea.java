package Vista;

import Controladores.PasajeroController;
import Controladores.VueloController;
import Modelo.Pasajero;
import Modelo.Vuelo;
import Utilidades.EntradaDatos;

import java.util.List;
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
        System.out.println("\n------ DATOS DE UN VUELO A TRAVÉS DEL CÓDIGO ------");
        String codVuelo = EntradaDatos.leerTexto(sc,"Introduce el código del vuelo (Ej:AEA1-00001): ", "^[A-Z]{3}[0-9]{1}-[0-9]{5}$");

        Vuelo vueloExistente = VueloController.obtenerVueloPorCod_vuelo(codVuelo);
        if(vueloExistente != null){
            System.out.println("Código del vuelo: " + vueloExistente.getCod_vuelo());
            System.out.println("Fecha de salida: " + vueloExistente.getFecha_salida());
            System.out.println("Destino: " + vueloExistente.getDestino());
            System.out.println("Procedencia: " + vueloExistente.getProcedencia());
        } else {
            System.out.println("No se encontró ningún vuelo con el código proporcionado.");
        }

    }

    public void datosPasajeroXdni(){
        System.out.println("\n------ DATOS DE UN PASAJERO A TRAVÉS DEL DNI ------");
        String dni = EntradaDatos.leerTexto(sc,"Introduce el DNI del pasajero: ", "^[0-9]{8}[A-Za-z]$");

        Pasajero pasajeroExistente = PasajeroController.obtenerPasajeroPorDni(dni);

        if(pasajeroExistente != null){
            System.out.println("DNI del pasajero: " + pasajeroExistente.getDni());
            System.out.println("Nombre del pasajero: " + pasajeroExistente.getNombre());
            System.out.println("Teléfono del pasajero: " + pasajeroExistente.getTelefono());
            System.out.println("Código del vuelo asociado: " + pasajeroExistente.getCod_vuelo());
        } else {
            System.out.println("No se encontró ningún pasajero con el DNI proporcionado.");
        }



    }

    public void vuelosXdestino(){
        System.out.println("\n------ VUELOS A UN DESTINO CONCRETO ------");
        String destino = EntradaDatos.leerTexto(sc,"Introduce el destino: ", "^[A-Za-z ]+$");

        List<Vuelo> vuelosXDestino = VueloController.obtenerVueloPorDestino(destino);
        if(vuelosXDestino != null){
            for(Vuelo vuelo : vuelosXDestino){
                System.out.println("\nCódigo del vuelo: " + vuelo.getCod_vuelo());
                System.out.println("Fecha salida: " + vuelo.getFecha_salida());
                System.out.println("Destino: " + vuelo.getDestino());
                System.out.println("Procedencia: " + vuelo.getProcedencia());
            }
        } else {
            System.out.println("No se encontró ningún vuelo con el destino proporcionado.");
        }
    }

    public void vuelosXorigen(){
        System.out.println("\n------ VUELOS POR ORIGEN ------");
        String origen = EntradaDatos.leerTexto(sc,"Introduce el origen: ", "^[A-Za-z ]+$");

        List<Vuelo> vuelosXorigen = VueloController.obtenerVueloPorOrigen(origen);
        if(vuelosXorigen != null){
            for(Vuelo vuelo : vuelosXorigen){
                System.out.println("\nCódigo del vuelo: " + vuelo.getCod_vuelo());
                System.out.println("Fecha salida: " + vuelo.getFecha_salida());
                System.out.println("Destino: " + vuelo.getDestino());
                System.out.println("Procedencia: " + vuelo.getProcedencia());
            }
        } else {
            System.out.println("No se encontró ningún vuelo con el destino proporcionado.");
        }

    }

    public void vuelosXpasajero(){
        System.out.println("\n------ VUELO QUE HA REALIZADO O VA A REALIZAR UN PASAJERO ------");
        String dni = EntradaDatos.leerTexto(sc,"Introduce el DNI del pasajero: ", "^[0-9]{8}[A-Za-z]$");

        Pasajero pasajeroExistente = PasajeroController.obtenerPasajeroPorDni(dni);
        if(pasajeroExistente != null){
            String codVuelo = pasajeroExistente.getCod_vuelo();
            Vuelo vueloAsociado = VueloController.obtenerVueloPorCod_vuelo(codVuelo);
            if(vueloAsociado != null){
                System.out.println("\nCódigo del vuelo: " + vueloAsociado.getCod_vuelo());
                System.out.println("Fecha salida: " + vueloAsociado.getFecha_salida());
                System.out.println("Destino: " + vueloAsociado.getDestino());
                System.out.println("Procedencia: " + vueloAsociado.getProcedencia());
            } else {
                System.out.println("No se encontró ningún vuelo asociado al pasajero con DNI: " + dni);
            }
        } else {
            System.out.println("No se encontró ningún pasajero con el DNI proporcionado.");
        }
    }

    public void listaDePasajerosDeUnVuelo(){
        System.out.println("\n------ LISTA DE PASAJEROS DE UN VUELO ------");
        String codVuelo = EntradaDatos.leerTexto(sc,"Introduce el código del vuelo (Ej:AEA1-00001): ", "^[A-Z]{3}[0-9]{1}-[0-9]{5}$");

        List<Pasajero> pasajerosDeVuelo = VueloController.obtenerPasajerosPorCod_vuelo(codVuelo);
        if(pasajerosDeVuelo != null && !pasajerosDeVuelo.isEmpty()){
            for(Pasajero pasajero : pasajerosDeVuelo) {
                System.out.println("\nDNI del pasajero: " + pasajero.getDni());
                System.out.println("Nombre del pasajero: " + pasajero.getNombre());
                System.out.println("Teléfono del pasajero: " + pasajero.getTelefono());
                System.out.println("Código del vuelo asociado: " + pasajero.getCod_vuelo());
            }
        } else {
            System.out.println("No se encontraron pasajeros asociados al vuelo con código: " + codVuelo);
        }
    }

    public void listaVuelosParaUnafecha(){
        System.out.println("\n------ LISTA DE VUELOS PARA UNA FECHA CONCRETA ------");
        String fechaStr = EntradaDatos.validarFecha(sc, "Ingrese la fecha de salida (yyyy-MM-dd): ", "^[0-9]{4}-[0-9]{2}-[0-9]{2}$");
        List<Vuelo> vuelosXFecha = VueloController.obtenerVueloPorFecha(fechaStr);
        if(vuelosXFecha != null && !vuelosXFecha.isEmpty()) {
            for (Vuelo vuelo : vuelosXFecha) {
                System.out.println("\nCódigo del vuelo: " + vuelo.getCod_vuelo());
                System.out.println("Fecha salida: " + vuelo.getFecha_salida());
                System.out.println("Destino: " + vuelo.getDestino());
                System.out.println("Procedencia: " + vuelo.getProcedencia());
            }
        }else {
            System.out.println("No se encontraron vuelos para la fecha proporcionada.");
        }
    }

}
