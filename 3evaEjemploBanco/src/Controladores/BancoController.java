package Controladores;

import DAO.CuentaTitularDAO;
import DAO.TitularDAO;
import Modelo.Titular;

public class BancoController {

    private CuentaTitularDAO cuentaTitularDAO;
    private TitularDAO titularDAO;

    public BancoController() {
        this.cuentaTitularDAO = new CuentaTitularDAO();
        this.titularDAO = new TitularDAO();
    }

    // Obtener ID de cuenta por IBAN
    public int obetenerIdCuentaPorIBAN(String iban) {
        return cuentaTitularDAO.obetenerIdCuentaPorIBAN(iban);
    }

    // Obtener ID de titular por DNI
    public int obtenerTitularPorDNI(String dni) {
        return cuentaTitularDAO.obtenerTitularPorDNI(dni);
    }

    // Verificar si existe un titular
    public boolean existeTitular(int idTitular) {
        Titular titular = titularDAO.buscarPorId(idTitular);
        return titular != null;
    }

    // Asignar titular a cuenta
    public void asignarTitularCuenta(int idCuenta, int idTitular) {
        cuentaTitularDAO.asignarTitularCuenta(idCuenta, idTitular);
    }
}
