package rey.angel.ProyectoFinal_Concesionario;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;
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
		Cliente c = cd.get(modifica.getText());
		DNI.setText(c.getDni());
		Nombre.setText(c.getNombre());
		Apellidos.setText(c.getApellidos());
		Correo.setText(c.getCorreo());
		Teléfono.setText(c.getTelefono());
		Dirección.setText(c.getDireccion());
		Codigo_Postal.setText(c.getCodigo_postal());
		mod.setVisible(false);
	}
	
	@FXML
	private void saveChanges() throws IOException {
    	Cliente c = new Cliente(DNI.getText(),Nombre.getText(),Apellidos.getText(),Correo.getText(),Teléfono.getText(),Dirección.getText(),Codigo_Postal.getText());
    	cd.update(c);
	}
	
	@FXML
    private void switchToCoches() throws IOException {
        App.setRoot("Coches");
    }
	
	@FXML
    private void switchToInicio() throws IOException {
        App.setRoot("Inicio");
    }
	
}
