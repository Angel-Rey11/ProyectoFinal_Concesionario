package rey.angel.ProyectoFinal_Concesionario;

import java.io.IOException;
import javafx.fxml.FXML;

public class InicioController {

    @FXML
    private void switchToFormulario() throws IOException {
        App.setRoot("FormularioCliente");
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
    private void switchToMenu() throws IOException {
        App.setRoot("MenuPrincipal");
    }
}
