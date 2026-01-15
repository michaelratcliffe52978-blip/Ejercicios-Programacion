import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private final static Scanner sc = new Scanner(System.in);
    private static ArrayList<Pelicula> listaPeliculas;
    private static Estudio[] arrayEstudios;


    public static void main(String[] args) {
        try {
            crearEstudios();
            crearPeliculas();
            peliculaMasLarga();
            mostrarEstudioConMasPeliculas();
        }catch (Exception e){
            System.out.println("ERROR: " + e.getMessage());
        }
    }
    public static void crearPeliculas(){
        listaPeliculas = new ArrayList<>();

        Pelicula ET = new Pelicula("ET",2000,90,"Ciencia ficción");
        ET.anadirEstudio(arrayEstudios[0]); //Universal
        listaPeliculas.add(ET);

        Pelicula Titanic = new Pelicula("Titanic",2001,180,"Suspense");
        Titanic.anadirEstudio(arrayEstudios[1]); //Warner Bros
        listaPeliculas.add(Titanic);

        Pelicula ElSenorDeLosAnillos = new Pelicula("El Señor De Los Anillos",2002,133,"Ciencia ficción");
        ElSenorDeLosAnillos.anadirEstudio(arrayEstudios[2]); //Paramount
        listaPeliculas.add(ElSenorDeLosAnillos);

        Pelicula PiratasDelCaribe = new Pelicula("Piratas Del Caribe",2003,220,"Ciencia ficción");
        PiratasDelCaribe.anadirEstudio(arrayEstudios[3]); //Fox
        PiratasDelCaribe.anadirEstudio(arrayEstudios[4]); //Columbia
        listaPeliculas.add(PiratasDelCaribe);

        Pelicula ElReyLeon = new Pelicula("El Rey Leon", 2004,97,"Animación");
        ElReyLeon.anadirEstudio(arrayEstudios[0]);
        listaPeliculas.add(ElReyLeon);

    }

    public static void crearEstudios(){
        arrayEstudios = new Estudio[5];
        arrayEstudios[0] = new Estudio("Universal Pictures", "Los Angeles", "100 Universal City Plaza", "www.universalpictures.com", java.time.LocalDate.of(1912, 4, 30), "USA", "818-777-1000");
        arrayEstudios[1] = new Estudio("Warner Bros.", "Burbank", "4000 Warner Blvd", "www.warnerbros.com", java.time.LocalDate.of(1923, 4, 4), "USA", "818-954-3000");
        arrayEstudios[2] = new Estudio("Paramount Pictures", "Hollywood", "5555 Melrose Ave", "www.paramount.com", java.time.LocalDate.of(1912, 5, 8), "USA", "323-956-5000");
        arrayEstudios[3] = new Estudio("20th Century Fox", "Los Angeles", "10201 W Pico Blvd", "www.20thcenturyfox.com", java.time.LocalDate.of(1935, 5, 31), "USA", "310-369-1000");
        arrayEstudios[4] = new Estudio("Columbia Pictures", "Culver City", "10202 Washington Blvd", "www.sonypictures.com", java.time.LocalDate.of(1918, 6, 19), "USA", "310-244-4000");


    }

    public static void peliculaMasLarga() {
        if (listaPeliculas.isEmpty()) {
            System.out.println("No hay películas.");
            return;
        }

        Pelicula masLarga = listaPeliculas.get(0);

        for (Pelicula p : listaPeliculas) {
            if (p.getDuracionM() > masLarga.getDuracionM()) {
                masLarga = p;
            }
        }
        System.out.println("Película más larga: " + masLarga.getTitulo());

        System.out.println("Estudios que la produjeron:");
        for (Estudio e : masLarga.getEstudios()) {
            System.out.println("- " + e.getNombre());
        }
    }
    public static void mostrarEstudioConMasPeliculas(){
        int max = 0;
        Estudio ganador = null;

        for (Estudio e : arrayEstudios) {
            int contador = 0;

            for (Pelicula p : listaPeliculas) {
                if (p.getEstudios().contains(e)) {
                    contador++;
                }
            }

            if (contador > max) {
                max = contador;
                ganador = e;
            }
        }

        System.out.print("Estudio con más películas producidas:");
        System.out.print(" "+ganador.getNombre() + " (" + max + " películas)");
    }

}