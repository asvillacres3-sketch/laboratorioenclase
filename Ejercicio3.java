// gestion de prestamo de un libro
import java.util.Scanner;

class Libro {

    String titulo;
    String autor;
    int paginas;
    String estado;

    public Libro(String titulo, String autor, int paginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.paginas = paginas;
        this.estado = "disponible";
    }

    public void prestar() {
        if (estado.equalsIgnoreCase("disponible")) {
            estado = "prestado";
            System.out.println("El libro ha sido prestado.");
        } else {
            System.out.println("El libro no esta disponible.");
        }
    }

    public void devolver() {
        if (estado.equalsIgnoreCase("prestado")) {
            estado = "disponible";
            System.out.println("El libro ha sido devuelto.");
        } else {
            System.out.println("El libro no estaba prestado.");
        }
    }

    public void mostrarInfo() {
        System.out.println("Titulo: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Paginas: " + paginas);
        System.out.println("Estado: " + estado);
        System.out.println("---------------------------");
    }
}

public class Ejercicio3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de libros: ");
        int n = sc.nextInt();
        sc.nextLine();

        if (n <= 0) {
            System.out.println("La cantidad debe ser mayor que cero.");
            sc.close();
            return;
        }

        Libro[] libros = new Libro[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nIngrese los datos del libro " + (i + 1));

            System.out.print("Titulo: ");
            String titulo = sc.nextLine();

            System.out.print("Autor: ");
            String autor = sc.nextLine();

            System.out.print("Numero de paginas: ");
            int paginas = sc.nextInt();
            sc.nextLine();

            libros[i] = new Libro(titulo, autor, paginas);
        }

        int opcion;

        do {
            System.out.println("\n--- MENU DE LA BIBLIOTECA ---");
            System.out.println("1. Mostrar todos los libros");
            System.out.println("2. Prestar un libro");
            System.out.println("3. Devolver un libro");
            System.out.println("4. Mostrar informacion de un libro especifico");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    for (int i = 0; i < n; i++) {
                        System.out.println("\nLibro " + (i + 1));
                        libros[i].mostrarInfo();
                    }
                    break;

                case 2:
                    System.out.print("Ingrese el numero del libro (1-" + n + "): ");
                    int numPrestar = sc.nextInt();

                    if (numPrestar >= 1 && numPrestar <= n) {
                        libros[numPrestar - 1].prestar();
                    } else {
                        System.out.println("Numero de libro no valido.");
                    }
                    break;

                case 3:
                    System.out.print("Ingrese el numero del libro (1-" + n + "): ");
                    int numDevolver = sc.nextInt();

                    if (numDevolver >= 1 && numDevolver <= n) {
                        libros[numDevolver - 1].devolver();
                    } else {
                        System.out.println("Numero de libro no valido.");
                    }
                    break;

                case 4:
                    System.out.print("Ingrese el numero del libro a consultar (1-" + n + "): ");
                    int numInfo = sc.nextInt();

                    if (numInfo >= 1 && numInfo <= n) {
                        System.out.println("\nLibro " + numInfo);
                        libros[numInfo - 1].mostrarInfo();
                    } else {
                        System.out.println("Numero de libro no valido.");
                    }
                    break;

                case 5:
                    System.out.println("Programa finalizado.");
                    break;

                default:
                    System.out.println("Opcion no valida.");
                    break;
            }

        } while (opcion != 5);

        sc.close();
    }
}