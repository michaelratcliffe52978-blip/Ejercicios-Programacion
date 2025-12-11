import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    // Colas paralelas
    private static Queue<LocalDate> fechaCaducidad = new LinkedList<>();
    private static Queue<String> nombreProductos = new LinkedList<>();

    public static void main(String[] args) {
        try {
            String opcion;
            do {
                principal();
                System.out.println("¿Quieres continuar añadiendo productos? (s/n): ");
                opcion = sc.nextLine().toLowerCase();
            } while (opcion.equals("s") || opcion.equals("si"));

            fecha();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void principal() {
        System.out.print("Introduce el nombre del producto: ");
        nombreProductos.offer(sc.nextLine());

        boolean errorFecha = true;
        do {
            try {
                System.out.print("Introduce la fecha de caducidad del producto (dd/MM/yyyy): ");
                String fecha = sc.nextLine();

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate date = LocalDate.parse(fecha, formatter);

                fechaCaducidad.offer(date); // <-- AQUÍ guardamos la fecha
                errorFecha = false;
            } catch (Exception e) {
                System.out.println("Error al escribir la fecha, formato incorrecto.");
            }
        } while (errorFecha);
    }

    public static void fecha() {
        System.out.print("Introduce la fecha desde la cual eliminaremos los productos caducados (dd/MM/yyyy): ");
        String fechaEliminar = sc.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaLimite = LocalDate.parse(fechaEliminar, formatter);

        // Colas temporales para dejar solo los productos NO caducados
        Queue<LocalDate> nuevasFechas = new LinkedList<>();
        Queue<String> nuevosProductos = new LinkedList<>();

        while (!fechaCaducidad.isEmpty()) {
            LocalDate f = fechaCaducidad.poll();
            String p = nombreProductos.poll();

            if (f.isBefore(fechaLimite)) {
                System.out.println("Producto eliminado por caducado: " + p + " (caducó: " + f + ")");
            } else {
                nuevasFechas.offer(f);
                nuevosProductos.offer(p);
            }
        }

        // Reemplazamos las colas originales
        fechaCaducidad = nuevasFechas;
        nombreProductos = nuevosProductos;

        System.out.println("\nProductos que siguen en la cola:"+ nombreProductos);

    }
}
