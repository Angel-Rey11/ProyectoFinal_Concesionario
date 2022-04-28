package rey.angel.ProyectoFinal_Concesionario;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import rey.angel.ProyectoFinal_Concesionario.model.Dao.CocheDao;
import rey.angel.ProyectoFinal_Concesionario.model.DataObject.Coche;

public class FormularioCochesController {
	
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
	private TextField Kilometros;
	@FXML
	private TextField Precio;
	
	CocheDao cd = new CocheDao();
	
	@FXML
    private void switchToInicio() throws IOException {
        App.setRoot("Inicio");
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
	private void switchToMenuPrincipal() throws IOException {
		App.setRoot("MenuPrincipal");
	}
	
	@FXML
	private void AddCar() throws IOException {
		Coche car = new Coche(Matricula.getText(),Marca.getText(),Modelo.getText(),Ano.getText(),Color.getText(),Kilometros.getText(),Precio.getText());
		cd.insert(car);
	}
}
