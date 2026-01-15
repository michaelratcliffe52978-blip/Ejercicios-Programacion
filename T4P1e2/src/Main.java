import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static List<Alumno> listaClase;
    public static void main(String[] args) {
        boolean error = true;
            do {
                try {
                    listaClase = new ArrayList<Alumno>();
                    System.out.println("Ingrese el CÓDIGO del Alumno: ");
                    int codigo = sc.nextInt();
                    System.out.println("Ingrese el NOMBRE del Alumno: ");
                    String nombre = sc.next();
                    System.out.println("Ingrese el DOMICILIO del Alumno: ");
                    String domicilio = sc.next();
                    System.out.println("Ingrese el TELÉFONO del Alumno: ");
                    int telefono = sc.nextInt();


                    Alumno a = new Alumno(codigo,nombre,domicilio,telefono);
                    System.out.println(a.toString());
                    //Guardar objeto en el Arraylist
                    listaClase.add(a);
                    error = false;
                }catch (Exception e){
                    System.out.println("PROBLEMAS:"+e.getMessage() +" INTENTELO DE NUEVO");
                    sc.next();
                }
            }while(error);

        System.out.print("\nIntroduce el código del alumno a buscar: ");
        String codigoBuscado = sc.nextLine();


    }
}