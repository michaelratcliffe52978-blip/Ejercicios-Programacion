import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    private static Set<String> porteros = new HashSet<>();
    private static Set<String> defensas = new HashSet<>();
    private static Set<String> centrocampistas = new HashSet<>();
    private static Set<String> delanteros = new HashSet<>();

    public static void main(String[] args) {
        try {
            String opcion;
            do {
                anadirJugador();
                mostrarJugadores();
                System.out.println("¿Quieres continuar añadiendo jugadores? (s/n): ");
                opcion = sc.nextLine().toLowerCase();
            } while (opcion.equals("s"));

            System.out.println("M O D I F I C A C I O N E S:");
            System.out.println("Introduce '1' para dar de alta, '2' para dar de baja, '3' para modificar, '4' para salir");
            int nmenu;
            do {
                switch (nmenu = sc.nextInt()) {
                    case 1:
                        alta();
                        break;
                    case 2:
                        baja();
                        break;
                    case 3:
                        modificaciones();
                        break;
                    case 4:
                        System.out.println("Saliendo...");
                    default:
                        System.out.println("Opcion invalida");
                }
            } while (nmenu == 4);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void anadirJugador() {
        System.out.print("Introduce el nombre del jugador: ");
        String nombre = sc.nextLine();

        boolean existeJugador = true;
        do {
            try {
                System.out.print("Introduce la posición del jugador (portero|defensa|centrocampista|delantero): ");
                String rol = sc.nextLine().toLowerCase();

                if (rol.equals("portero") || rol.equals("defensa") || rol.equals("centrocampista") || rol.equals("delantero")) {
                    if (rol.contains("portero")) {
                        porteros.add(nombre);
                    } else if (rol.contains("defensa")) {
                        defensas.add(nombre);
                    } else if (rol.contains("centrocampista")) {
                        centrocampistas.add(nombre);
                    } else if (rol.contains("delantero")) {
                        delanteros.add(nombre);
                    } else {
                        System.out.println("Posición no reconocida.");
                    }

                    existeJugador = false;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("ERROR: tiene que contener");
            }
        } while (existeJugador);

    }

    public static void mostrarJugadores() {
        System.out.println("Porteros: " + porteros);
        System.out.println("Defensas: " + defensas);
        System.out.println("Centrocampistas: " + centrocampistas);
        System.out.println("Delanteros: " + delanteros);
    }

    public static void alta() {
        sc.nextLine();
        System.out.print("Introduce el nombre del nuevo jugador: ");
        String nombre = sc.nextLine();

        System.out.println("Introduce el rol del jugador:");
        System.out.println("1. Portero");
        System.out.println("2. Defensa");
        System.out.println("3. Centrocampista");
        System.out.println("4. Delantero");
        boolean existeJugador = true;
        do {
            try {
                System.out.print("Opción: ");
                int rol = sc.nextInt();
                if (rol == 1 || rol == 2 || rol == 3 || rol == 4) {
                    existeJugador = false;
                } else {
                    throw new Exception();
                }
                switch (rol) {
                    case 1 -> porteros.add(nombre);
                    case 2 -> defensas.add(nombre);
                    case 3 -> centrocampistas.add(nombre);
                    case 4 -> delanteros.add(nombre);
                    default -> System.out.println("Opción no válida, no se añadió el jugador.");
                }
                System.out.println("Jugador añadido correctamente.");
                existeJugador = false;
            } catch (Exception e) {
                System.out.println("ERROR: vuelve a elegir.");
                sc.nextLine();
            }
        } while (existeJugador);
        mostrarJugadores();
    }

    public static void baja() {
        sc.nextLine();
        System.out.println("Introduce el nombre del jugador que quieres dar de baja: ");
        String nombreBaja = sc.nextLine();

        if (porteros.remove(nombreBaja) ||
                defensas.remove(nombreBaja) ||
                centrocampistas.remove(nombreBaja) ||
                delanteros.remove(nombreBaja)) {
            System.out.println("Jugador eliminado correctamente.");
        } else {
            System.out.println("Ese jugador no existe.");
        }
        mostrarJugadores();
    }

    public static void modificaciones() {
        sc.nextLine();
        System.out.println("Introduce el nombre del jugador que quieres modificar: ");
        String nombreModificado = sc.nextLine();

        boolean existeJugador = true;
        do {
            try {
                if (porteros.contains(nombreModificado) ||
                    defensas.contains(nombreModificado) ||
                    centrocampistas.contains(nombreModificado) ||
                    delanteros.contains(nombreModificado))
                {


                existeJugador = false;
                }else{
                    System.out.println("Jugador no encontrado.");
                }
            }catch (Exception e) {
                System.out.println("ERROR: vuelve a elegir.");
                sc.nextLine();
            }
        }while (existeJugador);


    }
}