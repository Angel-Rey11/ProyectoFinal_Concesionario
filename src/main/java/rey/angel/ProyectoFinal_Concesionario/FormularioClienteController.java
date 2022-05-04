package rey.angel.ProyectoFinal_Concesionario;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import rey.angel.ProyectoFinal_Concesionario.model.Dao.ClienteDao;
import rey.angel.ProyectoFinal_Concesionario.model.DataObject.Cliente;

public class FormularioClienteController {
	
	@FXML
	private TextField dni;
	@FXML
	private TextField nombre;
	@FXML
	private TextField apellidos;
	@FXML
	private TextField correo;
	@FXML
	private TextField telefono;
	@FXML
	private TextField direccion;
	@FXML
	private TextField Codigo_postal;
	@FXML
	private AnchorPane my;
	
	ClienteDao cd = new ClienteDao();
	

    @FXML
    private void switchToInicio() throws IOException {
        App.setRoot("Inicio");
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
    private void switchToMenuPrincipal() throws IOException {
    	App.setRoot("MenuPrincipal");
    }
    
    @FXML
    private void AddClient() throws IOException {
    	if (dni.getText().matches("^[0-9]{7,8}[A-Z]$")) {
    		Cliente client = new Cliente(dni.getText(),nombre.getText(),apellidos.getText(),correo.getText(),telefono.getText(),direccion.getText(),Codigo_postal.getText());
            cd.insert(client);
            dni.clear();
            nombre.clear();
            apellidos.clear();
            correo.clear();
            telefono.clear();
            direccion.clear();
            Codigo_postal.clear();
            AlertAdd();
    	} else {
    		AlertError();
    	}
    	
    	}
    
    private void AlertAdd() throws IOException {
    	Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("INFORMACION");
        alert.setHeaderText("CLIENTE AÑADIDO");
        alert.setContentText("El cliente se ha añadido correctamente");
        alert.show();
        Stage s = (Stage)alert.getDialogPane().getScene().getWindow();
        s.toFront();
    }
    
    private void AlertError() throws IOException {
    	Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setHeaderText("ERROR AL AÑADIR EL CLIENTE");
        alert.setContentText("Los datos introducidos del cliente no son correctos o ya existe el cliente");
        alert.show();
        Stage s = (Stage)alert.getDialogPane().getScene().getWindow();
        s.toFront();
    }
    }