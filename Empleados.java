 import java.util.Scanner;

public class Empleados {

    String nombre;
    double salarioBase;
    int horasExtras;

    public Empleados(String nombre, int horasExtras) {
        this.nombre = nombre;
        this.salarioBase = 460.0;
        this.horasExtras = horasExtras;
    }

    public double calcularSalarioTotal() {
        double valorHorasExtras = horasExtras * 10.0;
        return salarioBase + valorHorasExtras;
    }

    public void mostrarDatos() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Salario base: $" + salarioBase);
        System.out.println("Horas extras: " + horasExtras);
        System.out.println("Salario total calculado: $" + calcularSalarioTotal());
        System.out.println("----------------------------------------");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el numero N de empleados a registrar: ");
        int n = sc.nextInt();
        sc.nextLine();

        if (n <= 0) {
            System.out.println("La cantidad de empleados debe ser mayor a cero.");
            sc.close();
            return;
        }

        Empleados[] empleados = new Empleados[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Registro del Empleado " + (i + 1) + " ---");

            System.out.print("Ingrese el nombre: ");
            String nombre = sc.nextLine();

            System.out.print("Ingrese la cantidad de horas extras: ");
            int horasExtras = sc.nextInt();
            sc.nextLine();

            empleados[i] = new Empleados(nombre, horasExtras);
        }

        System.out.println("\n========================================");
        System.out.println("    REPORTE GENERAL DE EMPLEADOS");
        System.out.println("========================================");

        for (int i = 0; i < n; i++) {
            System.out.println("Empleado " + (i + 1) + ":");
            empleados[i].mostrarDatos();
        }

        sc.close();
    }
}