package rey.angel.ProyectoFinal_Concesionario;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import rey.angel.ProyectoFinal_Concesionario.model.Dao.CarDao;
import rey.angel.ProyectoFinal_Concesionario.model.Dao.CocheDao;
import rey.angel.ProyectoFinal_Concesionario.model.DataObject.Car;
import rey.angel.ProyectoFinal_Concesionario.model.DataObject.Coche;
import rey.angel.ProyectoFinal_Concesionario.utils.Loggers;

public class FormularioCochesController {
	
	CarDao cd = new CarDao();
	
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
		Coche c = CocheDao.get(Matricula.getText());
		if (c==null) {
			if (Matricula.getText().matches("^[0-9]{4}-[A-Z]{3}$") && Ano.getText().matches("[0-9]{4}") && 
					Kilometros.getText().matches("[0-9]+") && Precio.getText().matches("[0-9]+")) {
				Car caro = new Car(Matricula.getText(),Marca.getText(),Modelo.getText(),Ano.getText(),Color.getText(),Kilometros.getText(),Precio.getText());
				cd.insert(caro);
				AlertAdd();
				Matricula.clear();
				Marca.clear();
				Modelo.clear();
				Ano.clear();
				Color.clear();
				Kilometros.clear();
				Precio.clear();
				Loggers.LogsInfo("Coche añadido");
			} else {
				AlertErrorType();
				Loggers.LogsSevere("Los datos introducidos del coche no son correctos");
			}
		} else {
			AlertError();
			Loggers.LogsSevere("Vehiculo ya existe");
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
	  * Alerta que se muestra si no se ha podido añadir el vehiculo porque ya existe
	  * @throws IOException
	  */
	 private void AlertError() throws IOException {
	    	Alert alert = new Alert(AlertType.ERROR);
	        alert.setTitle("ERROR");
	        alert.setHeaderText("ERROR AL AÑADIR EL VEHICULO");
	        alert.setContentText("El vehiculo introducido ya existe");
	        alert.show();
	        Stage s = (Stage)alert.getDialogPane().getScene().getWindow();
	        s.toFront();
	 }
	 
	 /**
	  * Alerta que se muestra si no se ha podido añadir el vehiculo porque los datos introducidos no son correctos
	  * @throws IOException
	  */
	 private void AlertErrorType() throws IOException {
	    	Alert alert = new Alert(AlertType.ERROR);
	        alert.setTitle("ERROR");
	        alert.setHeaderText("ERROR AL AÑADIR EL VEHICULO");
	        alert.setContentText("Los datos introducidos no son correctos");
	        alert.show();
	        Stage s = (Stage)alert.getDialogPane().getScene().getWindow();
	        s.toFront();
	 }
}
