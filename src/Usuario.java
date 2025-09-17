import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String id;
    private String nombre;
    private List<Prestamo> prestamos = new ArrayList<>();

    public Usuario() {
    }

    public Usuario(String id, String nombre, ArrayList<Prestamo> prestamos) {
        this.id = id;
        this.nombre = nombre;
        this.prestamos = prestamos;
    }

    public Usuario(String id, String nombre){
        this.id = id;
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    void agregarPrestamo(Prestamo p){
        prestamos.add(p);
    }

    String mostrarPrestamo(){
        StringBuilder sb = new StringBuilder();
        for (Prestamo p : prestamos){
            String line = String.format("Code: %s, StartDate: %s, EndDate: %s", p.material.getCodigo(), p.getFechaPrestamo(), p.getFechaDevolucion());
            sb.append(line);
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return id + "," + nombre + "," + mostrarPrestamo();
    }
    public static Usuario fromString(String linea){
        String[] partes = linea.split(",");
        return new Usuario(partes[0], partes[1]);
    }
}
