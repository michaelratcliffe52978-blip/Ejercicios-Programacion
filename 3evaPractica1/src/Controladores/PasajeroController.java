package Controladores;

import DAO.PasajeroDAO;
import Modelo.Pasajero;

public class PasajeroController {

    private static PasajeroDAO pasajeroDAO = new PasajeroDAO();

    public static void crearPasajero(String dni, String nombre, String telefono, String cod_vuelo) {
        Pasajero pasajero = new Pasajero(dni, nombre, telefono, cod_vuelo);
        PasajeroDAO.insertar(pasajero);
    }

    // Buscar pasajero por DNI
    public static Pasajero obtenerPasajeroPorDni(String dni) {
        return PasajeroDAO.buscarPorDni(dni);
    }

    // Eliminar pasajero por DNI
    public static boolean eliminarPasajero(String dni) {
        return PasajeroDAO.eliminar(dni);
    }

    //Modificar pasajero por DNI
    public static void modificarPasajero(String dni, String nuevoNombre, String nuevoTelefono, String nuevoCodVuelo) {
        Pasajero pasajeroExistente = obtenerPasajeroPorDni(dni);
        if (pasajeroExistente != null) {
            pasajeroExistente.setNombre(nuevoNombre);
            pasajeroExistente.setTelefono(nuevoTelefono);
            pasajeroExistente.setCod_vuelo(nuevoCodVuelo);
            PasajeroDAO.modificar(pasajeroExistente);
        } else {
            System.out.println("No se encontró el pasajero con DNI: " + dni);
        }
    }

}
