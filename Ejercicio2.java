package ejercicio2;
import java.util.Scanner;

class Vehiculo {

    String marca;
    String modelo;
    String estado; 
    int anioFab;
    boolean matriculado; 

    public Vehiculo(String marca, String modelo, String estado, int anioFab) {
        this.marca = marca;
        this.modelo = modelo;
        this.estado = estado;
        this.anioFab = anioFab;
        this.matriculado = false; 
    }

  
    public void revisionVehicular() {
        int anioActual = 2026;
        int antiguedad = anioActual - anioFab;

        
        if (antiguedad > 30) {
            this.estado = "usado malo";
            System.out.println("Revision realizada: El vehiculo tiene mas de 30 anos. Estado degradado a 'usado malo'.");
        } else {
            System.out.println("Revision realizada: El vehiculo conserva su estado '" + estado + "'.");
        }
    }

    public void matricular() {
        if (!estado.equalsIgnoreCase("usado malo")) {
            matriculado = true;
            System.out.println("Exito: El vehiculo " + marca + " " + modelo + " ha sido matriculado correctamente.");
        } else {
            System.out.println("Error: No se puede matricular el vehiculo porque su estado es 'usado malo'.");
        }
    }

    public void mostrarDatos() {
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Ano de Fabricacion: " + anioFab);
        System.out.println("Estado: " + estado);
        System.out.println("Matriculado: " + (matriculado ? "SI" : "NO"));
        System.out.println("---------------------------");
    }
}

public class Ejercicio2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el numero N de vehiculos a registrar: ");
        int n = sc.nextInt();
        sc.nextLine();

        if (n <= 0) {
            System.out.println("La cantidad debe ser mayor que cero.");
            sc.close();
            return;
        }

        Vehiculo[] vehiculos = new Vehiculo[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Registro del vehiculo " + (i + 1) + " ---");

            System.out.print("Marca: ");
            String marca = sc.nextLine();

            System.out.print("Modelo: ");
            String modelo = sc.nextLine();

            System.out.print("Estado (nuevo / seminuevo / usado bueno / usado malo): ");
            String estado = sc.nextLine();

            System.out.print("Ano de fabricacion: ");
            int anioFab = sc.nextInt();
            sc.nextLine();

            vehiculos[i] = new Vehiculo(marca, modelo, estado, anioFab);
        }

        int opcion;

        do {
            System.out.println("\n--- MENU GESTION VEHICULAR ---");
            System.out.println("1. Mostrar todos los vehiculos");
            System.out.println("2. Realizar revision vehicular");
            System.out.println("3. Matricular vehiculo");
            System.out.println("4. Mostrar datos de un vehiculo especifico");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    for (int i = 0; i < n; i++) {
                        System.out.println("\nVehiculo " + (i + 1) + ":");
                        vehiculos[i].mostrarDatos();
                    }
                    break;

                case 2:
                    System.out.print("Ingrese el numero del vehiculo a revisar (1-" + n + "): ");
                    int numRev = sc.nextInt();

                    if (numRev >= 1 && numRev <= n) {
                        vehiculos[numRev - 1].revisionVehicular();
                    } else {
                        System.out.println("Numero de vehiculo no valido.");
                    }
                    break;

                case 3:
                    System.out.print("Ingrese el numero del vehiculo a matricular (1-" + n + "): ");
                    int numMat = sc.nextInt();

                    if (numMat >= 1 && numMat <= n) {
                        vehiculos[numMat - 1].matricular();
                    } else {
                        System.out.println("Numero de vehiculo no valido.");
                    }
                    break;

                case 4:
                    System.out.print("Ingrese el numero del vehiculo a consultar (1-" + n + "): ");
                    int numInfo = sc.nextInt();

                    if (numInfo >= 1 && numInfo <= n) {
                        System.out.println("\nVehiculo " + numInfo + ":");
                        vehiculos[numInfo - 1].mostrarDatos();
                    } else {
                        System.out.println("Numero de vehiculo no valido.");
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
