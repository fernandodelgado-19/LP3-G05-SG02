package s05s;

public class Main {

    public static <F, S> void imprimirPar(Par<F, S> par) {
        System.out.println(par);
    }

    public static class Persona {
        private String nombre;

        public Persona(String nombre) {
            this.nombre = nombre;
        }

        public String toString() {
            return "Persona: " + nombre;
        }
    }

    public static void main(String[] args) {
        Par<String, Integer> par1 = new Par<>("Edad", 25);
        Par<Double, Boolean> par2 = new Par<>(3.14, true);
        Par<Persona, Integer> par3 = new Par<>(new Persona("Cristian"), 123);

        imprimirPar(par1);
        imprimirPar(par2);
        imprimirPar(par3);
    }
}
