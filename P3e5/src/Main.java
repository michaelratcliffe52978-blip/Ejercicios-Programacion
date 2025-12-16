import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static String mes;

    public static void main(String[] args) {
        try {

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void meses() {
        boolean errorMes = true;
        do {
            try {
                System.out.println("INTRODUCE EL MES:");
                mes = sc.nextLine().trim().toLowerCase();

                if(mes.isEmpty()){
                    throw new ExcepcionMes();
                }

                if(mes.equals("enero")||mes.equals("febrero")||mes.equals("marzo")||mes.equals("abril")||
                   mes.equals("mayo")||mes.equals("junio")||mes.equals("julio")||mes.equals("agosto")||
                   mes.equals("septiembre")||mes.equals("octubre")||mes.equals("noviembre")||mes.equals("diciembre"))
                {
                    System.out.println("Mes introducido correctamente");
                    errorMes = false;
                }else {
                    throw new ExcepcionMes();
                }

            }catch (ExcepcionMes e){
                System.out.println("ERROR: introduce un mes correcto.");
            }
        }while (errorMes);

    }
}