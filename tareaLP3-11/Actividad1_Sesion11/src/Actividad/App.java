package Actividad;

public class App {
    public static void main(String[] args) {

        System.out.println("=== OBSERVER ===");
        Notificador n = new Notificador();
        n.add(new Usuario("Ana"));
        n.add(new Usuario("Luis"));
        n.enviar("NUEVA PROMOCIÓN!");

        System.out.println("\n=== STRATEGY ===");
        Calculadora calc = new Calculadora();
        calc.set(new P10());
        System.out.println("Precio final: " + calc.calcular(100));

        System.out.println("\n=== COMMAND ===");
        TV tv = new TV();
        Control c = new Control();
        c.set(new CEnc(tv)); c.press();
        c.set(new CUp(tv));  c.press();
        c.set(new CDown(tv)); c.press();
        c.set(new CCanal(tv)); c.press();
        c.set(new COff(tv)); c.press();

        System.out.println("\n=== APP COMBINADA ===");
        Sistema s = new Sistema();
        s.promo10();
        s.usarTV();
        s.comprar(200);
        s.promo50();
        s.comprar(300);
    }
}