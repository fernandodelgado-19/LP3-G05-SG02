package EJERCICIO1;

import java.sql.*;

public class Conexion {
    public static Connection conectar() {
        try {
            return DriverManager.getConnection("jdbc:sqlite:tienda.db");
        } catch (Exception e) {
            System.out.println("Error en conexión");
            return null;
        }
    }
}
