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
import rey.angel.ProyectoFinal_Concesionario.utils.Loggers;

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
	
	/**
	 * Metodo para cambiar a la pantalla del inicio
	 * @throws IOException que muestra si no se puede cambiar de pantalla al pulsar el botón
	 */
    @FXML
    private void switchToInicio() throws IOException {
        App.setRoot("Inicio");
    }
    
    /**
	 * Metodo para cambiar a la pantalla de coches
	 * @throws IOException que muestra si no se puede cambiar de pantalla al pulsar el botón
	 */
    @FXML
    private void switchToCoches() throws IOException {
        App.setRoot("Coches");
    }
    
    /**
	 * Metodo para cambiar a la pantalla de ventas
	 * @throws IOException que muestra si no se puede cambiar de pantalla al pulsar el botón
	 */
    @FXML
    private void switchToVentas() throws IOException {
    	App.setRoot("Ventas");
    }
    
    /**
	 * Metodo para cambiar a la pantalla del menu principal
	 * @throws IOException que muestra si no se puede cambiar de pantalla al pulsar el botón
	 */
    @FXML
    private void switchToMenuPrincipal() throws IOException {
    	App.setRoot("MenuPrincipal");
    }
    
    /**
     * Metodo que cuando pulsas un botón te recoge el dato del campo clave primaria si cumple esa condicion
     * Recoge todos los campos creando un cliente nuevo con esos datos y lo añade a la base de datos
     * Te limpia todos los textField después de añadirlo
     * Muestra alertas si ha podido añadirlo o no
     * @throws IOException
     */
    @FXML
    private void AddClient() throws IOException {
    	Cliente c = cd.get(dni.getText());
    	if (c==null) {
    		if (dni.getText().matches("^[0-9]{7,8}[A-Z]$") && telefono.getText().matches("^[0-9]{9}$") && 
        			Codigo_postal.getText().matches("^[0-9]{5}$")) {
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
                Loggers.LogsInfo("Cliente añadido");
                
    	} else {
    		AlertErrorType();
    		Loggers.LogsSevere("Datos introducidos del cliente son incorrectos");
    	}
    	} else {
    		AlertError();
    		Loggers.LogsSevere("Cliente ya existe");
    	}
    	}
    
    /**
     * Alerta que se muestra si se ha podido añadir el cliente correctamente
     * @throws IOException
     */
    private void AlertAdd() throws IOException {
    	Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("INFORMACION");
        alert.setHeaderText("CLIENTE AÑADIDO");
        alert.setContentText("El cliente se ha añadido correctamente");
        Stage s = (Stage)alert.getDialogPane().getScene().getWindow();
        s.toFront();
        alert.showAndWait();
        App.setRoot("Inicio");
    }
    
    /**
     * Alerta que se muestra si no se ha podido añadir el cliente porque ya existe
     * @throws IOException
     */
    private void AlertError() throws IOException {
    	Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setHeaderText("ERROR AL AÑADIR EL CLIENTE");
        alert.setContentText("El cliente ya existe");
        alert.show();
        Stage s = (Stage)alert.getDialogPane().getScene().getWindow();
        s.toFront();
    }
    
    /**
     * Alerta que se muestra si no se ha podido añadir el cliente porque los datos introducidos no son correctos
     * @throws IOException
     */
    private void AlertErrorType() throws IOException {
    	Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setHeaderText("ERROR AL AÑADIR EL CLIENTE");
        alert.setContentText("Los datos introducidos no son correctos");
        alert.show();
        Stage s = (Stage)alert.getDialogPane().getScene().getWindow();
        s.toFront();
    }
    }