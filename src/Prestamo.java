import java.util.ArrayList;

public class Prestamo {
    Usuario usuario;
    MaterialBiblioteca material;
    private String fechaPrestamo;
    private  String fechaDevolucion;

    private String idUsuario;
    private String codigoMaterial;

    public Prestamo(String letter, Usuario name, MaterialBiblioteca code, String fechaPrestamo, String fechaDevolucion) {
        this.usuario = name;
        this.material = code;
        this.fechaDevolucion = fechaDevolucion;
        this.fechaPrestamo = fechaPrestamo;
        if (usuario != null) this.idUsuario = usuario.getId();
        if (material != null) this.codigoMaterial = material.getCodigo();
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

    public String getIdUsuario() {
        return idUsuario;
    }

    public String getCodigoMaterial() {
        return codigoMaterial;
    }

    @Override
    public String toString() {
        return  idUsuario + "," + codigoMaterial + "," + getFechaPrestamo() + "," + getFechaDevolucion();
    }
    public static Prestamo fromString(String linea){
        String[] partes =  linea.split(",");
        String idUsuario = partes[0];
        String codigoMaterial = partes[1];
        String fechaPrestamo = partes[2];
        String fechaDevolucion = partes[3];

        Prestamo p = new Prestamo(null, null, fechaPrestamo, fechaDevolucion);
        p.idUsuario = idUsuario;
        p.codigoMaterial = codigoMaterial;
        return p;
    }
    public void enlazar(ArrayList<Usuario> usuarios, ArrayList<MaterialBiblioteca> materiales){
        for(Usuario u : usuarios){
            if (u.getId().equals(this.idUsuario)){
                this.usuario = u;
                break;
            }
        }
        for (MaterialBiblioteca m : materiales){
            if (m.getCodigo().equals(this.codigoMaterial)){
                this.material = m;
                break;
            }
        }
    }
}
