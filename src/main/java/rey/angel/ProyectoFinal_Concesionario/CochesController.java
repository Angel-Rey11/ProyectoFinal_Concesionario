package rey.angel.ProyectoFinal_Concesionario;

import java.io.IOException;
import java.util.Collection;
import java.util.Optional;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputDialog;
import javafx.stage.StageStyle;
import model.Dao.CocheDao;
import model.DataObject.Coche;

public class CochesController {
	
	CocheDao cd = new CocheDao();
	
	@FXML
	private TableView<Coche> tab;
	
	@FXML
	private void ShowCars() throws IOException {
		Collection<Coche> misCoches = cd.getAll();
		for (Coche c: misCoches) {
			tab.getItems().add(c);
		}
	}
	
	@FXML
	private void ModifyCar() throws IOException {
		TextInputDialog dialogo = new TextInputDialog();
		dialogo.setTitle("Modificar Vehiculo");
		dialogo.setHeaderText("Por favor, ingresa la matrícula del vehículo");
		dialogo.setContentText("Introduzca la matrícula del cliente");
		dialogo.initStyle(StageStyle.UTILITY);
		Optional<String> respuesta = dialogo.showAndWait();
		respuesta.ifPresent((string)->{
			try {
				App.setRoot("ModificaCoche");
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}
	
	@FXML
    private void switchToInicio() throws IOException {
        App.setRoot("Inicio");
    }
	
	@FXML
    private void switchToVentas() throws IOException {
        App.setRoot("Ventas");
    }
	
	@FXML
    private void switchToMenu() throws IOException {
        App.setRoot("MenuPrincipal");
    }
	
	@FXML
    private void switchToFormularioCoches() throws IOException {
        App.setRoot("FormularioCoches");
    }
}
