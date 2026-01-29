import java.util.Scanner;

public class Main {
    private final static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            menu();
            System.out.println("Ingrese tu opcion:");
            int opcion = sc.nextInt();
            switch(opcion){
                case 1 -> mostrarClientesPorAnimal();
                case 2 -> ;
                case 3 -> ;
                case 4 -> ;
                case 5 -> ;
                case 6 -> {};

            }

        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static void menu(){
        System.out.println("""
            --- M E N Ú ---
            1. Mostrar el número de clientes que poseen un tipo de animal concreto.
            2. Mostrar datos del cliente por nombre del animal.
            3. Mostrar datos del veterinario por nombre del animal.
            4. Mostrar datos de las mascotas del cliente.
            5. Mostrar datos de las mascotas del veterinario.
            0. Salir
            """);

        System.out.println();

    }
    public static void mostrarClientesPorAnimal(){}

}