import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int opcion;
        Biblioteca biblioteca = new Biblioteca();

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
        }while(opcion != 8);
    }
}