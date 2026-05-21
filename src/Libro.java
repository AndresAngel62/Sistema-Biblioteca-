public class Libro {


    int id;
    String titulo;
    boolean disponible;
    public Libro(int id, String titulo) {
        this.id = id;
        this.titulo = titulo;
        this.disponible = true;
    }
    public void mostrarInfo() {
        System.out.println("ID: " + id + " | Titulo: " + titulo + " | Disponible: " + disponible);
    }
    public void setDisponibilidad(boolean d) {
        this.disponible = d;
    }
    public boolean verDisponibilidad() {
        return disponible;
    }
}
