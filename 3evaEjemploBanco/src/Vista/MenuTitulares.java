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
        if(dni!= null) {
            String nombre = EntradaDatos.leerTexto(sc,"Ingrese el nombre del titular: ", "^[A-Za-z ]+$");
            titularController.crearTitular(dni, nombre);
            System.out.println("Titular creado correctamente.");
        }


    }

    public void modificarTitular() {
        System.out.println("\n=== MODIFICAR TITULAR ===");
        Titular titular = buscarPorDni();
        if(titular != null) {
            String nuevoNombre = EntradaDatos.leerTexto(sc,"Ingrese el nuevo nombre del titular: ", "^[A-Za-z ]+$");
            titular.setNombre(nuevoNombre);
            // Aquí podrías agregar lógica para actualizar el titular en la base de datos
            System.out.println("Titular modificado correctamente.");
        }
    }

    public  void borrarTitular() {

    }

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

    private void listarPorNombre() {
        System.out.println("\n=== LISTAR TITULARES POR NOMBRE ===");
        String nombre = EntradaDatos.leerTexto(sc, "Ingrese el nombre a buscar: ", "^[A-Za-z ]+$");
        if (nombre != null) {
            // Variable global?
            StringBuilder sb = titularController.buscarPorNombre(nombre);
            if (!sb.isEmpty()) {
                System.out.println(sb.toString());
            } else {
                System.out.println("No se encontró ningún titular con el nombre proporcionado.");
            }
        }
    }

    private Titular buscarPorId() {
        System.out.println("\n=== BUSCAR TITULAR POR ID ===");
        int id = EntradaDatos.leerEntero(sc,"Ingrese el ID del titular: ");
        if(id != -1) {
            Titular titular = titularController.buscarPorId(id);
            if (titular != null) {
                System.out.println("Titular encontrado: " + titular);
            } else {
                System.out.println("No se encontró ningún titular con ese ID.");
            }
            return titular;
        }
        return null;
    }

    private Titular buscarPorDni() {
        System.out.println("\n=== BUSCAR TITULAR POR DNI ===");
        String dni = EntradaDatos.leerTexto(sc,"Ingrese el DNI del titular: ", "^[0-9]{8}[A-Za-z]$");
        if(dni != null) {
            Titular titular = titularController.buscarPorDni(dni);
            if (titular != null) {
                System.out.println("Titular encontrado: " + titular);
            } else {
                System.out.println("No se encontró ningún titular con ese DNI.");
            }
            return titular;

        }
        return null;
    }


}


