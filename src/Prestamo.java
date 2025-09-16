public class Prestamo {
    Usuario usuario;
    MaterialBiblioteca material;
    private String fechaPrestamo;
    private  String fechaDevolucion;

    public Prestamo(String parte, String s, String fechaPrestamo, String fechaDevolucion) {
    }

    public Prestamo(Usuario usuario, MaterialBiblioteca material, String fechaPrestamo, String fechaDevolucion) {
        this.usuario = usuario;
        this.material = material;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public MaterialBiblioteca getMaterial() {
        return material;
    }

    public String getFechaPrestamo() {
        return fechaPrestamo;
    }

    public String getFechaDevolucion() {
        return fechaDevolucion;
    }

    @Override
    public String toString() {
        return "P," + getUsuario().getNombre() + "," + getMaterial().getCodigo() + "," + getFechaPrestamo() + "," + getFechaDevolucion();
    }
    public static Prestamo fromString(String linea){
        String[] partes =  linea.split(",");
        return new Prestamo(partes[0], partes[1], partes[2], partes[4]);
    }
}
