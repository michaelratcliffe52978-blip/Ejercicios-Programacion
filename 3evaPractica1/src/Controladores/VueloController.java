package Controladores;

import DAO.PasajeroDAO;
import DAO.VueloDAO;
import Modelo.Pasajero;
import Modelo.Vuelo;

import java.time.LocalDate;
import java.util.List;

public class VueloController {

    private static VueloDAO pasajeroDAO = new VueloDAO();

    public static void crearVuelo(String cod_vuelo, LocalDate fecha_salida, String destino, String procedencia) {
        Vuelo vuelo = new Vuelo(cod_vuelo, fecha_salida, destino, procedencia);
        VueloDAO.insertar(vuelo);
    }

    // Buscar pasajero por DNI
    public static Vuelo obtenerVueloPorCod_vuelo(String cod_vuelo) {
        return VueloDAO.buscarPorCod_vuelo(cod_vuelo);
    }

    // Eliminar pasajero por DNI
    public static boolean eliminarVuelo(String cod_vuelo) {
        return VueloDAO.eliminar(cod_vuelo);
    }

    public static void modificarVuelo(String cod_vuelo, LocalDate nuevaFecha, String nuevoDestino, String nuevaProcedencia) {
        Vuelo vueloExistente = obtenerVueloPorCod_vuelo(cod_vuelo);
        if (vueloExistente != null) {
            vueloExistente.setFecha_salida(nuevaFecha);
            vueloExistente.setDestino(nuevoDestino);
            vueloExistente.setProcedencia(nuevaProcedencia);

            VueloDAO.modificar(vueloExistente);
        } else {
            System.out.println("No se encontró el pasajero con DNI: " + cod_vuelo);
        }
    }

    public static List<Vuelo> obtenerVueloPorDestino(String destino) {
        return VueloDAO.buscarPorDestino(destino);
    }

    public static List<Vuelo> obtenerVueloPorOrigen(String origen) {
        return VueloDAO.buscarPorOrigen(origen);
    }

    public static List<Pasajero> obtenerPasajerosPorCod_vuelo(String cod_vuelo) {
        return VueloDAO.buscarPasajerosPorCod_vuelo(cod_vuelo);
    }

    public static List<Vuelo> obtenerVueloPorFecha(String fecha_salida) {
        return VueloDAO.buscarPorFecha(fecha_salida);
    }
}
