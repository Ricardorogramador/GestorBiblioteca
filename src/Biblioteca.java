import java.io.IOException;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {
    ArrayList<MaterialBiblioteca> materiales;
    ArrayList<Usuario> usuarios;
    ArrayList<Prestamo> prestamos;
    IPersistencia persistencia;
    Scanner entrada = new Scanner(System.in);
    int opcion;

    public Biblioteca(){
        materiales = new ArrayList<>();
        usuarios = new ArrayList<>();
        prestamos = new ArrayList<>();
    }
    void agregarMaterial(MaterialBiblioteca m){
        int opcion2;
        MaterialBiblioteca nuevomaterial = null;
        String codigo, titulo, autor, periocidad;
        int aniopublicacion, numeroPaginas, numeroEdicion;
        System.out.println("Agregar un material");
        System.out.println("Elige el tipo de material");
        System.out.println("1. Libro");
        System.out.println("2. Revista");
        opcion2 = entrada.nextInt();
        System.out.println("Ingrese el codigo:");
        codigo = entrada.next();
        boolean exist = false;
        for (MaterialBiblioteca m1 : materiales){
            if (m1.getCodigo().equals(codigo)){
                exist = true;
                break;
            }
        }
        if (exist){
            System.out.println("Ya existe un material con ese codigo");
        } else {
            System.out.println("Ingresar el titulo del material");
            titulo = entrada.next();
            System.out.println("Ingresar el año de publicacion");
            aniopublicacion = entrada.nextInt();
            entrada.nextLine();
            switch (opcion2){
                case 1:
                    System.out.println("Ingrese el nombre del autor");
                    autor = entrada.next();
                    System.out.println("Ingrese el numero de paginas");
                    numeroPaginas = entrada.nextInt();
                    nuevomaterial = new Libro(codigo,titulo,aniopublicacion,autor,numeroPaginas);
                    break;
                case 2:
                    System.out.println("Ingrese el numero de edicion");
                    numeroEdicion = entrada.nextInt();
                    System.out.println("Periocidad");
                    periocidad = entrada.next();
                    nuevomaterial = new Revista(codigo,titulo,aniopublicacion,numeroEdicion,periocidad);
                    break;
            }
            if (nuevomaterial != null){
                materiales.add(nuevomaterial);
                System.out.println("Material agregado a la base de datos");
            } else {
                System.out.println("Valor nulo, volver a intentar");
            }
        }
    }

    void agregarUsuarios(){
        Usuario nuevoUsuario = null;
        String id, nombre;
        System.out.println("Ingrese el id del usuario");
        id = entrada.next();
        boolean exist = false;
        for (Usuario u1 : usuarios){
            if (u1.getId().equals(id)){
                exist = true;
                break;
            }
        }
        if (exist){
            System.out.println("Ya existe un usuario con ese ID");
        } else {
            System.out.println("Ingrese el nombre del usuario");
            nombre = entrada.next();
            nuevoUsuario = new Usuario(id,nombre , prestamos);
            if (nuevoUsuario != null){
                usuarios.add(nuevoUsuario);
                System.out.println("Usuario agregado a la base de datos");
            }  else {
                System.out.println("Hubo un error al introducir los datos, vuelvalo a intentar");
            }
        }
    }

    void realizarPrestamo(){
        String idUsuario, codigoMaterial;
        System.out.println("Ingrese el ID del usuario");
        idUsuario = entrada.next();
        System.out.println("Ingresa el codigo del material");
        codigoMaterial = entrada.next();
        for (Usuario u : usuarios){
            for (MaterialBiblioteca m : materiales){
                if (u.getId().equals(idUsuario) && m.getCodigo().equals(codigoMaterial)){
                    LocalDate fecha = LocalDate.now();
                    LocalDate devolucion = fecha.plusDays(7);
                    Prestamo p = new Prestamo(u, m, fecha.toString(), devolucion.toString());

                    prestamos.add(p);
                    System.out.println("Prestamos realizado con exito");
                    return;
                }
            }
        }
    }
    void mostrarMateriales(){
        for (MaterialBiblioteca m : materiales){
            m.mostrarInformacion();
        }
    }
    void mostrarUsuarios(){
        for (Usuario u : usuarios){
            System.out.println(u);
        }
    }
    void guardarDatos() throws IOException {
        persistencia.guardar(materiales, "materiales.txt");
        persistencia.guardar(usuarios, "usuarios.txt");
        persistencia.guardar(prestamos, "prestamos.txt");
    }
    void cargarDatos() throws IOException{
      materiales = (ArrayList<MaterialBiblioteca>)  persistencia.cargar("materiales.txt");
      usuarios = (ArrayList<Usuario>)  persistencia.cargar("usuarios.txt");
      prestamos = (ArrayList<Prestamo>)  persistencia.cargar("prestamos.txt");
    }
}
