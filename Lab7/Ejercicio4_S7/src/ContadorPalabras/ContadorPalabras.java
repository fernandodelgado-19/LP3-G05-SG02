package ContadorPalabras;
import java.io.*;
import java.util.*;
import javax.swing.*;
public class ContadorPalabras {
    public static void main(String[] args) {
        JFileChooser fc = new JFileChooser();
        if (fc.showOpenDialog(null) != JFileChooser.APPROVE_OPTION) return;
        File archivo = fc.getSelectedFile();
        if (!archivo.exists()) {
            JOptionPane.showMessageDialog(null, "Archivo no encontrado");
            return;
        }
        int lineas = 0, palabras = 0, caracteres = 0;
        Map<String, Integer> conteo = new HashMap<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas++;
                caracteres += linea.length();
                String[] arr = linea.split("\\W+");
                for (String p : arr)
                    if (!p.isEmpty()) {
                        palabras++;
                        p = p.toLowerCase();
                        conteo.put(p, conteo.getOrDefault(p, 0) + 1);
                    }
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }
        System.out.println("Líneas: " + lineas);
        System.out.println("Palabras: " + palabras);
        System.out.println("Caracteres: " + caracteres);
        System.out.println("Promedio palabras/línea: " + (lineas > 0 ? (palabras / (double) lineas) : 0));
        
        int max = Collections.max(conteo.values());
        System.out.println("\nPalabras más frecuentes:");
        conteo.forEach((p, n) -> { if (n == max) System.out.println(p + " -> " + n); });
    }
}