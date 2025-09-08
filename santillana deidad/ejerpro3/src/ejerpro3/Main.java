package ejerpro3;

public class Main {
    public static void main(String[] args) {
        vehiculo v1 = new coche();
        vehiculo v2 = new bicicleta();

        v1.acelerar();
        v2.acelerar();
    }
}