import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LibroRepositorio {

    private List<Libro> lista =
            new ArrayList<>();

    private String archivo =
            "resources/libros.csv";

    public LibroRepositorio() {

        cargar();
    }

    // CREATE
    public boolean agregar(Libro libro) {

        if (buscar(libro.getIsbn()) != null)
            return false;

        lista.add(libro);
        guardar();

        return true;
    }

    // READ
    public List<Libro> obtenerTodos() {

        return lista;
    }

    // UPDATE
    public void actualizar(Libro libro) {

        for (int i = 0; i < lista.size(); i++) {

            if (lista.get(i)
                    .getIsbn()
                    .equals(libro.getIsbn())) {

                lista.set(i, libro);
            }
        }

        guardar();
    }

    // DELETE
    public void eliminar(String isbn) {

        lista.removeIf(
                l -> l.getIsbn().equals(isbn)
        );

        guardar();
    }

    public Libro buscar(String isbn) {

        for (Libro l : lista) {

            if (l.getIsbn().equals(isbn))
                return l;
        }

        return null;
    }

    // Cargar archivo
    private void cargar() {

        try {

            BufferedReader br =
                    new BufferedReader(
                            new FileReader(archivo));

            String linea;

            while ((linea = br.readLine()) != null) {

                lista.add(
                        Libro.fromCSV(linea));
            }

            br.close();

        } catch (Exception e) {

            System.out.println(
                    "No se pudo cargar archivo");
        }
    }

    // Guardar archivo
    private void guardar() {

        try {

            BufferedWriter bw =
                    new BufferedWriter(
                            new FileWriter(archivo));

            for (Libro l : lista) {

                bw.write(l.toCSV());
                bw.newLine();
            }

            bw.close();

        } catch (Exception e) {

            System.out.println(
                    "Error guardando archivo");
        }
    }

    // Exportar reporte
    public void exportarReporte() {

        try {

            BufferedWriter bw =
                    new BufferedWriter(
                            new FileWriter("resources/reporte_catalogo.csv"));

            for (Libro l : lista) {

                bw.write(l.toCSV());
                bw.newLine();
            }

            bw.close();

        } catch (Exception e) {

            System.out.println(
                    "Error exportando reporte");
        }
    }
}