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
import rey.angel.ProyectoFinal_Concesionario.utils.Loggers;

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
	
	/**
	 * Metodo del panel de dialogo que al introducir el dni del cliente te recoge el DNI, te busca ese cliente
	 * y hace un set de todos los campos a los TextField correspondientes
	 * Oculta el panel de dialogo
	 * Muestra alerta si no ha podido encontrar el cliente o el DNI no cumple la condicion
	 * @throws IOException
	 */
	@FXML
	private void modifyClient() throws IOException {
		try {
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
				Loggers.LogsInfo("Modificando cliente");
			} else {
				AlertErrorFE();
				modifica.clear();
				Loggers.LogsSevere("Formato del campo DNI incorrecto");
			}
		} catch (Exception e) {
			AlertError();
			Loggers.LogsSevere("El cliente a modificar no existe");
		}
	}
	
	/**
	 * Metodo que recoge todos los campos del TextField, ya estén modificados o no
	 * Crea un cliente nuevo con esos campos y modifica ese cliente
	 * Muestra alertas si se ha podido modificar el cliente o no
	 * @throws IOException
	 */
	@FXML
	private void saveChanges() throws IOException {
		try {
			if (Teléfono.getText().matches("^[0-9]{9}$") && Codigo_Postal.getText().matches("^[0-9]{5}$")) {
			Cliente c = new Cliente(DNI.getText(),Nombre.getText(),Apellidos.getText(),Correo.getText(),Teléfono.getText(),Dirección.getText(),Codigo_Postal.getText());
	    	cd.update(c);
	    	AlertMod();
	    	Loggers.LogsInfo("Cliente modificado");
			} else {
				AlertErrorMod();
				Loggers.LogsSevere("Formatos erroneos de los campos al modificar el cliente");
			}
		} catch (Exception e) {
			AlertErrorMod();
			Loggers.LogsSevere("Cliente no se ha podido modificar correctamente");
		}
			
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
	 * Metodo para cambiar a la pantalla del inicio
	 * @throws IOException que muestra si no se puede cambiar de pantalla al pulsar el botón
	 */
	@FXML
    private void switchToInicio() throws IOException {
        App.setRoot("Inicio");
    }
	
	/**
	 * Metodo para cambiar a la pantalla del inicio
	 * @throws IOException que muestra si no se puede cambiar de pantalla al pulsar el botón
	 */
	@FXML
    private void switchToVentas() throws IOException {
        App.setRoot("Ventas");
    }
	
	/**
	 * Alerta que se muestra si se ha podido modificar el cliente
	 * @throws IOException
	 */
	private void AlertMod() throws IOException {
    	Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("INFORMACION");
        alert.setHeaderText("CAMBIOS GUARDADOS");
        alert.setContentText("El cliente se ha modificado correctamente");
        Stage s = (Stage)alert.getDialogPane().getScene().getWindow();
        s.toFront();
        alert.showAndWait();
        App.setRoot("Inicio");
    }
    
	/**
	 * Alerta que se muestra si no encuentra el Cliente o el DNI introducido es incorrecto
	 * @throws IOException
	 */
    private void AlertError() throws IOException {
    	Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setHeaderText("ERROR AL INTRODUCIR EL DNI");
        alert.setContentText("El cliente a modificar no existe");
        alert.show();
        Stage s = (Stage)alert.getDialogPane().getScene().getWindow();
        s.toFront();
    }
    
    /**
	 * Alerta que se muestra si no encuentra el Cliente o el DNI introducido es incorrecto
	 * @throws IOException
	 */
    private void AlertErrorFE() throws IOException {
    	Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setHeaderText("ERROR AL INTRODUCIR EL DNI");
        alert.setContentText("Formato del campo DNI incorrecto");
        alert.show();
        Stage s = (Stage)alert.getDialogPane().getScene().getWindow();
        s.toFront();
    }
    
    /**
     * Alerta que se muestra si no se ha podido modificar los cambios del cliente
     * @throws IOException
     */
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
