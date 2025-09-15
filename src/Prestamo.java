public class Prestamo {
    Usuario usuario;
    MaterialBiblioteca material;
    private String fechaPrestamo;
    private  String fechaDevolucion;

    public Prestamo() {
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

}
