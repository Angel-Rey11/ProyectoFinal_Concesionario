package rey.angel.ProyectoFinal_Concesionario;

import java.io.IOException;
import java.util.Collection;
import java.util.Optional;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputDialog;
import javafx.stage.StageStyle;
import model.Dao.ClienteDao;
import model.DataObject.Cliente;

public class InicioController {
	
	ClienteDao cd = new ClienteDao();
	
	@FXML
	private TableView<Cliente> tab;
	
	@FXML
	private void ShowClients() throws IOException {
		Collection<Cliente> misClientes = cd.getAll();
		for (Cliente c: misClientes) {
			tab.getItems().add(c);
		}
	}
	
	@FXML
	private void ModifyClient() throws IOException {
		TextInputDialog dialogo = new TextInputDialog();
		dialogo.setTitle("Modificar Cliente");
		dialogo.setHeaderText("Por favor, ingresa el DNI del cliente");
		dialogo.setContentText("Introduzca el DNI del cliente");
		dialogo.initStyle(StageStyle.UTILITY);
		Optional<String> respuesta = dialogo.showAndWait();
		respuesta.ifPresent((String)->{
			try {
				App.setRoot("ModificaCliente");
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}

    @FXML
    private void switchToFormulario() throws IOException {
        App.setRoot("FormularioCliente");
    }
    
    @FXML
    private void switchToCoches() throws IOException {
        App.setRoot("Coches");
    }
    
    @FXML
    private void switchToVentas() throws IOException {
        App.setRoot("Ventas");
    }
    
    @FXML
    private void switchToMenu() throws IOException {
        App.setRoot("MenuPrincipal");
    }
}
