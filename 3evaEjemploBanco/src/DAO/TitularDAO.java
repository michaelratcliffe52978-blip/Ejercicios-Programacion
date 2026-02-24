package DAO;

import Modelo.Titular;
import Utilidades.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class TitularDAO {
    //EN ESTA CLASE SE HACEN LOS INSERTS, SELECTS, DELETES, UPDATES...

    //INSERTS
    public void insertar(Titular titular){
        String sql = "INSERT INTO titular (dni, nombre) VALUES (?, ?)";
        try{
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, titular.getDni());
            ps.setString(2, titular.getNombre());
            ps.executeUpdate();

            System.out.println("Titular insertado correctamente.");
            DBConnection.closeConnection();

        }catch(Exception e)

        {
            System.out.println("Error en insertar: " + e.getMessage());
        }
    }

    //SELECTS -> listar todos
    public ArrayList<Titular> listarTitulares(){

        ArrayList<Titular> listar = new ArrayList<>();
        String sql = "SELECT * FROM titular";

        try (Connection conn = DBConnection.getConnection();){
            Statement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);

            while(rs.next()){
                Titular t = new Titular(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("dni")
                );
                listar.add(t);
            }

            DBConnection.closeConnection();
        }catch(Exception e){
            System.out.println("Error en listar: " + e.getMessage());
        }
        return listar;
    }

    //DELETE
    public void eliminar(int id){
        String sql = "DELETE FROM titular WHERE id = ?";

        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);
            ps.executeUpdate();

            ps.close();
            conn.close();

            System.out.println("Eliminado correctamente");

        }catch(Exception e){
            System.out.println("Error en eliminar: " + e.getMessage());
        }
    }

    //UPDATE
    public void actualizar(Titular titular){
        String sql = "UPDATE titular SET nombre = ?, dni = ? WHERE id = ?";

        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, titular.getNombre());
            ps.setString(2, titular.getDni());
            ps.setInt(3, titular.getId());

            ps.executeUpdate();

            ps.close();
            conn.close();

            System.out.println("Actualizado correctamente");

        }catch(Exception e){
            System.out.println("Error en actualizar: " + e.getMessage());
        }
    }
}
