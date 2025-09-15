import java.util.ArrayList;

public class Usuario {
    private String id;
    private String nombre;
    private ArrayList<Prestamo> prestamos = new ArrayList<>();

    public Usuario() {
    }

    public Usuario(String id, String nombre, ArrayList<Prestamo> prestamos) {
        this.id = id;
        this.nombre = nombre;
        this.prestamos = prestamos;
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

    void agregarPrestamo(Prestamo p){}

    void mostrarPrestamo(){}
}
