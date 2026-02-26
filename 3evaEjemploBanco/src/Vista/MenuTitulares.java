package Vista;

import Controladores.TitularController;
import Modelo.Titular;
import Utilidades.EntradaDatos;

import java.util.List;
import java.util.Scanner;

public class MenuTitulares {
    private TitularController titularController;
    private Scanner sc;

    public MenuTitulares() {
        titularController = new TitularController();
        sc = new Scanner(System.in);
    }

    public void mostrarMenu()
    {
        int opcion;
        do
        {
            System.out.println("\n====== MENÚ BANCO (TITULARES)  ======");
            System.out.println("1. Crear titular");
            System.out.println("2. Modificar titular");
            System.out.println("3. Borrar titular");
            System.out.println("4. Listar titulares");
            System.out.println("5. Listar titulares por nombre");
            System.out.println("6. Buscar por ID");
            System.out.println("7. Buscar por DNI");
            System.out.println("0. Salir");
            opcion = EntradaDatos.leerEntero(sc, "Elige opción: ");

            switch (opcion) {
                case 1 -> crearTitular();
                case 2 -> modificarTitular();
                case 3 -> borrarTitular();
                case 4 -> listarTitulares();
                case 5 -> listarPorNombre();
                case 6 -> buscarPorId();
                case 7 -> buscarPorDni();
                case 0 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }


    public void crearTitular() {
        System.out.println("\n=== CREAR TITULAR ===");
        String dni = EntradaDatos.leerTexto(sc,"Ingrese el DNI del titular: ", "^[0-9]{8}[A-Za-z]$");
        String nombre = EntradaDatos.leerTexto(sc,"Ingrese el nombre del titular: ", "^[A-Za-z ]+$");
        titularController.crearTitular(dni, nombre);
        System.out.println("Titular creado correctamente.");


    }
    public void modificarTitular() {

    }


    public  void borrarTitular() {}
    public void listarTitulares() {
        System.out.println("\n=== LISTAR TITULARES ===");
        List<Titular> titulares = titularController.listarTitular();

        if (titulares.isEmpty()) {
            System.out.println("No hay titulares registrados.");
        }
        else  {
            for (Titular t : titulares) {
                System.out.println(t);
            }
        }
    }
    public void listarPorNombre() {}
    public void buscarPorId() {}
    public void buscarPorDni() {}


}


