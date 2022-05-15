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
import rey.angel.ProyectoFinal_Concesionario.utils.Loggers;

public class DeleteCocheController {
	
	@FXML
	private TextField delCoche;
	@FXML
	private DialogPane mod;
	
	/**
	 * Metodo para recoger el dato introducido en el campo, buscar ese cliente por su Matricula y borrarlo
	 * Lanza alertas según si ha podido eliminarlo o no
	 * Le pasamos una expresion regular para controlar lo que se introduce
	 * @throws IOException que lanza si no funciona correctamente
	 */
	@FXML
	private void delCoche() throws IOException {
		try {
			if (delCoche.getText().matches("^[0-9]{4}-[A-Z]{3}$")) {
				Coche co = CocheDao.get(delCoche.getText());
				CocheDao.delete(co);
				AlertDelCar();
				Loggers.LogsInfo("Vehiculo eliminado");
			} else {
				AlertErrorDelCarFE();
				delCoche.clear();
				Loggers.LogsSevere("Formato del campo incorrecto");
			}
		} catch (Exception e) {
			AlertErrorDelCar();
			delCoche.clear();
			Loggers.LogsSevere("El vehiculo a eliminar no existe");
		}
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
        App.setRoot("Coches");
    }
    
    /**
     * Alerta que se muestra si el vehiculo no ha podido ser eliminado
     * @throws IOException
     */
    private void AlertErrorDelCar() throws IOException {
    	Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setHeaderText("ERROR AL ELIMINAR EL VEHICULO");
        alert.setContentText("El vehiculo no existe");
        Stage s = (Stage)alert.getDialogPane().getScene().getWindow();
        s.toFront();
        alert.showAndWait();
        mod.setVisible(false);
    }
    
    /**
     * Alerta que se muestra si el vehiculo no ha podido ser eliminado
     * @throws IOException
     */
    private void AlertErrorDelCarFE() throws IOException {
    	Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setHeaderText("ERROR AL ELIMINAR EL VEHICULO");
        alert.setContentText("El formato de los campos es erroneo");
        Stage s = (Stage)alert.getDialogPane().getScene().getWindow();
        s.toFront();
        alert.showAndWait();
        mod.setVisible(false);
    }
    
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
}
