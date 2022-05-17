package rey.angel.ProyectoFinal_Concesionario;

import java.io.IOException;

import javafx.fxml.FXML;
import rey.angel.ProyectoFinal_Concesionario.utils.Loggers;

/**
 * Controlador del Menu Principal del programa, es lo primero que se muestra al ejecutarlo
 * @author Angel
 *
 */
public class MenuPrincipalController {
	
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
}
