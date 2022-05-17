package rey.angel.ProyectoFinal_Concesionario;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import rey.angel.ProyectoFinal_Concesionario.model.Dao.CocheDao;
import rey.angel.ProyectoFinal_Concesionario.model.Dao.MotorBikeDao;
import rey.angel.ProyectoFinal_Concesionario.model.DataObject.Coche;
import rey.angel.ProyectoFinal_Concesionario.model.DataObject.MotorBike;
import rey.angel.ProyectoFinal_Concesionario.utils.Loggers;

public class ModificaMotoController {
	
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
	private TextField Kms;
	@FXML
	private TextField Precio;
	@FXML
	private TextField Cilindrada;
	@FXML
	private TextField modifica;
	@FXML
	private DialogPane mod;
	
	/**
	 * Metodo que recoge el texfField si cumple la condicion, busca la moto 
	 * y hace un set de todos los campos en los TextField correspondientes
	 * Oculta el panel de dialogo
	 * Muestra alertas si no ha podido encontrar la moto o el formato de la matricula no es correcta
	 * @throws IOException
	 */
	@FXML
	private void ModifyMoto() throws IOException {
		try {
			if (modifica.getText().matches("^[0-9]{4}-[A-Z]{3}$")) {
				Coche c = CocheDao.get(modifica.getText());
				Matricula.setText(c.getMatricula());
				Marca.setText(c.getMarca());
				Modelo.setText(c.getModelo());
				Ano.setText(c.getAno());
				Color.setText(c.getColor());
				Kms.setText(c.getKilometros());
				Precio.setText(c.getPrecio());
				Cilindrada.setText(c.getCilindrada());
				mod.setVisible(false);
				Loggers.LogsInfo("Modificando moto");
			} else {
				AlertErrorFE();
				modifica.clear();
				Loggers.LogsSevere("Formato de la matricula incorrecto");
			}
		} catch (Exception e) {
			AlertError();
			Loggers.LogsSevere("La moto no existe");
		}
	}
	
	@FXML
	private void SaveChanges() throws IOException {
			try {
				if (Ano.getText().matches("[0-9]{4}") && Kms.getText().matches("[0-9]+") 
						&& Precio.getText().matches("[0-9]+") && Cilindrada.getText().matches("[0-9]+")) {
					MotorBike mb = new MotorBike(Matricula.getText(),Marca.getText(),Modelo.getText(),Ano.getText(),Color.getText(),Kms.getText(),Precio.getText(),Cilindrada.getText());
					mbd.update(mb);
					AlertMod();
					Loggers.LogsInfo("Moto modificada con exito");
				} else {
					AlertErrorMod();
					Loggers.LogsSevere("Formato de los campos erroneos al modificar una moto");
				}
			} catch (Exception e) {
				AlertErrorMod();
				Loggers.LogsSevere("La moto no se ha podido modificar");
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
	 * Alerta que se muestra si ha podido modificar la moto
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
	 * Alerta que se muestra si no ha encontrado la moto o la matricula no cumple el formato
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
	 * Alerta que se muestra si no ha encontrado la moto o la matricula no cumple el formato
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
     * Alerta que se muestra si no se ha podido modificar los cambios de la moto
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
