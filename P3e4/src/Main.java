import java.util.*;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static Map<String, Integer> map = new HashMap<>();
    public static void main(String[] args) {
        try {
            int opcion;
            do {
                menu();
                opcion = sc.nextInt();
                switch (opcion) {
                    case 1:
                        opcion1();
                        break;
                    case 2:
                        opcion2();
                        break;
                    case 3:
                        opcion3();
                        break;
                    case 4:
                        opcion4();
                        break;
                    case 5:
                        opcion5();
                        break;
                    case 6:
                        System.out.println("Saliendo del programa...");
                        break;
                    default: System.out.println("Opción no valida. Por favor, elija una opción entre a y f.");
                }
            }while(opcion != 6);
        }catch (Exception e){
            System.err.println(e.getMessage());
        }

    }
    public static void menu() {
        System.out.println("\n--- M E N Ú ---");
        System.out.println("""
                1.- Añadir un nuevo número.
                2.- Borrar un número.
                3.- Buscar un número.
                4.- Borrar por nombre.
                5.- Buscar por nombre.
                6.- Salir.""");
        System.out.print("Seleccione una opción (1–6): ");
    }

    public static void opcion1(){
        String siNo = "";
        do {
            
            try {
                System.out.println("\nNUEVO CONTACTO: ");
                System.out.print("Nombre: ");
                sc.nextLine();
                String nombre = sc.nextLine().trim();
                
                if(nombre.isEmpty()){
                    throw new ExcepcionContacto();
                }
                
                System.out.print("Número de teléfono: ");
                int tel = sc.nextInt();

                map.put(nombre, tel);
                System.out.println("Contacto añadido correctamente.");


                System.out.println("¿Quieres añadir otro contacto? (si/no)");
                siNo = sc.next().trim().toLowerCase();
            }catch (ExcepcionContacto e){
                System.out.println("Error al intentar ingresar el contacto.");
            }
        }while (siNo.equalsIgnoreCase("si")||siNo.equalsIgnoreCase("s") );
        
    }
    public static void opcion2(){
    }
    public static void opcion3(){
    }
    public static void opcion4(){
    }
    public static void opcion5(){

    }



}