import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
 
public class Main {
 
    public static void main(String[] args) {
 
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        int opcion = 0;
 
        // Menu repetitivo - no para hasta que el usuario elija 6
        while (opcion != 6) {
 
            System.out.println("\n--- MENU BIBLIOTECA ---");
            System.out.println("1. Ver catalogo");
            System.out.println("2. Buscar libro por ID");
            System.out.println("3. Prestar libro");
            System.out.println("4. Devolver libro");
            System.out.println("5. Ver inventario disponible");
            System.out.println("6. Salir");
            System.out.print("Elige una opcion: ");
 
            opcion = scanner.nextInt();
 
            if (opcion == 1) {
                biblioteca.consultarLibros();
 
            } else if (opcion == 2) {
                System.out.print("ID del libro: ");
                int id = scanner.nextInt();
                Libro libro = biblioteca.consultarLibro(id);
                if (libro != null) {
                    libro.mostrarInfo();
                } else {
                    System.out.println("Libro no encontrado");
                }
 
            } else if (opcion == 3) {
                System.out.print("ID del libro a prestar: ");
                int id = scanner.nextInt();
                biblioteca.prestarLibros(id);
 
            } else if (opcion == 4) {
                System.out.print("ID del libro a devolver: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Fecha limite (dd/MM/yyyy): ");
                String fechaTexto = scanner.nextLine();
                try {
                    LocalDate fechaLimite = LocalDate.parse(fechaTexto, formato);
                    biblioteca.recibirDevolucion(id, fechaLimite);
                } catch (DateTimeParseException e) {
                    System.out.println("Formato de fecha incorrecto, usa dd/MM/yyyy");
                }
 
            } else if (opcion == 5) {
                biblioteca.verificarInventario();
 
            } else if (opcion == 6) {
                System.out.println("Hasta luego!");
 
            } else {
                System.out.println("Opcion no valida");
            }
        }
 
        scanner.close();
    }
}
 