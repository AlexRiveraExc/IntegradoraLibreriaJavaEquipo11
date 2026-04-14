import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

public class MainController {

    @FXML
    private TableView<Libro> tablaLibros;

    @FXML
    private TableColumn<Libro, String> colIsbn;

    @FXML
    private TableColumn<Libro, String> colTitulo;

    @FXML
    private TableColumn<Libro, String> colAutor;

    @FXML
    private TableColumn<Libro, Integer> colAnio;

    @FXML
    private TableColumn<Libro, String> colGenero;

    @FXML
    private TableColumn<Libro, Boolean> colDisponible;

    private LibroRepositorio repo =
            new LibroRepositorio();

    @FXML
    public void initialize() {

        // Conectar columnas

        colIsbn.setCellValueFactory(
                new PropertyValueFactory<>("isbn"));

        colTitulo.setCellValueFactory(
                new PropertyValueFactory<>("titulo"));

        colAutor.setCellValueFactory(
                new PropertyValueFactory<>("autor"));

        colAnio.setCellValueFactory(
                new PropertyValueFactory<>("anio"));

        colGenero.setCellValueFactory(
                new PropertyValueFactory<>("genero"));

        colDisponible.setCellValueFactory(
                new PropertyValueFactory<>("disponible"));

        cargarTabla();
    }

    private void cargarTabla() {

        tablaLibros.getItems().setAll(
                repo.obtenerTodos()
        );
    }
}