import Excepciones.ExceptionVacio;
import Modulo.Pedido;
import Modulo.Producto;
import Modulo.Usuario;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private final static Scanner sc = new Scanner(System.in);
    private static String nombre, email;
    private static ArrayList<Producto> productos = new ArrayList<>();
    private static ArrayList<Usuario> usuarios = new ArrayList<>();
    private static ArrayList<Pedido> pedidos = new ArrayList<>();



    public static void main(String[] args) {
        Producto p1 = new Producto("Estuche",15.00f,3);
        Producto p2 = new Producto("Raton",25.50f,10);
        Producto p3 = new Producto("Teclado",55.99f,5);
        Producto p4 = new Producto("Cargador",10.00f,0);
        Producto p5 = new Producto("Altavoz",150.00f,1);
        productos.add(p1);
        productos.add(p2);
        productos.add(p3);
        productos.add(p4);
        productos.add(p5);
        int opcion;
        do{
            menu();
            System.out.print("Escribe tu opción: ");
             opcion = sc.nextInt();
             sc.nextLine();
            switch(opcion){
                case 1:
                    darDeAlta();
                    break;
                case 2:
                    realizarPedido();
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
                    break;
            }
        }while (opcion!=3);

    }
    public static void menu(){
        System.out.println("""
                --- M E N Ú ---
                1. DAR DE ALTA USUARIO
                2. REALIZAR PEDIDO
                3. SALIR DEL PROGRAMA""");
    }

    public static void darDeAlta(){
        boolean continuar = true;
        do {
            System.out.println("\nDAR DE ALTA USUARIO");
            nombre = validarDato("nombre", "Escribe el nombre del usuario: ", "^[A-Za-z ]+$");
            email = validarEmail("email", "Escribe el email: ", "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");

            Usuario u = new Usuario(nombre,email,pedidos);
            usuarios.add(u);

            System.out.println("✅ Usuario registrado: " + nombre + " (" + email + ")");

            System.out.print("\n¿Deseas dar de alta otro usuario? (s/n): ");
            String respuesta = sc.nextLine().trim().toLowerCase();
            if(!respuesta.equalsIgnoreCase("s")&& !respuesta.equalsIgnoreCase("si")&& !respuesta.equalsIgnoreCase("sí")){
                continuar = false;
            }

        }while(continuar);

    }

    public static void realizarPedido(){
        System.out.println("\nREALIZAR PEDIDO");

        if (usuarios.isEmpty()) {
            System.out.println("❌ No hay usuarios registrados. Primero da de alta un usuario.");
            return;
        }

        boolean continuar = true;
        do {
            System.out.print("Escriba tu nombre de usuario: ");
            String nombreUsuario= sc.nextLine();

            for(Usuario u : usuarios){
                if(u.getNombre().equalsIgnoreCase(nombreUsuario)){
                    System.out.println("Usuario encontrado: " + nombreUsuario + " (" + u.getEmail() + ")");
                    System.out.println("Pedidos:");
                    int contador = 1;
                    for(Producto p: productos){
                        System.out.println(contador+". "+p.getNombre()+" - "+p.getPrecio()+"€ - "+p.getStock()+" stocks");
                        contador++;
                    }
                    int producto;
                    do {
                        System.out.println("Escriba el producto que quieras seleccionar:");
                         producto = sc.nextInt();
                         sc.nextLine();

                    }while(producto < 1 || producto > productos.size());

                         Producto productoSeleccionado = productos.get(producto-1);

                         //Comprobar stock
                         if(productoSeleccionado.getStock()<=0){
                             System.out.println("❌ No hay stock disponible.");
                         }

                         //Crear Pedido
                        Pedido pedidido = new Pedido(u,productoSeleccionado,LocalDate.now());
                        pedidos.add(pedidido);

                        productoSeleccionado.setStock(productoSeleccionado.getStock()-1);

                    System.out.println("✅ Pedido realizado correctamente.");



                }else{
                    System.out.println("Usuario '"+nombreUsuario+"' no encontrado.");
                    continuar = false;
                }
            }

        }while(continuar);
    }




    //VALIDACIONES
    public static String validarDato(String dato, String frase, String formato){
        boolean error = true;
        String respuesta = null;
        do {
            try {
                System.out.print(frase);
                respuesta = sc.nextLine();

                Matcher mat = Pattern.compile(formato).matcher(respuesta);
                if(!mat.matches()){
                    throw new Exception();
                }
                error = false;
            }catch (Exception e){
                System.out.println(dato + " no válido.");
            }
        }while (error);
        return respuesta;
    }
    public static String validarEmail(String dato, String frase, String formato){
        boolean errorEmail = true;
        String respuesta = null;
        do {
            try {
                System.out.print(frase);
                respuesta = sc.nextLine();

                Matcher mat = Pattern.compile(formato).matcher(respuesta);
                if(!mat.matches()){
                    throw new Exception();
                }
                if(respuesta.isEmpty()){
                    throw new ExceptionVacio();
                }
                errorEmail = false;
            }catch (Exception e){
                System.out.println(dato + " no válido.");
            }
        }while (errorEmail);
        return respuesta;
    }

}