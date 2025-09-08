package ejerpro1;

public class Main {
    public static void main(String[] args) {
        Empleado empleado1 = new Empleado("Juan Pérez", 36000, "Finanzas");
        Calculadora calculadora = new Calculadora();

        double pagoMensual = calculadora.calcularPagoMensual(empleado1);
        System.out.println("El pago mensual de " + empleado1.getNombre() + " es: " + pagoMensual);
    }
}