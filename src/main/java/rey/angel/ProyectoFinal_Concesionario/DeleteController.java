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


public class DeleteController {
	@FXML
	private DialogPane cliente;
	@FXML
	private DialogPane mod;
	@FXML
	private TextField delCliente;
	
	
	ClienteDao cd = new ClienteDao();
	
	/**
	 * Metodo para cambiar a la pantalla de Inicio
	 * @throws IOException que muestra si no se puede cambiar de pantalla al pulsar el botón
	 */
	@FXML
	private void SwitchToInicio() throws IOException {
		App.setRoot("Inicio");
	}
	
	/**
	 * Metodo para cambiar a la pantalla de coches
	 * @throws IOException que muestra si no se puede cambiar de pantalla al pulsar el botón
	 */
	@FXML
	private void SwitchToCoches() throws IOException {
		App.setRoot("Coches");
	}
	
	/**
	 * Metodo para cambiar a la pantalla de ventas
	 * @throws IOException que muestra si no se puede cambiar de pantalla al pulsar el botón
	 */
	@FXML
	private void SwitchToVentas() throws IOException {
		App.setRoot("Ventas");
	}
	
	/**
	 * Metodo para cambiar a la pantalla de Menu Principal
	 * @throws IOException que muestra si no se puede cambiar de pantalla al pulsar el botón
	 */
	@FXML
	private void SwitchToMenuPrincipal() throws IOException {
		App.setRoot("MenuPrincipal");
	}
	
	/**
	 * Metodo para mostrar la confirmacion de si queremos eliminar el cliente correspondiente
	 * @throws IOException
	 */
	@FXML
	private void showConfirmation() throws IOException {
		mod.setVisible(true);
	}
	
	/**
	 * Metodo para recoger el dato introducido en el campo, buscar ese cliente por su DNI y borrarlo
	 * Lanza alertas según si ha podido eliminarlo o no
	 * Le pasamos una expresion regular para controlar lo que se introduce
	 * @throws IOException que lanza si no funciona correctamente
	 */
	@FXML
	private void delCliente() throws IOException {
		try {
			if (delCliente.getText().matches("^[0-9]{7,8}[A-Z]$")) {
				Cliente c = cd.get(delCliente.getText());
				cd.delete(c);
				AlertDelCli();
				Loggers.LogsInfo("Cliente eliminado");
			} else {
				AlertErrorDelCliFE();
				delCliente.clear();
				Loggers.LogsSevere("Formato del campo incorrecto");
			}
		} catch (Exception e) {
			AlertErrorDelCli();
			delCliente.clear();
			Loggers.LogsSevere("El cliente a eliminar no existe");
		}	
	}
	
	/**
	 * 	Alerta que se muestra si el cliente ha podido ser eliminado
	 * @throws IOException
	 */
	 private void AlertDelCli() throws IOException {
	    	Alert alert = new Alert(AlertType.INFORMATION);
	        alert.setTitle("INFORMACION");
	        alert.setHeaderText("CLIENTE ELIMINADO");
	        alert.setContentText("El cliente se ha eliminado correctamente");
	        Stage s = (Stage)alert.getDialogPane().getScene().getWindow();
	        s.toFront();
	        alert.showAndWait();
	        App.setRoot("Inicio");
	    }
	    
	 /**
	  * Alerta que se muestra si el cliente no ha podido ser eliminado
	  * @throws IOException
	  */
	    private void AlertErrorDelCli() throws IOException {
	    	Alert alert = new Alert(AlertType.ERROR);
	        alert.setTitle("ERROR");
	        alert.setHeaderText("ERROR AL ELIMINAR EL CLIENTE");
	        alert.setContentText("El cliente no existe");
	        Stage s = (Stage)alert.getDialogPane().getScene().getWindow();
	        s.toFront();
	        alert.showAndWait();
	        mod.setVisible(false);
	    }
	    
	    /**
		  * Alerta que se muestra si el cliente no ha podido ser eliminado
		  * @throws IOException
		  */
		    private void AlertErrorDelCliFE() throws IOException {
		    	Alert alert = new Alert(AlertType.ERROR);
		        alert.setTitle("ERROR");
		        alert.setHeaderText("ERROR AL ELIMINAR EL CLIENTE");
		        alert.setContentText("Los datos de los campos son erroneos");
		        Stage s = (Stage)alert.getDialogPane().getScene().getWindow();
		        s.toFront();
		        alert.showAndWait();
		        mod.setVisible(false);
		    }
	    
}
