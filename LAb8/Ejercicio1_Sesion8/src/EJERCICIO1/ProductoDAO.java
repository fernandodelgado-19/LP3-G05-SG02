package EJERCICIO1;
import java.sql.*;
public class ProductoDAO {
    Connection con = Conexion.conectar();

    public ProductoDAO() {
        try {
            String sql = "CREATE TABLE IF NOT EXISTS productos(" +
                         "id INTEGER PRIMARY KEY, " +
                         "nombre TEXT, " +
                         "precio REAL, " +
                         "stock INTEGER)";
            con.createStatement().execute(sql);
        } catch (Exception e) {
            System.out.println("Error creando tabla");
        }
    }
    public void insertar(Producto p) {
        try {
            PreparedStatement st = con.prepareStatement("INSERT INTO productos VALUES(?,?,?,?)");
            st.setInt(1, p.id);
            st.setString(2, p.nombre);
            st.setDouble(3, p.precio);
            st.setInt(4, p.stock);
            st.executeUpdate();
            System.out.println("Producto insertado correctamente");
        } catch (Exception e) {
            e.printStackTrace(); 
        }
    }
    public void mostrar() {
        try {
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM productos");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getDouble(3) + " " + rs.getInt(4));
            }
        } catch (Exception e) {
            System.out.println("Error al mostrar");
        }
    }
    public void actualizar(int id, double precio) {
        try {
            PreparedStatement st = con.prepareStatement("UPDATE productos SET precio=? WHERE id=?");
            st.setDouble(1, precio);
            st.setInt(2, id);
            st.executeUpdate();
            System.out.println("Producto actualizado correctamente");
        } catch (Exception e) {
            System.out.println("Error al actualizar");
        }
    }
    public void borrar(int id) {
        try {
            PreparedStatement st = con.prepareStatement("DELETE FROM productos WHERE id=?");
            st.setInt(1, id);
            st.executeUpdate();
            System.out.println("Producto eliminado correctamente");
        } catch (Exception e) {
            System.out.println("Error al borrar");
        }
    }
}
