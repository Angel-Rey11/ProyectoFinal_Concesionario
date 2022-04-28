package rey.angel.ProyectoFinal_Concesionario;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
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
    	Cliente client = new Cliente(dni.getText(),nombre.getText(),apellidos.getText(),correo.getText(),telefono.getText(),direccion.getText(),Codigo_postal.getText());
    	cd.insert(client);
    	
    }
}