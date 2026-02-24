package Vista;

import Controladores.TitularController;
import Modelo.Titular;
import Utilidades.EntradaDatos;

import java.util.List;
import java.util.Scanner;

public class MenuTresControladores {
    private TitularController titularController;

    private final static Scanner sc = new Scanner(System.in);

    public MenuTresControladores() {
        titularController = new TitularController();

    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("=== Menú Principal ===");
            System.out.println("1. Insertar titulares");
            System.out.println("2. Crear titular");
            System.out.println("3. Consultar titulares");
            System.out.println("4. Eliminar titulares");
            System.out.println("5. Listar titulares");
            System.out.println("0. Salir");

            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> insertarTitulares();
                case 2 -> crearTitular();
                case 3 -> consultarTitulares();
                case 4 -> eliminarTitulares();
                case 5 -> listarTitular();
                default -> System.out.println("Opción no válida. Por favor, seleccione una opción del menú.");
            }
        }
        while (opcion != 0);
    }

    public void insertarTitulares() {

    }

    public void crearTitular() {
        System.out.println("\n=== CREAR TITULAR ===");
        String dni = EntradaDatos.leerTexto("Ingrese el DNI del titular: ");
        String nombre = EntradaDatos.leerTexto("Ingrese el nombre del titular: ");
        //FALTAN VALIDACIONES
        titularController.crearTitular(dni, nombre);

    }

    public void consultarTitulares() {
    }

    public void eliminarTitulares() {
    }

    public void listarTitular() {
        System.out.println("\n=== LISTAR TITULARES ===");
        List<Titular> titulares = titularController.listarTitulares();

        if (titulares.isEmpty()) {
            System.out.println("No hay titulares registrados.");
        }
        else  {
            for (Titular t : titulares) {
                System.out.println(t);
            }
        }
    }
}


