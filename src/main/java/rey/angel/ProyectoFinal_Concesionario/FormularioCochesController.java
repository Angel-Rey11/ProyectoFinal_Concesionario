package rey.angel.ProyectoFinal_Concesionario;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import rey.angel.ProyectoFinal_Concesionario.model.Dao.CocheDao;
import rey.angel.ProyectoFinal_Concesionario.model.DataObject.Coche;

public class FormularioCochesController {
	
	@FXML
	private TextField Matricula;
	@FXML
	private TextField Marca;
	@FXML
	private TextField Modelo;
	@FXML
	private TextField Ano;
	@FXML
	private TextField Color;
	@FXML
	private TextField Kilometros;
	@FXML
	private TextField Precio;
	
	CocheDao cd = new CocheDao();
	
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
	 * Metodo para añadir un vehiculo si cumple la condicion del campo clave matricula
	 * Te recoge todos los campos creando un vehiculo nuevo y lo añade a la base de datos
	 * Limpia todos los TextField después de añadir
	 * Muestra alertas si se ha podido añadir o no el vehiculo
	 * @throws IOException
	 */
	@FXML
	private void AddCar() throws IOException {
		if (Matricula.getText().matches("^[0-9]{4}-[A-Z]{3}$")) {
			Coche car = new Coche(Matricula.getText(),Marca.getText(),Modelo.getText(),Ano.getText(),Color.getText(),Kilometros.getText(),Precio.getText());
			cd.insert(car);
			AlertAdd();
			Matricula.clear();
			Marca.clear();
			Modelo.clear();
			Ano.clear();
			Color.clear();
			Kilometros.clear();
			Precio.clear();
		} else {
			AlertError();
		}
	}
	
	/**
	 * Alerta que se muestra si se ha podido añadir bien el vehiculo
	 * @throws IOException
	 */
	 private void AlertAdd() throws IOException {
	    	Alert alert = new Alert(AlertType.INFORMATION);
	        alert.setTitle("INFORMACION");
	        alert.setHeaderText("VEHICULO AÑADIDO");
	        alert.setContentText("El vehiculo se ha añadido correctamente");
	        Stage s = (Stage)alert.getDialogPane().getScene().getWindow();
	        s.toFront();
	        alert.showAndWait();
	        App.setRoot("Coches");
	    }
	 
	 /**
	  * Alerta que se muestra si no se ha podido añadir el vehiculo
	  * @throws IOException
	  */
	 private void AlertError() throws IOException {
	    	Alert alert = new Alert(AlertType.ERROR);
	        alert.setTitle("ERROR");
	        alert.setHeaderText("ERROR AL AÑADIR EL VEHICULO");
	        alert.setContentText("Los datos introducidos del vehiculo no son correctos o ya existe el vehiculo");
	        alert.show();
	        Stage s = (Stage)alert.getDialogPane().getScene().getWindow();
	        s.toFront();
	    }
}
