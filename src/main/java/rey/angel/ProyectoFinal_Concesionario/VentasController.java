package rey.angel.ProyectoFinal_Concesionario;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.FormatStyle;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;
import javafx.util.converter.LocalDateStringConverter;
import rey.angel.ProyectoFinal_Concesionario.model.Dao.ClienteDao;
import rey.angel.ProyectoFinal_Concesionario.model.Dao.CocheDao;
import rey.angel.ProyectoFinal_Concesionario.model.Dao.VentaDao;
import rey.angel.ProyectoFinal_Concesionario.model.DataObject.Cliente;
import rey.angel.ProyectoFinal_Concesionario.model.DataObject.Coche;
import rey.angel.ProyectoFinal_Concesionario.model.DataObject.Venta;

public class VentasController {
	
	ClienteDao cd = new ClienteDao();
	CocheDao cod = new CocheDao();
	VentaDao vd = new VentaDao();
	
	@FXML
	private DialogPane mod;
	@FXML
	private TextField modifica;
	@FXML
	private ChoiceBox<Cliente> cliente;
	@FXML
	private ChoiceBox<Coche> coche;
	@FXML
	private DatePicker date;
	@FXML
	private Button bot;
	@FXML
	private Button bot2;
	
	@FXML
	private void addSell() throws IOException {
		List<Cliente> misClientes = (List<Cliente>) cd.getAll();
		List<Coche> misCoches = (List<Coche>) cod.getAll();
		cliente.getItems().addAll(misClientes);
		coche.getItems().addAll(misCoches);
	}
	
	@FXML
	private void SaveAndAdd() throws IOException {
		java.sql.Date data = java.sql.Date.valueOf(date.getValue()); 
		Cliente cli = (Cliente) cliente.getValue();
		Coche co = (Coche) coche.getValue();
		Venta v = new Venta(data,cli,co);
		vd.insert(v);
		date.getEditor().clear();
		cliente.getSelectionModel().clearSelection();
		coche.getSelectionModel().clearSelection();
		
	}
	
	@FXML
	private void ConfiguraData() {
		date.setConverter(new LocalDateStringConverter(FormatStyle.LONG));
	}
	
	@FXML
	private void ModifyMenu() throws IOException {
		mod.setVisible(true);
		bot2.setVisible(false);
		
	}
	
	@FXML
	private void ModifySell() throws IOException {
		Venta v = vd.get(modifica.getText());
		date.setValue(v.getFecha_Compra().toLocalDate());
		cliente.setValue(v.getCliente());
		coche.setValue(v.getCoche());
		mod.setVisible(false);
		bot.setVisible(true);
	}
	
	@FXML
	private void switchToInicio() throws IOException {
		App.setRoot("Inicio");
	}
	
	@FXML
	private void switchToCoches() throws IOException {
		App.setRoot("Coches");
	}
	
	@FXML
	private void switchToMenu() throws IOException {
		App.setRoot("MenuPrincipal");
	}
	
	@FXML
	private void switchToShowSells() throws IOException {
		App.setRoot("MostrarVentas");
	}
}
