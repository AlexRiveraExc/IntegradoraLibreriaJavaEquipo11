public class Libro {

    private String isbn;
    private String titulo;
    private String autor;
    private int anio;
    private String genero;
    private boolean disponible;

    public Libro() {}

    public Libro(String isbn, String titulo,
                 String autor, int anio,
                 String genero, boolean disponible) {

        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
        this.genero = genero;
        this.disponible = disponible;
    }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    public int getAnio() { return anio; }
    public void setAnio(int anio) { this.anio = anio; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }

    // CSV

    public String toCSV() {

        return isbn + "," +
                titulo + "," +
                autor + "," +
                anio + "," +
                genero + "," +
                disponible;
    }

    public static Libro fromCSV(String linea) {

        String[] d = linea.split(",");

        return new Libro(
                d[0],
                d[1],
                d[2],
                Integer.parseInt(d[3]),
                d[4],
                Boolean.parseBoolean(d[5])
        );
    }
}