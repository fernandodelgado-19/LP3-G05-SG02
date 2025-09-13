package Ejercicio1;

public class Ejercicio1 {
    private LeerEntrada lector = new LeerEntrada();
    private char ultimoChar;

    public void procesar() throws Exception {
        ultimoChar = lector.getChar();

        if ("aeiouAEIOU".indexOf(ultimoChar) != -1) {
            throw new ExcepcionVocal("Se ingresó una vocal: " + ultimoChar);
        } else if (Character.isDigit(ultimoChar)) {
            throw new ExcepcionNumero("Se ingresó un número: " + ultimoChar);
        } else if (Character.isWhitespace(ultimoChar)) {
            throw new ExcepcionBlanco("Se ingresó un espacio en blanco");
        } else if (ultimoChar == 'x' || ultimoChar == 'X') {
            throw new ExcepcionSalida("Carácter de salida detectado");
        } else {
            System.out.println("Carácter válido: " + ultimoChar);
        }
    }

    public static void main(String[] args) {
        Ejercicio1 app = new Ejercicio1();
        System.out.println("Ingrese caracteres (x para salir):");

        while (true) {
            try {
                app.procesar();
            } catch (ExcepcionVocal | ExcepcionNumero | ExcepcionBlanco e) {
                System.out.println(e.getMessage());
            } catch (ExcepcionSalida e) {
                System.out.println(e.getMessage());
                break; 
            } catch (Exception e) {
                System.out.println("Error inesperado: " + e.getMessage());
            }
        }
    }
}
