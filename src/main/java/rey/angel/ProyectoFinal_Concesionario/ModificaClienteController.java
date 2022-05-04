package rey.angel.ProyectoFinal_Concesionario;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import rey.angel.ProyectoFinal_Concesionario.model.Dao.ClienteDao;
import rey.angel.ProyectoFinal_Concesionario.model.DataObject.Cliente;

public class ModificaClienteController {
	
	ClienteDao cd = new ClienteDao();
	
	@FXML
	private TextField DNI; 
	@FXML
	private TextField Nombre;
	@FXML
	private TextField Apellidos;
	@FXML
	private TextField Correo;
	@FXML
	private TextField Teléfono;
	@FXML
	private TextField Dirección;
	@FXML
	private TextField Codigo_Postal;
	@FXML
	private DialogPane mod;
	@FXML
	private TextField modifica;
	
	@FXML
	private void modifyClient() throws IOException {
		if (modifica.getText().matches("^[0-9]{7,8}[A-Z]$")) {
			Cliente c = cd.get(modifica.getText());
			DNI.setText(c.getDni());
			Nombre.setText(c.getNombre());
			Apellidos.setText(c.getApellidos());
			Correo.setText(c.getCorreo());
			Teléfono.setText(c.getTelefono());
			Dirección.setText(c.getDireccion());
			Codigo_Postal.setText(c.getCodigo_postal());
			mod.setVisible(false);
		} else {
			AlertError();
		}
		
	}
	
	@FXML
	private void saveChanges() throws IOException {
		try {
			Cliente c = new Cliente(DNI.getText(),Nombre.getText(),Apellidos.getText(),Correo.getText(),Teléfono.getText(),Dirección.getText(),Codigo_Postal.getText());
	    	cd.update(c);
	    	AlertMod();
		} catch (Exception e) {
			AlertErrorMod();
		}
			
	}
	
	@FXML
    private void switchToCoches() throws IOException {
        App.setRoot("Coches");
    }
	
	@FXML
    private void switchToInicio() throws IOException {
        App.setRoot("Inicio");
    }
	
	private void AlertMod() throws IOException {
    	Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("INFORMACION");
        alert.setHeaderText("CAMBIOS GUARDADOS");
        alert.setContentText("El cliente se ha modificado correctamente");
        alert.show();
        Stage s = (Stage)alert.getDialogPane().getScene().getWindow();
        s.toFront();
    }
    
    private void AlertError() throws IOException {
    	Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setHeaderText("ERROR AL INTRODUCIR EL DNI");
        alert.setContentText("El DNI del cliente no es correcto o no existe");
        alert.show();
        Stage s = (Stage)alert.getDialogPane().getScene().getWindow();
        s.toFront();
    }
    
    private void AlertErrorMod() throws IOException {
    	Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setHeaderText("ERROR AL GUARDAR LOS CAMBIOS");
        alert.setContentText("Los datos introducidos no son correctos");
        alert.show();
        Stage s = (Stage)alert.getDialogPane().getScene().getWindow();
        s.toFront();
    }
	
}
