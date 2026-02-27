package Controladores;

import DAO.TitularDAO;
import Modelo.Titular;

import java.util.List;

public class TitularController {

    private TitularDAO titularDAO;

    public TitularController() {
        titularDAO = new TitularDAO();
    }

    public void crearTitular(String dni, String nombre) {
        Titular titular = new Titular(dni, nombre);
        titularDAO.insertar(titular);

    }

    public int borrarTitular(int id) throws Exception{
        // Implementar metodo para borrar titular por ID
        return titularDAO.eliminar(id);
    }

    public List<Titular> listarTitular() {
        return titularDAO.listarTitulares();
    }

    //BUSCAR X DNI, X ID Y X NOMBRE
    public Titular buscarPorDni(String dni)
    {return titularDAO.buscarPorDni(dni);
    }

    public Titular buscarPorId(int id)
    {
        return titularDAO.buscarPorId(id);
        // return titularDAO.buscarPorId(id).toString();
    }

    public StringBuilder buscarPorNombre(String nombre)
    {
        // Más puro
        List<Titular> lista = titularDAO.buscarPorNombre(nombre);
        StringBuilder sb = new StringBuilder();
        for (Titular t : lista) {
            sb.append(t.toString()).append("\n");
        }
        return sb;
    }


}
