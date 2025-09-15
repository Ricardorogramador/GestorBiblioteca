public class Revista extends MaterialBiblioteca{
    private int numeroEdicion;
    private String periocidad;

    public Revista() {
    }

    public Revista(String codigo, String titulo, int anioPublicacion, int numeroEdicion, String periocidad) {
        super(codigo, titulo, anioPublicacion);
        this.numeroEdicion = numeroEdicion;
        this.periocidad = periocidad;
    }

    public int getNumeroEdicion() {
        return numeroEdicion;
    }

    public void setNumeroEdicion(int numeroEdicion) {
        this.numeroEdicion = numeroEdicion;
    }

    public String getPeriocidad() {
        return periocidad;
    }

    public void setPeriocidad(String periocidad) {
        this.periocidad = periocidad;
    }

    @Override
    void mostrarInformacion() {
        System.out.println("Codigo: " + getCodigo());
        System.out.println("Titulo: " + getTitulo());
        System.out.println("Año de publicacion: " + getAnioPublicacion());
        System.out.println("Edicion: " + getNumeroEdicion());
        System.out.println("Periocidad: " + getPeriocidad());
        System.out.println("-------------------------------------------");
    }
}
