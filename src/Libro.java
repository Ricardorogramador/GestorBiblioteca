public class Libro extends MaterialBiblioteca{
    private String autor;
    private int numeroPaginas;

    public Libro() {
    }

    public Libro(String codigo, String titulo, int anioPublicacion, String autor, int numeroPaginas) {
        super(codigo, titulo, anioPublicacion);
        this.autor = autor;
        this.numeroPaginas = numeroPaginas;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    @Override
    void mostrarInformacion() {
        System.out.println("Codigo: " + getCodigo());
        System.out.println("Titulo: " + getTitulo());
        System.out.println("Año de publicacion: " + getAnioPublicacion());
        System.out.println("Autor: " + getAutor());
        System.out.println("Numero de paginas: " + getNumeroPaginas());
        System.out.println("-------------------------------------------------");
    }
}
