package DAO;

import Utilidades.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CuentaTitularDAO {
    public int obetenerIdCuentaPorIBAN(String iban){
        String sql = "SELECT id FROM cuentas WHERE iban = ?";

        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1,iban);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                return rs.getInt(1);
            }

            DBConnection.closeConnection();

        }catch (Exception e){
            System.out.println("Error al obtener id cuenta por IBAN: " + e.getMessage());
        }
        return -1;
    }

    public int obtenerTitularPorDNI(String dni){
        String sql = "SELECT id FROM Titulares WHERE dni = ?";

        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, dni);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                return rs.getInt(1);
            }

            DBConnection.closeConnection();
        }catch (Exception e){
            System.out.println("Error al obtener id titular por DNI: " + e.getMessage());
        }
        return -1;
    }

    public void asignarTitularCuenta(int idCuenta, int idTitular) {
        String sql = "INSERT INTO cuenta_titular (id_cuenta, id_titular) VALUES (?, ?)";

        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, idCuenta);
            ps.setInt(2, idTitular);
            ps.executeUpdate();

            System.out.println("Titular asignado a la cuenta correctamente.");
            DBConnection.closeConnection();

        }catch (Exception e){
            System.out.println("Error al asignar titular a cuenta: " + e.getMessage());
        }
    }
}
