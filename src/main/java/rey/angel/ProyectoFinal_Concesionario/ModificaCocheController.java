package rey.angel.ProyectoFinal_Concesionario;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;
import rey.angel.ProyectoFinal_Concesionario.model.Dao.CocheDao;
import rey.angel.ProyectoFinal_Concesionario.model.DataObject.Coche;

public class ModificaCocheController {
	
	CocheDao cd = new CocheDao();

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
	private TextField precio;
	@FXML
	private DialogPane mod;
	@FXML
	private TextField modifica;
	
	@FXML
	private void ModifyCar() throws IOException {
			Coche c = cd.get(modifica.getText());
			Matricula.setText(c.getMatricula());
			Marca.setText(c.getMarca());
			Modelo.setText(c.getModelo());
			Ano.setText(c.getAno());
			Color.setText(c.getColor());
			Kms.setText(c.getKilometros());
			precio.setText(c.getPrecio());
			mod.setVisible(false);	
	}
	
	@FXML
	private void SaveChanges() throws IOException {
		Coche car = new Coche (Matricula.getText(),Marca.getText(),Modelo.getText(),Ano.getText(),Color.getText(),Kms.getText(),precio.getText());
		cd.update(car);
	}
	
	@FXML
    private void switchToCoches() throws IOException {
        App.setRoot("Coches");
    }
	
	@FXML
    private void switchToInicio() throws IOException {
        App.setRoot("Inicio");
    }
}
