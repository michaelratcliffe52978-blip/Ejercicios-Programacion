import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static Stack<String> libros = new Stack<>();
    private static String nombreLibro;
    public static void main(String[] args) {
        try {
            String opcion;
            do {
                menu();
                opcion = sc.nextLine().trim();
                switch (opcion) {
                    case "a":
                    case "a)":
                        anadir();
                        break;
                    case "b":
                    case "b)":
                        consultar();
                        break;
                    case "c":
                    case "c)":
                        retirar();
                        break;
                    case "d":
                    case "d)":
                        mostrar();
                        break;
                    case "e":
                    case "e)":
                        verificar();
                        break;
                    case "f":
                    case "f)":
                        System.out.println("Saliendo del programa...");
                        break;

                    default: System.out.println("Opción no valida. Por favor, elija una opción entre a y f.");
                }
            }while(!opcion.equals("f") &&  !opcion.equals("f)"));
        }catch (Exception e){
            System.err.println(e.getMessage());
        }

    }
    public static void menu() {
        System.out.println("\n--- M E N Ú ---");
        System.out.println("""
                a) Anadir un libro a la pila: Solicitar al usuario el título del libro y colocarlo en la parte superior de la pila.
                b) Consultar el libro en la parte superior: Mostrar el título del libro que está en la parte superior sin eliminarlo.
                c) Retirar el libro en la parte superior: Eliminar el libro de la parte superior de la pila y mostrar su título.
                d) Mostrar todos los libros en la pila: Listar todos los libros, desde el mas reciente hasta el más antiguo.
                e) Verificar si la pila esta vacía: Informar al usuario si no hay libros en la pila.
                f) Salir del programa""");
        System.out.print("Seleccione una opción (a–f): ");
    }

    public static void anadir(){
        String opcion = "";
        do {
            try {
                System.out.print("Introduce el nombre del libro: ");
                nombreLibro = sc.nextLine().trim();

                if(nombreLibro.isEmpty()){
                    throw new Exception();
                }

                libros.push(nombreLibro);
                System.out.println("'"+nombreLibro+"' añadido correctamente.");


                System.out.print("¿Quieres continuar? ( s / n ): ");
                opcion = sc.nextLine().trim();
            }catch (Exception e){
                System.err.println("Error al intentar anadir al libro, vuelve a intentarlo.");
            }
        }while (opcion.equalsIgnoreCase("s") || opcion.equalsIgnoreCase("si"));

    }
    public static void consultar(){
        System.out.println("El último libro en entrar es '"+libros.peek()+"'");
    }
    public static void retirar(){
        System.out.println("El último libro en entrar es '"+libros.pop()+"' y ha sido ELIMINADO");
    }
    public static void mostrar(){
        for(String libro: libros){
            System.out.println(libro);
        }
    }
    public static void verificar(){
        if(libros.isEmpty()){
            System.out.println("No hay libros en la pila.");

            System.out.println("¿Quieres añadir libros? (si/no)");
            String opcion = sc.nextLine().trim();
            if(opcion.equalsIgnoreCase("si") || opcion.equalsIgnoreCase("s")){
                anadir();
            }
        }else {
            System.out.println("\nYa existen libros en la pila:");
            mostrar();
        }

    }



}