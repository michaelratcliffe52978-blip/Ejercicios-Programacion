import Libreria.Alumno;
import Libreria.Autor;
import Libreria.Libro;

import java.util.Scanner;

public class Main {
    private final static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Libro l1 = new Libro("El despertar","Editorial 1",189);
        Libro l2 = new Libro("El amanecer","Editorial 2",234);
        Libro l3 = new Libro("El despegar","Editorial 3",159);
        Libro l4 = new Libro("El arquero","Editorial 2",360);

        Alumno alum1 = new Alumno("Alex", "53456789A",java.time.LocalDate.of(2000,12,6),"España");
        Alumno alum2 = new Alumno("Lolita", "23456789L",java.time.LocalDate.of(2005,6,12),"España");
        Alumno alum3 = new Alumno("Paula", "12345678P",java.time.LocalDate.of(2010,8,3),"España");
        Alumno alum4 = new Alumno("Asier", "45678912K",java.time.LocalDate.of(2015,3,9),"Africa");

        Autor aut1 = new Autor("Cervantes",java.time.LocalDate.of(1950,12,2),"España");
        Autor aut2 = new Autor("Miguel",java.time.LocalDate.of(1955,1,30),"España");
        Autor aut3 = new Autor("Federico",java.time.LocalDate.of(1930,6,6),"España");

    }
}