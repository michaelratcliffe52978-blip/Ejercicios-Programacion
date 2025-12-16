import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static Map<String, Integer> map = new HashMap<>();
    private static String nombre;
    private static Integer tel;
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
                nombre = sc.nextLine().trim();
                
                if(nombre.isEmpty()){
                    throw new ExcepcionContacto();
                }

                boolean errorNumero = true;
                do {
                    try {
                        System.out.print("Número de teléfono (9 nº): ");
                        tel = sc.nextInt();

                        if(tel < 100000000 || tel > 999999999){
                            throw new ExcepcionContacto();
                        }
                        errorNumero = false;
                    }catch (Exception e){
                        System.out.println("Error, introduce un nº de teléfono de 9 dígitos.");
                        sc.nextLine();
                    }
                }while (errorNumero);

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
        System.out.print("Introduce el nº de teléfono y el contacto será BORRADO: ");
        sc.nextLine();
        int telBorrar = sc.nextInt();

        boolean borrado = map.entrySet().removeIf(
                entry -> entry.getValue().equals(telBorrar)
        );

        if(borrado){
            System.out.println("El teléfono '" + telBorrar + "' se ha borrado correctamente.");
        }else{
            System.out.println("No existe ningún contacto con ese teléfono.");
        }
    }
    public static void opcion3(){
        System.out.print("Introduce el nº de teléfono y buscaremos el contacto: ");
        sc.nextLine();
        int telBuscar = sc.nextInt();

        if(map.containsValue(telBuscar)){
            System.out.println("El teléfono '" + telBuscar + "' se ha encontrado correctamente.");
        }else{
            System.out.println("No existe ningún contacto con ese teléfono.");
        }

    }
    public static void opcion4(){
        System.out.print("Introduce el nombre y borraremos el contacto: ");
        sc.nextLine();
        String nombreBuscar = sc.nextLine().trim();
        if(map.containsKey(nombreBuscar)){
            map.remove(nombreBuscar);
            System.out.print("El contacto '"+nombreBuscar+"' se ha borrado correctamente.");

        }else {
            System.out.println("No existe el contacto con el nombre '" + nombreBuscar + "'");
        }

    }
    public static void opcion5(){
        System.out.print("Introduce el nombre y buscaremos el contacto: ");
        sc.nextLine();
        String nombreBuscar = sc.nextLine();

        if(map.containsKey(nombreBuscar)){
            System.out.println("El contacto '" + nombreBuscar + "' se ha encontrado correctamente.");
        }else{
            System.out.println("No existe ningún contacto con ese nombre.");
        }


    }



}