package Ejertcicio2;

class DivisionPorCeroException extends Exception {
    private static final long serialVersionUID = 1L;
    public DivisionPorCeroException(String msg) { super(msg); }
}

class Calculadora {
    public double sumar(double a, double b) { return a + b; }
    public double restar(double a, double b) { return a - b; }
    public double multiplicar(double a, double b) { return a * b; }

    public double dividir(double a, double b) throws DivisionPorCeroException {
        if (b == 0) {
            throw new DivisionPorCeroException("Error: división por cero no permitida");
        }
        return a / b;
    }
}

