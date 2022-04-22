package rey.angel.ProyectoFinal_Concesionario;

import java.io.IOException;
import javafx.fxml.FXML;

public class InicioController {

    @FXML
    private void switchToFormulario() throws IOException {
        App.setRoot("FormularioCliente");
    }
}
