package Vista;

import Controladores.BancoController;
import Utilidades.EntradaDatos;

import java.util.Scanner;

public class MenuCuentasTitulares {
    private final static Scanner sc = new Scanner(System.in);
    private BancoController bancoController;

    public MenuCuentasTitulares() {
        this.bancoController = new BancoController();
    }

    public void mostrarMenu() {

        int opcion;
        do {
            System.out.println("\n====== MENÚ BANCO (CUENTAS Y TITULARES)  ======");
            System.out.println("1. Asignar titular a cuenta");
            System.out.println("2. Modificar titular de una cuenta");
            System.out.println("3. Borrar titular de una cuenta");
            System.out.println("4. Listar titulares de una cuenta");
            System.out.println("5. Listar cuentas de un titular");
            System.out.println("0. Salir");

            opcion = EntradaDatos.leerEntero(sc, "Elige opción: ");

            switch(opcion) {
                case 1 -> asignarTitularCuenta();
                case 2 -> modificarTitularCuenta();
                case 3 -> borrarTitularCuenta();
                case 4 -> listarTitularCuenta();
                case 5 -> listarCuentasTitular();
                case 0 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción inválida.");
            }

        }while (opcion!=0);


    }

    private void asignarTitularCuenta() {
        String iban = EntradaDatos.leerTexto(sc, "Ingrese el IBAN de la cuenta: ", "^ES[0-9]{22}$");
        if(iban!=null){
            if(EntradaDatos.validacionIBAN(iban)){
                int idCuenta = bancoController.obetenerIdCuentaPorIBAN(iban);

                if(idCuenta!=-1){
                    String dni = EntradaDatos.leerTexto(sc, "Ingrese el DNI del titular a asignar: ", "^[0-9]{8}[A-Za-z]$");
                    if(dni!=null){
                        int idTitular = bancoController.obtenerTitularPorDNI(dni);
                        if(bancoController.existeTitular(idTitular)){
                            bancoController.asignarTitularCuenta(idCuenta, idTitular);
                            System.out.println("Titular asignado correctamente a la cuenta.");

                        }else{
                            System.out.println("No existe un titular con ese DNI. Intente nuevamente.");
                        }
                    }

                } else {
                    System.out.println("No se encontró la cuenta con ese IBAN.");
                }

            } else {
                System.out.println("IBAN inválido.");
            }
        }


    }
    private void modificarTitularCuenta() {

    }
    private void borrarTitularCuenta() {
    }
    private void listarTitularCuenta() {
    }
    private void listarCuentasTitular() {
    }




}
