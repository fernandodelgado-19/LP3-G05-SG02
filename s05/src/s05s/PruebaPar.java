package s05s;


public class PruebaPar {
    public static void main(String[] args) {
        // crea algunos pares para probar
        Par<String, Integer> par1 = new Par<>("Uno", 1);
        Par<String, Integer> par2 = new Par<>("Uno", 1);
        Par<String, Integer> par3 = new Par<>("Dos", 2);

        // prueba el método esIgual
        System.out.println("par1 es igual a par2: " + par1.esIgual(par2)); // Esperado: true
        System.out.println("par1 es igual a par3: " + par1.esIgual(par3)); // Esperado: false
    }
}
