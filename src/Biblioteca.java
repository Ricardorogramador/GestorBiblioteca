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

    void agregarMaterial(MaterialBiblioteca m){
        MaterialBiblioteca nuevomaterial = null;
        String codigo, titulo, autor, periocidad;
        int aniopublicacion, numeroPaginas, numeroEdicion;
        System.out.println("Agregar un material");
        System.out.println("Elige el tipo de material");
        System.out.println("1. Libro");
        System.out.println("2. Revista");
        opcion = entrada.nextInt();
        System.out.println("Ingrese el codigo:");
        codigo = entrada.next();
        System.out.println("Ingresar el titulo del material");
        titulo = entrada.next();
        System.out.println("Ingresar el año de publicacion");
        aniopublicacion = entrada.nextInt();
        switch (opcion){
            case 1:
                if (m instanceof Libro){
                    System.out.println("Ingrese el nombre del autor");
                    autor = entrada.next();
                    System.out.println("Ingrese el numero de paginas");
                    numeroPaginas = entrada.nextInt();
                    nuevomaterial = new Libro(codigo,titulo,aniopublicacion,autor,numeroPaginas);
                }
                break;
            case 2:
                if (m instanceof Revista){
                    System.out.println("Ingrese el numero de edicion");
                    numeroEdicion = entrada.nextInt();
                    System.out.println("Periocidad");
                    periocidad = entrada.next();
                    nuevomaterial = new Revista(codigo,titulo,aniopublicacion,numeroEdicion,periocidad);
                }
                break;
        }
        if (nuevomaterial != null){
            materiales.add(nuevomaterial);
            System.out.println("Material agregado a la base de datos");
        } else {
            System.out.println("Valor nulo, volver a intentar");
        }
    }

    void agregarUsuarios(Usuario u){
        Usuario nuevoUsuario = null;
        String id, nombre;
        System.out.println("Ingrese el id del usuario");
        id = entrada.next();
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

    void realizarPrestamo(String idUsuario, String codigoMaterial){
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
        persistencia.cargar("materiales.txt");
        persistencia.cargar("usuarios.txt");
        persistencia.cargar("prestamos.txt");
    }
}
