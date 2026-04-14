import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.control.Alert;

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
@FXML
public void eliminar() {

    Libro seleccionado =
            tablaLibros.getSelectionModel()
                    .getSelectedItem();

    if (seleccionado == null) return;

    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setContentText("¿Eliminar libro?");

    alert.showAndWait().ifPresent(res -> {

        repo.eliminar(seleccionado.getIsbn());
        cargarTabla();
    });
}

@FXML
public void exportar() {

    repo.exportarReporte();

    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setContentText("Reporte exportado");
    alert.show();
}

@FXML
public void nuevo() {

    try {

        FXMLLoader loader =
                new FXMLLoader(
                        getClass().getResource("/formulario-view.fxml")
                );

        Parent root = loader.load();

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Nuevo Libro");
        stage.show();

    } catch (Exception e) {

        System.out.println("Error abriendo formulario");
    }
}

@FXML
public void verDetalle() {

    Libro libro =
            tablaLibros.getSelectionModel()
                    .getSelectedItem();

    if (libro == null) {

        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setContentText("Selecciona un libro");
        alert.show();
        return;
    }

    try {

        FXMLLoader loader =
                new FXMLLoader(
                        getClass().getResource("/detalle-view.fxml")
                );

        Parent root = loader.load();

        DetalleController controller =
                loader.getController();

        controller.setLibro(libro);

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Detalle Libro");
        stage.show();

    } catch (Exception e) {

        System.out.println("Error abriendo detalle");
    }
}

