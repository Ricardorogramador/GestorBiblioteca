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

    public Libro(String letra, String cod, String title, int publicacion, String autr, int numberPage) {
        super(cod, title, publicacion);
        this.autor = autr;
        this.numeroPaginas = numberPage;
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

    @Override
    public String toString() {
        return  "L," + getCodigo() + "," + getTitulo() + "," + getAnioPublicacion() + "," + autor + "," + numeroPaginas;
    }
    public static Libro fromString(String linea){
        String[] partes =  linea.split(",");
        // MaterialBiblioteca{codigo='1', titulo='Principito',2000
        return new Libro(partes[0],partes[1], partes[2], Integer.parseInt(partes[3]), partes[4], Integer.parseInt(partes[5]));
    }
}
