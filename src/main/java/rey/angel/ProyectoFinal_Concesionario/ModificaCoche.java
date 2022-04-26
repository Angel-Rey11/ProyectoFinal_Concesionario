package rey.angel.ProyectoFinal_Concesionario;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;
import model.Dao.CocheDao;
import model.DataObject.Coche;

public class ModificaCoche {
	
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
			Marca.setText(c.getMatricula());
			Ano.setText(String.valueOf(c.getAno()));
			Color.setText(c.getColor());
			Kms.setText(String.valueOf(c.getKilometros()));
			precio.setText(String.valueOf(c.getPrecio()));
			mod.setVisible(false);	
	}
	
	@FXML
	private void SaveChanges() throws IOException {
		int an = Integer.parseInt(Ano.getText());
		Double kms = Double.parseDouble(Kms.getText());
		Double price = Double.parseDouble(precio.getText());
		Coche car = new Coche (Matricula.getText(),Marca.getText(),Modelo.getText(),an,Color.getText(),kms,price);
		cd.update(car);
	}
}
