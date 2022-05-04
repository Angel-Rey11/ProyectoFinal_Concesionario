package rey.angel.ProyectoFinal_Concesionario;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import rey.angel.ProyectoFinal_Concesionario.model.Dao.CocheDao;
import rey.angel.ProyectoFinal_Concesionario.model.DataObject.Coche;

public class ModificaCocheController {
	
	CocheDao cd = new CocheDao();

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
	private TextField Kms;
	@FXML
	private TextField precio;
	@FXML
	private DialogPane mod;
	@FXML
	private TextField modifica;
	
	@FXML
	private void ModifyCar() throws IOException {
		if (modifica.getText().matches("^[0-9]{4}-[A-Z]{3}$")) {
			Coche c = cd.get(modifica.getText());
			Matricula.setText(c.getMatricula());
			Marca.setText(c.getMarca());
			Modelo.setText(c.getModelo());
			Ano.setText(c.getAno());
			Color.setText(c.getColor());
			Kms.setText(c.getKilometros());
			precio.setText(c.getPrecio());
			mod.setVisible(false);	
		} else {
			AlertError();
		}
			
	}
	
	@FXML
	private void SaveChanges() throws IOException {
		try {
			Coche car = new Coche (Matricula.getText(),Marca.getText(),Modelo.getText(),Ano.getText(),Color.getText(),Kms.getText(),precio.getText());
			cd.update(car);
			AlertMod();
		} catch (Exception e) {
			AlertErrorMod();
		}
		
	}
	
	@FXML
    private void switchToCoches() throws IOException {
        App.setRoot("Coches");
    }
	
	@FXML
    private void switchToInicio() throws IOException {
        App.setRoot("Inicio");
    }
	
	private void AlertMod() throws IOException {
    	Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("INFORMACION");
        alert.setHeaderText("CAMBIOS GUARDADOS");
        alert.setContentText("El vehiculo se ha modificado correctamente");
        alert.show();
        Stage s = (Stage)alert.getDialogPane().getScene().getWindow();
        s.toFront();
    }
    
    private void AlertError() throws IOException {
    	Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setHeaderText("ERROR AL INTRODUCIR LA MATRICULA");
        alert.setContentText("La matricula del vehiculo no es correcta o no existe");
        alert.show();
        Stage s = (Stage)alert.getDialogPane().getScene().getWindow();
        s.toFront();
    }
    
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
