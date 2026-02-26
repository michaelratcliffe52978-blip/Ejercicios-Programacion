package Utilidades;

import java.util.Scanner;

public class EntradaDatos {

    public static int leerEntero(Scanner sc, String mensaje) {
        int num = 0;
        boolean error = true;
        try {
            num = 0;
            do
            {
                System.out.print(mensaje);
                try {
                    num = Integer.parseInt(sc.nextLine());
                    // También se puede con nextInt pero así me ahorro el limpiar el buffer después.
                    error = false;
                } catch (NumberFormatException e) {
                    System.out.println("Error: introduce un número entero válido.");
                }
            }
            while (error);
            return num;
        }
        catch (Exception e) {
            System.out.println("Error leyendo el número: " + e.getMessage());
            return -1;
        }
    }

    public static String leerTexto(Scanner sc, String mensaje,String formato) {
        try
        {
            String texto;
            do
            {
                System.out.print(mensaje);
                texto = sc.nextLine();
                if (!texto.matches(formato))
                {
                    System.out.println("Error: formato no válido. Inténtalo de nuevo.");
                }
            } while (!texto.matches(formato));
            return texto;
        }
        catch (Exception e)
        {
            System.out.println("Error leyendo el texto: " + e.getMessage());
            return "";
        }
    }
}
