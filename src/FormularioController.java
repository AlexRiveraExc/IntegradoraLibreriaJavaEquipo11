import javafx.fxml.FXML;
import javafx.scene.control.*;

public class FormularioController {

    @FXML private TextField txtIsbn;
    @FXML private TextField txtTitulo;
    @FXML private TextField txtAutor;
    @FXML private TextField txtAnio;
    @FXML private TextField txtGenero;
    @FXML private CheckBox chkDisponible;

    private LibroRepositorio repo =
            new LibroRepositorio();

    @FXML
    public void guardar() {

        try {

            String isbn = txtIsbn.getText();
            String titulo = txtTitulo.getText();
            String autor = txtAutor.getText();
            int anio = Integer.parseInt(txtAnio.getText());
            String genero = txtGenero.getText();
            boolean disponible = chkDisponible.isSelected();

            // Validaciones simples
            if (!Validador.textoValido(titulo) ||
                    !Validador.textoValido(autor)) {

                mostrar("Texto invalido");
                return;
            }

            if (!Validador.anioValido(anio)) {

                mostrar("Año invalido");
                return;
            }

            Libro libro = new Libro(
                    isbn, titulo, autor,
                    anio, genero, disponible
            );

            boolean ok = repo.agregar(libro);

            if (ok)
                mostrar("Libro guardado");
            else
                mostrar("ISBN duplicado");

        } catch (Exception e) {

            mostrar("Error en datos");
        }
    }

    @FXML
    public void cancelar() {

        txtIsbn.clear();
        txtTitulo.clear();
        txtAutor.clear();
        txtAnio.clear();
        txtGenero.clear();
        chkDisponible.setSelected(false);
    }

    private void mostrar(String msg) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(msg);
        alert.show();
    }
}
