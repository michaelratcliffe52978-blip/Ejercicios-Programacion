import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private final static Scanner sc = new Scanner(System.in);
    private static ArrayList<Pelicula> listaPeliculas;
    private static Estudio[] arrayEstudios;


    public static void main(String[] args) {
        try {
            crearPeliculas();
            crearEstudios();
            peliculaMasLarga();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void crearPeliculas(){
        listaPeliculas = new ArrayList<>();

        ArrayList<Estudio> lista = new ArrayList<>();
        Pelicula ET = new Pelicula("ET",2000,90,"Ciencia ficción");
        listaPeliculas.add(ET);

        Pelicula Titanic = new Pelicula("Titanic",2001,180,"Suspense");
        listaPeliculas.add(Titanic);

        Pelicula ElSenorDeLosAnillos = new Pelicula("El Señor De Los Anillos",2002,133,"Ciencia ficción");
        listaPeliculas.add(ElSenorDeLosAnillos);

        Pelicula PiratasDelCaribe = new Pelicula("Piratas Del Caribe",2003,220,"Ciencia ficción");
        listaPeliculas.add(PiratasDelCaribe);

        Pelicula ElReyLeon = new Pelicula("El Rey Leon", 2004,97,"Animación");
        listaPeliculas.add(ElReyLeon);

    }
    public static void crearEstudios(){
        arrayEstudios[0] = new Estudio("Universal Pictures", "Los Angeles", "100 Universal City Plaza", "www.universalpictures.com", java.time.LocalDate.of(1912, 4, 30), "USA", 818-777-1000);
        arrayEstudios[1] = new Estudio("Warner Bros.", "Burbank", "4000 Warner Blvd", "www.warnerbros.com", java.time.LocalDate.of(1923, 4, 4), "USA", 818-954-3000);
        arrayEstudios[2] = new Estudio("Paramount Pictures", "Hollywood", "5555 Melrose Ave", "www.paramount.com", java.time.LocalDate.of(1912, 5, 8), "USA", 323-956-5000);
        arrayEstudios[3] = new Estudio("20th Century Fox", "Los Angeles", "10201 W Pico Blvd", "www.20thcenturyfox.com", java.time.LocalDate.of(1935, 5, 31), "USA", 310-369-1000);
        arrayEstudios[4] = new Estudio("Columbia Pictures", "Culver City", "10202 Washington Blvd", "www.sonypictures.com", java.time.LocalDate.of(1918, 6, 19), "USA", 310-244-4000);


    }
    public static void peliculaMasLarga(){

    }
}