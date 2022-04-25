package rey.angel.ProyectoFinal_Concesionario;

import java.io.IOException;

import javafx.fxml.FXML;

public class CochesController {
	
	@FXML
    private void switchToInicio() throws IOException {
        App.setRoot("Inicio");
    }
	
	@FXML
    private void switchToVentas() throws IOException {
        App.setRoot("Ventas");
    }
	
	@FXML
    private void switchToMenu() throws IOException {
        App.setRoot("MenuPrincipal");
    }
	
	@FXML
    private void switchToFormularioCoches() throws IOException {
        App.setRoot("FormularioCoches");
    }
}
