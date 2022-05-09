package rey.angel.ProyectoFinal_Concesionario;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import rey.angel.ProyectoFinal_Concesionario.model.Dao.ClienteDao;
import rey.angel.ProyectoFinal_Concesionario.model.Dao.CocheDao;
import rey.angel.ProyectoFinal_Concesionario.model.DataObject.Cliente;
import rey.angel.ProyectoFinal_Concesionario.model.DataObject.Coche;

public class DeleteController {
	@FXML
	private DialogPane cliente;
	@FXML
	private DialogPane coche;
	@FXML
	private DialogPane mod;
	@FXML
	private TextField delCliente;
	@FXML
	private TextField delCoche;
	
	ClienteDao cd = new ClienteDao();
	CocheDao cod = new CocheDao();
	
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
	 * Metodo para mostrar el panel correspondiente y para ocultar el panel donde eliges lo que quieres eliminar
	 * @throws IOException que lanza si no funciona correctamente
	 */
	@FXML
	private void showDelCliente() throws IOException {
		mod.setVisible(false);
		cliente.setVisible(true);
	}
	
	/**
	 * Metodo para mostrar el panel correspondiente y para ocultar el panel donde eliges lo que quieres eliminar
	 * @throws IOException que lanza si no funciona correctamente
	 */
	@FXML
	private void showDelCoche() throws IOException {
		mod.setVisible(false);
		coche.setVisible(true);
	}
	
	/**
	 * Metodo para recoger el dato introducido en el campo, buscar ese cliente por su DNI y borrarlo
	 * Lanza alertas según si ha podido eliminarlo o no
	 * Le pasamos una expresion regular para controlar lo que se introduce
	 * @throws IOException que lanza si no funciona correctamente
	 */
	@FXML
	private void delCliente() throws IOException {
		if (delCliente.getText().matches("^[0-9]{7,8}[A-Z]$")) {
			Cliente c = cd.get(delCliente.getText());
			cd.delete(c);
			AlertDelCli();
		} else {
			AlertErrorDelCli();
		}
			
	}
	
	/**
	 * Metodo para recoger el dato introducido en el campo, buscar ese cliente por su Matricula y borrarlo
	 * Lanza alertas según si ha podido eliminarlo o no
	 * Le pasamos una expresion regular para controlar lo que se introduce
	 * @throws IOException que lanza si no funciona correctamente
	 */
	@FXML
	private void delCoche() throws IOException {
		if (delCoche.getText().matches("^[0-9]{4}-[A-Z]{3}$")) {
			Coche co = cod.get(delCoche.getText());
			cod.delete(co);
			AlertDelCar();
		} else {
			AlertErrorDelCar();
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
	        alert.setContentText("No se ha podido eliminar el cliente o los datos son incorrectos");
	        alert.show();
	        Stage s = (Stage)alert.getDialogPane().getScene().getWindow();
	        s.toFront();
	    }
	    
	    /**
	     * Alerta que se muestra si el vehiculo ha podido ser eliminado
	     * @throws IOException
	     */
	    private void AlertDelCar() throws IOException {
	    	Alert alert = new Alert(AlertType.INFORMATION);
	        alert.setTitle("INFORMACION");
	        alert.setHeaderText("VEHICULO ELIMINADO");
	        alert.setContentText("El vehiculo se ha eliminado correctamente");
	        Stage s = (Stage)alert.getDialogPane().getScene().getWindow();
	        s.toFront();
	        alert.showAndWait();
	        App.setRoot("Inicio");
	    }
	    
	    /**
	     * Alerta que se muestra si el vehiculo no ha podido ser eliminado
	     * @throws IOException
	     */
	    private void AlertErrorDelCar() throws IOException {
	    	Alert alert = new Alert(AlertType.ERROR);
	        alert.setTitle("ERROR");
	        alert.setHeaderText("ERROR AL ELIMINAR EL VEHICULO");
	        alert.setContentText("No se ha podido eliminar el vehiculo o los datos son incorrectos");
	        alert.show();
	        Stage s = (Stage)alert.getDialogPane().getScene().getWindow();
	        s.toFront();
	    }
}
