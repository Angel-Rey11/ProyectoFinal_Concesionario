package rey.angel.ProyectoFinal_Concesionario;

import java.io.IOException;
import java.util.Collection;
import java.util.Optional;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputDialog;
import javafx.stage.StageStyle;
import rey.angel.ProyectoFinal_Concesionario.model.Dao.CocheDao;
import rey.angel.ProyectoFinal_Concesionario.model.DataObject.Coche;

public class CochesController {
	
	CocheDao cd = new CocheDao();
	
	@FXML
	private TableView<Coche> tab;
	
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
	
	@FXML
    private void switchToModCar() throws IOException {
        App.setRoot("ModificaCoche");
    }
}
