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
	
	 private void AlertAdd() throws IOException {
	    	Alert alert = new Alert(AlertType.INFORMATION);
	        alert.setTitle("INFORMACION");
	        alert.setHeaderText("VEHICULO AÑADIDO");
	        alert.setContentText("El vehiculo se ha añadido correctamente");
	        alert.show();
	        Stage s = (Stage)alert.getDialogPane().getScene().getWindow();
	        s.toFront();
	    }
	    
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
