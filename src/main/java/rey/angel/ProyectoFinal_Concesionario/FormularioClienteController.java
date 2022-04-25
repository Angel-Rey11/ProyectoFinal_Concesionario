package rey.angel.ProyectoFinal_Concesionario;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.Dao.ClienteDao;
import model.DataObject.Cliente;

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
        App.setRoot("InicioController");
    }
    
    @FXML
    private void AddClient() throws IOException {
    	int telef = Integer.parseInt(telefono.getText());
    	int cp = Integer.parseInt(Codigo_postal.getText());
    	Cliente client = new Cliente(dni.getText(),nombre.getText(),apellidos.getText(),correo.getText(),telef,direccion.getText(),cp);
    	cd.insert(client);
    	
    }
}