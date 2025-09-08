package ejerpro4;

public class impresoramultifuncional implements imprimible, escaneable {

    public void imprimir() {
        System.out.println("Imprimiendo documento (multifuncional)...");
    }

    public void escanear() {
        System.out.println("Escaneando documento (multifuncional)...");
    }
}
