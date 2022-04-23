package rey.angel.ProyectoFinal_Concesionario;

import java.io.IOException;

import javafx.fxml.FXML;

public class MenuPrincipalController {
	
	@FXML
    private void switchToInicio() throws IOException {
        App.setRoot("Inicio");
    }
}
