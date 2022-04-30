package rey.angel.ProyectoFinal_Concesionario;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class VerCocheController {
	private Stage stage;
	private Scene scene;
	@FXML
	private Button boton;
	
	public void InitError() throws IOException {
		stage = new Stage();
		FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("VerCliente"));
		scene = new Scene(fxmlLoader.load());
		stage.setScene(scene);
		stage.initStyle(StageStyle.DECORATED);
		stage.show();
	}
	
	@FXML
	private void ErrorClose() {
		stage = (Stage) this.boton.getScene().getWindow();
		stage.close();
		try {
			App.setRoot("Inicio");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
