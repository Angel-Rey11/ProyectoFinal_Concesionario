package rey.angel.ProyectoFinal_Concesionario;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;
import model.Dao.ClienteDao;
import model.DataObject.Cliente;

public class ModificaCliente {
	
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
		Apellidos.setText(c.getCorreo());
		Teléfono.setText(String.valueOf(c.getTelefono()));
		Dirección.setText(c.getDireccion());
		Codigo_Postal.setText(String.valueOf(c.getCodigo_postal()));
		mod.setVisible(false);
	}
	
	@FXML
	private void saveChanges() throws IOException {
		int telef = Integer.parseInt(Teléfono.getText());
    	int cp = Integer.parseInt(Codigo_Postal.getText());
    	Cliente c = new Cliente(DNI.getText(),Nombre.getText(),Apellidos.getText(),Correo.getText(),telef,Dirección.getText(),cp);
    	cd.update(c);
	}
	
}
