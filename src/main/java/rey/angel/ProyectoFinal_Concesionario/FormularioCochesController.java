package rey.angel.ProyectoFinal_Concesionario;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.Dao.CocheDao;
import model.DataObject.Coche;

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
        App.setRoot("InicioController");
    }
	
	@FXML
	private void AddCar() throws IOException {
		int an = Integer.parseInt(Ano.getText());
		Double kms = Double.parseDouble(Kilometros.getText());
		Double price = Double.parseDouble(Precio.getText());
		Coche car = new Coche(Matricula.getText(),Marca.getText(),Modelo.getText(),an,Color.getText(),kms,price);
		cd.insert(car);
	}
}
