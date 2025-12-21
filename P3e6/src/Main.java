import java.util.*;

public class Main {

    private static final Scanner sc = new Scanner(System.in);

    // a) Especies aceptadas
    private static String[] especies = {"Perro", "Gato", "Conejo", "Loro", "Tortuga"};

    // b) Animales rescatados
    private static ArrayList<String> animalesRescatados = new ArrayList<>();

    // c) Relación animal - cuidador
    private static Map<String, String> cuidadores = new HashMap<>();

    // d) Cola de adopción
    private static Queue<String> colaAdopcion = new LinkedList<>();

    public static void main(String[] args) {

        String opcion;

        do {
            menu();
            opcion = sc.nextLine().toLowerCase().trim().replaceAll("","");

            switch (opcion) {
                case "a":
                case "a)":
                    opcionA();
                    break;

                case "b":
                case "b)":
                    opcionB();
                    break;

                case "c":
                case "c)":
                    opcionC();
                    break;

                case "d":
                case "d)":
                    opcionD();
                    break;

                case "e":
                case "e)":
                    opcionE();
                    break;

                case "f":
                case "f)":
                    opcionF();
                    break;

                case "g":
                case "g)":
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (!opcion.equals("g") && !opcion.equals("g)"));
    }

    public static void menu() {
        System.out.println("\n--- M E N Ú ---");
        System.out.println("""
                a) Ver especies aceptadas.
                b) Agregar un nuevo animal al listado de rescatados.
                c) Asignar un cuidador a un animal.
                d) Pasar un animal a la cola de espera de adopción.
                e) Adoptar un animal.
                f) Listar todos los animales y sus cuidadores actuales.
                g) Salir
                """);
        System.out.print("Seleccione una opción (a–g): ");
    }

    public static void opcionA() {
        System.out.println("Especies aceptadas:");
        for (String a : especies) {
            System.out.println("- " + a);
        }
    }

    public static void opcionB() {
        System.out.print("Nombre del animal: ");
        String nombre = sc.nextLine().trim();

        System.out.print("Especie: ");
        String especieInput = sc.nextLine().trim();

        String especie = especieInput.substring(0,1).toUpperCase() + especieInput.substring(1).toLowerCase();

        if (Arrays.asList(especies).contains(especie)) {
            String animal = nombre + " - " + especie;

            if (!animalesRescatados.contains(animal)) {
                animalesRescatados.add(animal);
                System.out.println("Animal agregado correctamente.");
            } else {
                System.out.println("Ese animal ya está registrado.");
            }

        } else {
            System.out.println("Esa especie no es aceptada.");
        }
    }

    public static void opcionC() {
        System.out.print("Nombre del animal: ");
        String nombre = sc.nextLine().trim();

        boolean existe = false;

        for (String a : animalesRescatados) {
            if (a.startsWith(nombre + " -")) {
                existe = true;
                break;
            }
        }

        if (!existe) {
            System.out.println("Ese animal no está en la lista de rescatados.");
            return;
        }

        System.out.print("Nombre del cuidador/a: ");
        String cuidador = sc.nextLine().trim();

        cuidadores.put(nombre, cuidador);
        System.out.println("Cuidador asignado correctamente.");
    }

    public static void opcionD() {
        System.out.print("Nombre del animal: ");
        String nombre = sc.nextLine().trim();

        String animalEncontrado = null;

        for (String a : animalesRescatados) {
            if (a.startsWith(nombre + " -")) {
                animalEncontrado = a;
                break;
            }
        }

        if (animalEncontrado != null) {
            animalesRescatados.remove(animalEncontrado);
            colaAdopcion.add(animalEncontrado);
            System.out.println("Animal enviado a la cola de adopción.");
        } else {
            System.out.println("Animal no encontrado.");
        }
    }

    // e) Adoptar animal
    public static void opcionE() {
        if (colaAdopcion.isEmpty()) {
            System.out.println("No hay animales en adopción.");
        } else {
            String adoptado = colaAdopcion.poll();
            String nombre = adoptado.split(" - ")[0];
            cuidadores.remove(nombre);

            System.out.println("Animal adoptado: " + adoptado+"🎉");
        }
    }

    // f) Listar animales y cuidadores
    public static void opcionF() {
        if (cuidadores.isEmpty()) {
            System.out.println("No hay animales con cuidadores asignados.");
        } else {
            System.out.println("Animales y cuidadores:");
            for (Map.Entry<String, String> entry : cuidadores.entrySet()) {
                System.out.println(entry.getKey() + " → " + entry.getValue());
            }
        }
    }
}
