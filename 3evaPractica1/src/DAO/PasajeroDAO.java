package DAO;

import Modelo.Pasajero;
import Utilidades.AerolineaConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PasajeroDAO {

    public static void insertar(Pasajero pasajero){
        String sql = "INSERT INTO pasajeros (dni, nombre, telefono, cod_vuelo) VALUES (?, ?, ?, ?)";
        try{
            Connection conn = AerolineaConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1,pasajero.getDni());
            ps.setString(2,pasajero.getNombre());
            ps.setString(3,pasajero.getTelefono());
            ps.setString(4,pasajero.getCod_vuelo());
            ps.executeUpdate();

            System.out.println("(DAO) Pasajero insertado correctamente a la BD.");
            AerolineaConnection.closeConnection();

        }catch(Exception e)
        {
            System.out.println("Error en insertar: " + e.getMessage());
        }
    }

    // Buscar pasajero por DNI
    public static Pasajero buscarPorDni(String dni) {
        String sql = "SELECT * FROM pasajeros WHERE dni = ?";
        try {
            Connection conn = AerolineaConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, dni);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Pasajero pasajero = new Pasajero(
                    rs.getString("dni"),
                    rs.getString("nombre"),
                    rs.getString("telefono"),
                    rs.getString("cod_vuelo")
                );
                AerolineaConnection.closeConnection();
                return pasajero;
            }
            AerolineaConnection.closeConnection();

        } catch (Exception e) {
            System.out.println("Error al buscar pasajero: " + e.getMessage());
        }
        return null;
    }

    // Eliminar pasajero por DNI
    public static boolean eliminar(String dni) {
        String sql = "DELETE FROM pasajeros WHERE dni = ?";
        try {
            Connection conn = AerolineaConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, dni);
            int resultado = ps.executeUpdate();

            AerolineaConnection.closeConnection();
            return resultado > 0;

        } catch (Exception e) {
            System.out.println("Error al eliminar pasajero: " + e.getMessage());
        }
        return false;
    }


    public static void modificar(Pasajero pasajero) {
        String sql = "UPDATE pasajeros SET nombre = ?, telefono = ?, cod_vuelo = ? WHERE dni = ?";
        try {
            Connection conn = AerolineaConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, pasajero.getNombre());
            ps.setString(2, pasajero.getTelefono());
            ps.setString(3, pasajero.getCod_vuelo());
            ps.setString(4, pasajero.getDni());

            int resultado = ps.executeUpdate();
            AerolineaConnection.closeConnection();

            if (resultado > 0) {
                System.out.println("Pasajero modificado correctamente.");
            } else {
                System.out.println("No se encontró el pasajero para modificar.");
            }
        } catch (Exception e) {
            System.out.println("Error al modificar pasajero: " + e.getMessage());
        }
    }











}
