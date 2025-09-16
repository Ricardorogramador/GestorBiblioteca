import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner entrada = new Scanner(System.in);
        int opcion;
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.persistenciaUsuarios = new PersistenciaTXT<>();
        biblioteca.persistenciaPrestamos = new PersistenciaTXT<>();
        biblioteca.persistenciaMaterial = new PersistenciaTXT<>();
        do {
            System.out.println("Bienvenido al gestor de biblioteca");
            System.out.println("1. Agregar material");
            System.out.println("2. Agregar usuario");
            System.out.println("3. Realizar un prestamo");
            System.out.println("4. Mostrar materiales");
            System.out.println("5. Mostrar usuarios");
            System.out.println("6. Guardar datos");
            System.out.println("7. Cargar datos");
            System.out.println("8. Salir");
            opcion = entrada.nextInt();
            switch(opcion){
                case 1:
                    biblioteca.agregarMaterial(null);
                break;
                case 2:
                    biblioteca.agregarUsuarios();
                break;
                case 3:
                    biblioteca.realizarPrestamo();
                break;
                case 4:
                    biblioteca.mostrarMateriales();
                break;
                case 5:
                    biblioteca.mostrarUsuarios();
                break;
                case 6:
                    biblioteca.guardarDatos();
                break;
                case 7:
                    biblioteca.cargarDatos();
            }
        }while(opcion != 8);
    }
}