package Ejercicio1;

import java.io.IOException;
import java.io.InputStreamReader;
class ExcepcionVocal extends Exception {
    private static final long serialVersionUID = 1L;
    public ExcepcionVocal(String msg) { super(msg); }
}

class ExcepcionNumero extends Exception {
    private static final long serialVersionUID = 1L;
    public ExcepcionNumero(String msg) { super(msg); }
}

class ExcepcionBlanco extends Exception {
    private static final long serialVersionUID = 1L;
    public ExcepcionBlanco(String msg) { super(msg); }
}

class ExcepcionSalida extends Exception {
    private static final long serialVersionUID = 1L;
    public ExcepcionSalida(String msg) { super(msg); }
}

class LeerEntrada {
    private InputStreamReader entrada = new InputStreamReader(System.in);

    public char getChar() throws IOException {
        return (char) entrada.read(); 
    }
}
