package rey.angel.ProyectoFinal_Concesionario;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import rey.angel.ProyectoFinal_Concesionario.model.Dao.CarDao;
import rey.angel.ProyectoFinal_Concesionario.model.Dao.CocheDao;
import rey.angel.ProyectoFinal_Concesionario.model.DataObject.Car;
import rey.angel.ProyectoFinal_Concesionario.model.DataObject.Coche;
import rey.angel.ProyectoFinal_Concesionario.utils.Loggers;

public class ModificaCocheController {
	
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
	private TextField Kms;
	@FXML
	private TextField precio;
	@FXML
	private DialogPane mod;
	@FXML
	private TextField modifica;
	
	/**
	 * Metodo que recoge el texfField si cumple la condicion, busca el coche 
	 * y hace un set de todos los campos en los TextField correspondientes
	 * Oculta el panel de dialogo
	 * Muestra alertas si no ha podido encontrar el coche o el formato de la matricula no es correcta
	 * @throws IOException
	 */
	@FXML
	private void ModifyCar() throws IOException {
		try {
			if (modifica.getText().matches("^[0-9]{4}-[A-Z]{3}$")) {
				Coche c = CocheDao.get(modifica.getText());
				Matricula.setText(c.getMatricula());
				Marca.setText(c.getMarca());
				Modelo.setText(c.getModelo());
				Ano.setText(c.getAno());
				Color.setText(c.getColor());
				Kms.setText(c.getKilometros());
				precio.setText(c.getPrecio());
				mod.setVisible(false);
				Loggers.LogsInfo("Modificando coche");
			} else {
				AlertErrorFE();
				modifica.clear();
				Loggers.LogsSevere("Formato de la matricula incorrecto");
			}
		} catch (Exception e) {
			AlertError();
			Loggers.LogsSevere("El coche no existe");
		}	
	}
	
	/**
	 * Metodo para modificar el coche, crea un nuevo coche con los datos de los TextField y modifica el coche
	 * Muestra alertas si se ha podido modificar o no el coche
	 * @throws IOException
	 */
	@FXML
	private void SaveChanges() throws IOException {
		try {
			if (Ano.getText().matches("[0-9]{4}") && Kms.getText().matches("[0-9]+") && precio.getText().matches("[0-9]+")) {
				Car car = new Car (Matricula.getText(),Marca.getText(),Modelo.getText(),Ano.getText(),Color.getText(),Kms.getText(),precio.getText());
				cd.update(car);
				AlertMod();
				Loggers.LogsInfo("Coche modificado con exito");
			} else {
				AlertErrorMod();
				Loggers.LogsSevere("Formato de los campos erroneos al modificar un coche");
			}
		} catch (Exception e) {
			AlertErrorMod();
			Loggers.LogsSevere("El coche no se ha podido modificar");
		}
		
	}
	
	/**
	 * Metodo para cambiar a la pantalla de coches
	 * @throws IOException que muestra si no se puede cambiar de pantalla al pulsar el botón
	 */
	@FXML
    private void switchToCoches() throws IOException {
		try {
			App.setRoot("Coches");
			Loggers.LogsInfo("Cambio de FXML correcto");
		} catch (Exception e) {
			Loggers.LogsSevere("No se ha podido cambiar de FXML");
		}
    }
	
	/**
	 * Metodo para cambiar a la pantalla del inicio
	 * @throws IOException que muestra si no se puede cambiar de pantalla al pulsar el botón
	 */
	@FXML
    private void switchToInicio() throws IOException {
		try {
			App.setRoot("Inicio");
			Loggers.LogsInfo("Cambio de FXML correcto");
		} catch (Exception e) {
			Loggers.LogsSevere("No se ha podido cambiar de FXML");
		}
    }
	
	/**
	 * Metodo para cambiar a la pantalla del inicio
	 * @throws IOException que muestra si no se puede cambiar de pantalla al pulsar el botón
	 */
	@FXML
    private void switchToVentas() throws IOException {
		try {
			App.setRoot("Ventas");
			Loggers.LogsInfo("Cambio de FXML correcto");
		} catch (Exception e) {
			Loggers.LogsSevere("No se ha podido cambiar de FXML");
		}
    }
	
	/**
	 * Alerta que se muestra si ha podido modificar el coche
	 * @throws IOException
	 */
	private void AlertMod() throws IOException {
    	Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("INFORMACION");
        alert.setHeaderText("CAMBIOS GUARDADOS");
        alert.setContentText("El vehiculo se ha modificado correctamente");
        Stage s = (Stage)alert.getDialogPane().getScene().getWindow();
        s.toFront();
        alert.showAndWait();
        App.setRoot("Coches");
    }
    
	/**
	 * Alerta que se muestra si no ha encontrado el coche o la matricula no cumple el formato
	 * @throws IOException
	 */
    private void AlertError() throws IOException {
    	Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setHeaderText("ERROR AL INTRODUCIR LA MATRICULA");
        alert.setContentText("Vehiculo no existe");
        alert.show();
        Stage s = (Stage)alert.getDialogPane().getScene().getWindow();
        s.toFront();
    }
    
    /**
	 * Alerta que se muestra si no ha encontrado el coche o la matricula no cumple el formato
	 * @throws IOException
	 */
    private void AlertErrorFE() throws IOException {
    	Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setHeaderText("ERROR AL INTRODUCIR LA MATRICULA");
        alert.setContentText("Formato del campo Matricula es erroneo");
        alert.show();
        Stage s = (Stage)alert.getDialogPane().getScene().getWindow();
        s.toFront();
    }
    
    /**
     * Alerta que se muestra si no se ha podido modificar los cambios
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
