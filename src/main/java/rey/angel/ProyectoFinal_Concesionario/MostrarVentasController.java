package rey.angel.ProyectoFinal_Concesionario;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import rey.angel.ProyectoFinal_Concesionario.model.DataObject.Cliente;
import rey.angel.ProyectoFinal_Concesionario.model.DataObject.Coche;
import rey.angel.ProyectoFinal_Concesionario.model.DataObject.Venta;

public class MostrarVentasController {
	
	@FXML
	private TableView tab;
	@FXML
	private TableColumn<Venta, Cliente> cliente;
	@FXML
	private TableColumn<Venta, Coche> coche;
	@FXML
	private TableColumn<Venta, Date> date;
	
	@FXML
	private void switchToInicio() throws IOException {
		App.setRoot("Inicio");
	}
	
	@FXML
	private void switchToCoche() throws IOException {
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
	
	
}
