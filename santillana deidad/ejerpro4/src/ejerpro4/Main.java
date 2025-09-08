package ejerpro4;

public class Main {
    public static void main(String[] args) {

        imprimible impresoraBasica = new impresora();
        impresoraBasica.imprimir();

        impresoramultifuncional multifuncional = new impresoramultifuncional();
        imprimible impresoraM = multifuncional;
        escaneable escanerM = multifuncional;

        impresoraM.imprimir();
        escanerM.escanear();
    }
}