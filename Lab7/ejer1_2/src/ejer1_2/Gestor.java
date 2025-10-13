package ejer1_2;

import java.io.*;
import java.util.*;

class Gestor {
    private static final String ARCHIVO = "personajes.txt";
    private List<Personaje> personajes = new ArrayList<>();

    public Gestor() {
        cargarPersonajes();
    }


    private void cargarPersonajes() {
        personajes.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                personajes.add(Personaje.fromString(linea));
            }
        } catch (IOException e) {
            System.out.println("Archivo no encontrado. Se creará al guardar.");
        }
    }

    private void guardarPersonajes() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(ARCHIVO))) {
            for (Personaje p : personajes) {
                pw.println(p.toString());
            }
        } catch (IOException e) {
            System.out.println("Error al guardar los personajes.");
        }
    }

    public void agregar(Personaje p) {
        for (Personaje per : personajes) {
            if (per.getNombre().equalsIgnoreCase(p.getNombre())) {
                System.out.println("El personaje ya existe.");
                return;
            }
        }
        personajes.add(p);
        guardarPersonajes();
        System.out.println("Personaje agregado correctamente.");
    }

    public void mostrar() {
        if (personajes.isEmpty()) {
            System.out.println("📭 No hay personajes.");
            return;
        }
        System.out.println("=== LISTA DE PERSONAJES ===");
        personajes.forEach(System.out::println);
    }

    public void modificar(String nombre, int vida, int ataque, int defensa, int alcance) {
        for (Personaje p : personajes) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                p.setVida(vida);
                p.setAtaque(ataque);
                p.setDefensa(defensa);
                p.setAlcance(alcance);
                guardarPersonajes();
                System.out.println("Personaje modificado.");
                return;
            }
        }
        System.out.println("No se encontró el personaje.");
    }

    public void eliminar(String nombre) {
        boolean eliminado = personajes.removeIf(p -> p.getNombre().equalsIgnoreCase(nombre));
        if (eliminado) {
            guardarPersonajes();
            System.out.println("Personaje eliminado.");
        } else {
            System.out.println("No se encontró el personaje.");
        }
    }

    public void filtrarPorVida() {
        personajes.stream()
                .sorted(Comparator.comparingInt(Personaje::getVida).reversed())
                .forEach(System.out::println);
    }

    public void estadisticas() {
        double promedioVida = personajes.stream().mapToInt(Personaje::getVida).average().orElse(0);
        double promedioAtaque = personajes.stream().mapToInt(Personaje::getAtaque).average().orElse(0);
        System.out.println("📊 Total personajes: " + personajes.size());
        System.out.println("Promedio de vida: " + promedioVida);
        System.out.println("Promedio de ataque: " + promedioAtaque);
    }
}
