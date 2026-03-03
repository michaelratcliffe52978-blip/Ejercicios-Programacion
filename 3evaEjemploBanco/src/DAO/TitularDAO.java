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

            System.out.println("(DAO) Titular insertado correctamente.");
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

    //SELECTS -> X ID

    public Titular buscarPorId(int id) {
        String sql = "SELECT * FROM titulares WHERE id = ?";

        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Titular(
                        rs.getInt("id"),
                        rs.getString("dni"),
                        rs.getString("nombre")
                );
            }
            DBConnection.closeConnection();

        }
        catch (Exception e)
        {
            System.out.println(" (DAO) Error al buscar titular: " + e.getMessage());
        }

        return null;
    }


    //SELECTS -> X DNI

    public Titular buscarPorDni(String dni) {
        String sql = "SELECT * FROM titulares WHERE dni = ?";

        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, dni);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Titular(
                        rs.getInt("id"),
                        rs.getString("dni"),
                        rs.getString("nombre")
                );
            }
            DBConnection.closeConnection();

        }
        catch (Exception e)
        {
            System.out.println(" (DAO) Error al buscar titular por dni: " + e.getMessage());
        }

        return null;
    }
    //SELECTS -> X NOMBRE

    public ArrayList<Titular> buscarPorNombre(String nombre) {
        String sql = "SELECT * FROM titulares WHERE nombre = ?";

        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();

            ArrayList<Titular> lista = new ArrayList<>();

            while (rs.next()) {
                lista.add(new Titular(
                        rs.getInt("id"),
                        rs.getString("dni"),
                        rs.getString("nombre")
                ));
            }

            DBConnection.closeConnection();
            return lista;

        }
        catch (Exception e)
        {
            System.out.println("(DAO) Error al buscar titulares por nombre: " + e.getMessage());
        }

        return null;
    }



    //DELETE
    public int eliminar(int id) throws Exception{
        String sql = "DELETE FROM titulares WHERE ID = ?";

        int n=0;
        try
        {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);
            n = ps.executeUpdate();

            if (n != 1) {
                System.out.println(" (DAO) Titular no borrado.");
                // Mensaje para el usuario
                throw new Exception(" No se encontró ningún titular con el ID proporcionado.");
            }
            else
            {
                System.out.println(" (DAO) Titular borrado correctamente.");
            }

        }
        catch (Exception e)
        {
            System.out.println(" (DAO) Error al borrar titular: " + e.getMessage());
        }
        finally
        {
            DBConnection.closeConnection();
            return n;
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
