import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Biblioteca {


    Libro[] libros = new Libro[10];
    int totalLibros = 5;


    public Biblioteca() {
        libros[0] = new Libro(1, "Ella: o cómo aprendí a amar a un demonio ");
        libros[1] = new Libro(2, "Amanecer de fuego");
        libros[2] = new Libro(3, "Don Quijote de la Mancha");
        libros[3] = new Libro(4, "Harry Potter");
        libros[4] = new Libro(5, "wigetta");
    }


    public void consultarLibros() {
        System.out.println("\n--- CATALOGO DE LIBROS ---");
        for (int i = 0; i < totalLibros; i++) {
            libros[i].mostrarInfo();
        }
    }


    public Libro consultarLibro(int id) {
        for (int i = 0; i < totalLibros; i++) {
            if (libros[i].id == id) {
                return libros[i];
            }
        }
        return null;
    }


    public void prestarLibros(int id) {
        Libro libro = consultarLibro(id);

        if (libro == null) {
            System.out.println("No se encontro el libro con ID " + id);
            return;
        }


        if (libro.verDisponibilidad() == false) {
            System.out.println("El libro no esta disponible");
            return;
        }

        libro.setDisponibilidad(false);
        System.out.println("Libro prestado: " + libro.titulo);
    }


    public void recibirDevolucion(int id, LocalDate fechaLimite) {
        Libro libro = consultarLibro(id);

        if (libro == null) {
            System.out.println("No se encontro el libro con ID " + id);
            return;
        }

        if (libro.verDisponibilidad() == true) {
            System.out.println("Ese libro no estaba prestado");
            return;
        }

        libro.setDisponibilidad(true);
        System.out.println("Libro devuelto: " + libro.titulo);


        LocalDate hoy = LocalDate.now();
        if (fechaLimite.isBefore(hoy)) {
            long dias = java.time.temporal.ChronoUnit.DAYS.between(fechaLimite, hoy);
            double multa = dias * 5.0;
            System.out.println("MULTA: se paso " + dias + " dias");
            System.out.println("Total a pagar: $" + multa + " pesos");
        } else {
            System.out.println("Devuelto a tiempo, sin multa");
        }
    }


    public void verificarInventario() {
        System.out.println("\n--- LIBROS DISPONIBLES ---");
        for (int i = 0; i < totalLibros; i++) {
            if (libros[i].disponible == true) {
                libros[i].mostrarInfo();
            }
        }
    }
}