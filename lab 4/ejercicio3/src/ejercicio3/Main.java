package ejercicio3;

public class Main {
    public static void main(String[] args) {
        numero num = new numero();
        try {
            num.setValor(-10);
            System.out.println("Valor asignado: " + num.getValor());
        } catch (IllegalArgumentException e) {
            System.out.println("Error al asignar valor: " + e.getMessage());
        }

        try {
            num.setValor(25.7);
            System.out.println("Valor asignado: " + num.getValor());
        } catch (IllegalArgumentException e) {
            System.out.println("Error al asignar valor: " + e.getMessage());
        }
    }
}
