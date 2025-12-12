import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        try {
            String opcion;
            do {
                menu();
                opcion = sc.nextLine().trim();
                switch (opcion) {
                    case "a":
                    case "a)":

                    case "b":
                    case "b)":

                    case "c":
                    case "c)":

                    case "d":
                    case "d)":

                    case "e":
                    case "e)":

                    case "f":
                    case "f)":
                        System.out.println("Saliendo del programa...");

                    default: System.out.println("Opción no valida. Por favor, elija una opción entre a y f.");
                }
            }while(!opcion.equals("f"));
        }catch (Exception e){
            System.err.println(e.getMessage());
        }

    }
    public static void menu() {
        System.out.println("\n--- M E N Ú ---");
        System.out.println("""
                a) Anadir un libro a la pila: Solicitar al usuario el tÍtulo del libro Y colocarlo en la parte superior de la pila.
                b) Consultar el libro en la parte superior: Mostrar el tÍtulo del libro que está en la parte superior sin eliminarlo.
                c) Retirar el libro en la parte superior: Eliminar el libro de la parte superior de la pila y mostrar su título.
                d) Mostrar todos los libros en la pila: Listar todos los libros, desde el mas reciente hasta el más antiguo.
                e) Verificar si la pila esta vacía: Informar al usuario si no hay libros en la pila.
                f) Salir del programa""");
        System.out.print("Seleccione una opción (a–f): ");
    }
}