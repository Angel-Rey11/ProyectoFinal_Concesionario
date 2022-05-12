package rey.angel.ProyectoFinal_Concesionario;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import rey.angel.ProyectoFinal_Concesionario.model.Dao.CocheDao;
import rey.angel.ProyectoFinal_Concesionario.model.Dao.MotorBikeDao;
import rey.angel.ProyectoFinal_Concesionario.model.DataObject.Coche;
import rey.angel.ProyectoFinal_Concesionario.model.DataObject.MotorBike;
import rey.angel.ProyectoFinal_Concesionario.utils.Loggers;

public class FormularioMotosController {
	MotorBikeDao mbd = new MotorBikeDao();
	
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
	@FXML
	private TextField Cilindrada;
	
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
	
	@FXML
	private void AddMotorBike() throws IOException {
		Coche c = CocheDao.get(Matricula.getText());
		if (c==null ) {
			if (Matricula.getText().matches("^[0-9]{4}-[A-Z]{3}$") && Kilometros.getText().matches("[0-9]+") 
					&& Precio.getText().matches("[0-9]+") && Ano.getText().matches("[0-9]{4}") 
					&& Cilindrada.getText().matches("[0-9]+")) {
				MotorBike mb = new MotorBike (Matricula.getText(),Marca.getText(),Modelo.getText(),Ano.getText(),Color.getText(),Kilometros.getText(),Precio.getText(),Cilindrada.getText());
				mbd.insert(mb);
				AlertAdd();
				Matricula.clear();
				Marca.clear();
				Modelo.clear();
				Ano.clear();
				Color.clear();
				Kilometros.clear();
				Precio.clear();
				Cilindrada.clear();
				Loggers.LogsInfo("Moto añadida");
			} else {
				AlertErrorType();
				Loggers.LogsSevere("Datos de la moto son incorrectos");
			}
		} else {
			AlertError();
			Loggers.LogsSevere("Moto ya existe");
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
	        alert.setContentText("El vehiculo ya existe");
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
