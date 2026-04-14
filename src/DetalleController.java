import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DetalleController {

    @FXML private Label lblIsbn;
    @FXML private Label lblTitulo;
    @FXML private Label lblAutor;
    @FXML private Label lblAnio;
    @FXML private Label lblGenero;
    @FXML private Label lblDisponible;

    private Libro libro;

    public void setLibro(Libro libro) {

        this.libro = libro;

        lblIsbn.setText(libro.getIsbn());
        lblTitulo.setText(libro.getTitulo());
        lblAutor.setText(libro.getAutor());
        lblAnio.setText(String.valueOf(libro.getAnio()));
        lblGenero.setText(libro.getGenero());
        lblDisponible.setText(
                libro.isDisponible() ? "Si" : "No"
        );
    }

    @FXML
    public void regresar() {

        lblIsbn.getScene().getWindow().hide();
    }
}