package DAO;

import Modelo.Pasajero;
import Modelo.Vuelo;
import Utilidades.AerolineaConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class VueloDAO {

    public static void insertar(Vuelo vuelo) {
        String sql = "INSERT INTO vuelos (cod_vuelo, fecha_salida, destino, procedencia) VALUES (?, ?, ?, ?)";
        try {
            Connection conn = AerolineaConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, vuelo.getCod_vuelo());
            ps.setDate(2, Date.valueOf(vuelo.getFecha_salida()));
            ps.setString(3, vuelo.getDestino());
            ps.setString(4, vuelo.getProcedencia());
            ps.executeUpdate();

            System.out.println("(DAO) Vuelo insertado correctamente a la BD.");
            AerolineaConnection.closeConnection();

        } catch (Exception e) {
            System.out.println("Error en insertar: " + e.getMessage());
        }
    }

    // Buscar vuelo por cod_vuelo
    public static Vuelo buscarPorCod_vuelo(String cod_vuelo) {
        String sql = "SELECT * FROM vuelos WHERE cod_vuelo = ?";
        try {
            Connection conn = AerolineaConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, cod_vuelo);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Vuelo vuelo = new Vuelo(
                        rs.getString("cod_vuelo"),
                        rs.getDate("fecha_salida").toLocalDate(),
                        rs.getString("destino"),
                        rs.getString("procedencia")
                );
                AerolineaConnection.closeConnection();
                return vuelo;
            }
            AerolineaConnection.closeConnection();


        } catch (Exception e) {
            System.out.println("Error al buscar vuelo: " + e.getMessage());

        }
        return null;
    }

    // Eliminar vuelo por el cod_vuelo
    public static boolean eliminar(String cod_vuelo) {
        String sql = "DELETE FROM vuelos WHERE cod_vuelo = ?";
        try {
            Connection conn = AerolineaConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, cod_vuelo);
            int resultado = ps.executeUpdate();

            System.out.println("(DAO) Vuelo eliminado correctamente de la BD.");

            AerolineaConnection.closeConnection();
            return resultado > 0;

        } catch (Exception e) {
            System.out.println("Error al eliminar vuelo: " + e.getMessage());
        }
        return false;
    }


    public static void modificar(Vuelo vuelo) {
        String sql = "UPDATE vuelos SET fecha_salida = ?, destino = ?, procedencia = ? WHERE cod_vuelo = ?";
        try {
            Connection conn = AerolineaConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, vuelo.getFecha_salida().toString());
            ps.setString(2, vuelo.getDestino());
            ps.setString(3, vuelo.getProcedencia());
            ps.setString(4, vuelo.getCod_vuelo());

            int resultado = ps.executeUpdate();
            AerolineaConnection.closeConnection();

            if (resultado > 0) {
                System.out.println("(DAO) Vuelo modificado correctamente.");
            } else {
                System.out.println("(DAO) No se encontró el vuelo para modificar.");
            }
        } catch (Exception e) {
            System.out.println("Error al modificar pasajero: " + e.getMessage());
        }
    }

    // Buscar vuelo por destino
    public static List<Vuelo> buscarPorDestino(String destino) {
        List<Vuelo> vuelos = new ArrayList<>();
        String sql = "SELECT * FROM vuelos WHERE destino = ?";
        try {
            Connection conn = AerolineaConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, destino);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Vuelo vuelo = new Vuelo(
                        rs.getString("cod_vuelo"),
                        rs.getDate("fecha_salida").toLocalDate(),
                        rs.getString("destino"),
                        rs.getString("procedencia")
                );

                vuelos.add(vuelo);
            }
            AerolineaConnection.closeConnection();


        } catch (Exception e) {
            System.out.println("Error al buscar vuelo: " + e.getMessage());

        }
        return vuelos;
    }


    public static List<Vuelo> buscarPorOrigen(String procedencia) {
        List<Vuelo> vuelos = new ArrayList<>();
        String sql = "SELECT * FROM vuelos WHERE procedencia = ?";
        try {
            Connection conn = AerolineaConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, procedencia);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Vuelo vuelo = new Vuelo(
                        rs.getString("cod_vuelo"),
                        rs.getDate("fecha_salida").toLocalDate(),
                        rs.getString("destino"),
                        rs.getString("procedencia")
                );

                vuelos.add(vuelo);
            }
            AerolineaConnection.closeConnection();


        } catch (Exception e) {
            System.out.println("Error al buscar vuelo: " + e.getMessage());

        }
        return vuelos;
    }

    public static List<Pasajero> buscarPasajerosPorCod_vuelo(String cod_vuelo) {
        List<Pasajero> pasajeros = new ArrayList<>();
        String sql = "SELECT * FROM pasajeros WHERE cod_vuelo = ?";
        try {
            Connection conn = AerolineaConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, cod_vuelo);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Pasajero pasajero = new Pasajero(
                        rs.getString("dni"),
                        rs.getString("nombre"),
                        rs.getString("telefono"),
                        rs.getString("cod_vuelo")
                );

                pasajeros.add(pasajero);
            }
            AerolineaConnection.closeConnection();

        } catch (Exception e) {
            System.out.println("Error al buscar pasajeros por cod_vuelo: " + e.getMessage());
        }
        return pasajeros;
    }

    public static List<Vuelo> buscarPorFecha(String fecha_salida) {
        List<Vuelo> vuelos = new ArrayList<>();
        String sql = "SELECT * FROM vuelos WHERE fecha_salida = ?";
        try {
            Connection conn = AerolineaConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, fecha_salida);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Vuelo vuelo = new Vuelo(
                        rs.getString("cod_vuelo"),
                        rs.getDate("fecha_salida").toLocalDate(),
                        rs.getString("destino"),
                        rs.getString("procedencia")
                );

                vuelos.add(vuelo);
            }
            AerolineaConnection.closeConnection();
        } catch (Exception e) {
            System.out.println("Error al buscar vuelos por fecha: " + e.getMessage());
        }
        return vuelos;

    }

}