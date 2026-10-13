package ejercicio1;

import java.util.Scanner;

class CuentaBancaria {
    String nombre;
    String apellido;
    String tipoCuenta;
    double saldo;

    public CuentaBancaria(String nombre, String apellido, String tipoCuenta, double saldoInicial) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoCuenta = tipoCuenta;
        this.saldo = saldoInicial;
    }

    public void depositar(double monto) {
        saldo += monto;
        System.out.println("Has depositado: $" + monto);
    }

    public void retirar(double monto) {
        if (monto <= saldo) {
            saldo -= monto;
            System.out.println("Has retirado: $" + monto);
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    public void mostrarSaldo() {
        System.out.println("Titular: " + nombre + " " + apellido);
        System.out.println("Tipo de Cuenta: " + tipoCuenta);
        System.out.println("Saldo Actual: $" + saldo);
        System.out.println("---------------------------");
    }
}

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Ingrese apellido: ");
        String apellido = sc.nextLine();

        System.out.print("Ingrese tipo de cuenta: ");
        String tipoCuenta = sc.nextLine();

        System.out.print("Ingrese saldo inicial: ");
        double saldoInicial = sc.nextDouble();

        CuentaBancaria cuenta = new CuentaBancaria(nombre, apellido, tipoCuenta, saldoInicial);

        System.out.println("\n--- ESTADO INICIAL ---");
        cuenta.mostrarSaldo();

        System.out.print("Monto a depositar: ");
        double dep = sc.nextDouble();
        cuenta.depositar(dep);

        System.out.print("Monto a retirar: ");
        double ret = sc.nextDouble();
        cuenta.retirar(ret);

        System.out.println("\n--- ESTADO FINAL ---");
        cuenta.mostrarSaldo();

        sc.close();
    }
}