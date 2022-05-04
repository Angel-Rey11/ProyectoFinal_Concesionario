package rey.angel.ProyectoFinal_Concesionario;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;
import rey.angel.ProyectoFinal_Concesionario.model.Dao.ClienteDao;
import rey.angel.ProyectoFinal_Concesionario.model.Dao.CocheDao;
import rey.angel.ProyectoFinal_Concesionario.model.DataObject.Cliente;
import rey.angel.ProyectoFinal_Concesionario.model.DataObject.Coche;

public class DeleteController {
	@FXML
	private DialogPane cliente;
	@FXML
	private DialogPane coche;
	@FXML
	private DialogPane mod;
	@FXML
	private TextField delCliente;
	@FXML
	private TextField delCoche;
	
	ClienteDao cd = new ClienteDao();
	CocheDao cod = new CocheDao();
	
	@FXML
	private void SwitchToInicio() throws IOException {
		App.setRoot("Inicio");
	}
	
	@FXML
	private void SwitchToCoches() throws IOException {
		App.setRoot("Coches");
	}
	
	@FXML
	private void SwitchToVentas() throws IOException {
		App.setRoot("Ventas");
	}
	
	@FXML
	private void SwitchToMenuPrincipal() throws IOException {
		App.setRoot("MenuPrincipal");
	}
	
	@FXML
	private void showDelCliente() throws IOException {
		mod.setVisible(false);
		cliente.setVisible(true);
	}
	
	@FXML
	private void showDelCoche() throws IOException {
		mod.setVisible(false);
		coche.setVisible(true);
	}
	
	@FXML
	private void delCliente() throws IOException {
		Cliente c = cd.get(delCliente.getText());
		cd.delete(c);
	}
	
	@FXML
	private void delCoche() throws IOException {
		Coche co = cod.get(delCoche.getText());
		cod.delete(co);
	}
}
