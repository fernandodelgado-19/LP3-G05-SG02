package ejerpro1;

public class Calculadora{

    public double calcularPagoMensual(Empleado empleado) {

        return empleado.getSalario() / 12;
    }
}