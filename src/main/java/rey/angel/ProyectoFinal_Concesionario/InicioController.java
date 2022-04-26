package rey.angel.ProyectoFinal_Concesionario;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputDialog;
import javafx.stage.StageStyle;
import rey.angel.ProyectoFinal_Concesionario.model.Dao.ClienteDao;
import rey.angel.ProyectoFinal_Concesionario.model.DataObject.Cliente;

public class InicioController {
	
	ClienteDao cd = new ClienteDao();
	
	@FXML
	private TableView<Cliente> tab;
	@FXML
	private TableColumn<Cliente, Integer> id;
	@FXML
	private TableColumn<Cliente, String> DNI;
	@FXML
	private TableColumn<Cliente, String> Nombre;
	@FXML
	private TableColumn<Cliente, String> Apellidos;
	@FXML
	private TableColumn<Cliente, String> Correo;
	@FXML
	private TableColumn<Cliente, String> Telefono;
	@FXML
	private TableColumn<Cliente, String> Direccion;
	@FXML
	private TableColumn<Cliente, String> Codigo_Postal;
	
	@FXML
	protected void initialize() {
		this.configuraTabla();
		List<Cliente> misClientes = (List<Cliente>) cd.getAll();
		tab.setItems(FXCollections.observableArrayList(misClientes));
	}
	
	private void configuraTabla() {
		id.setCellValueFactory(cliente ->{
			ObservableValue<Integer> ov = new SimpleIntegerProperty().asObject();
			((ObjectProperty<Integer>) ov).setValue(cliente.getValue().getId());
			return ov;
		});
		
		DNI.setCellValueFactory(cliente -> {
			SimpleStringProperty ssp = new SimpleStringProperty();
			ssp.setValue(cliente.getValue().getDni());
			return ssp;
		});
		
		Nombre.setCellValueFactory(cliente -> {
			SimpleStringProperty ssp = new SimpleStringProperty();
			ssp.setValue(cliente.getValue().getNombre());
			return ssp;
		});
		
		Apellidos.setCellValueFactory(cliente -> {
			SimpleStringProperty ssp = new SimpleStringProperty();
			ssp.setValue(cliente.getValue().getApellidos());
			return ssp;
		});
		
		Correo.setCellValueFactory(cliente -> {
			SimpleStringProperty ssp = new SimpleStringProperty();
			ssp.setValue(cliente.getValue().getCorreo());
			return ssp;
		});
		
		Telefono.setCellValueFactory(cliente -> {
			SimpleStringProperty ssp = new SimpleStringProperty();
			ssp.setValue(cliente.getValue().getTelefono());
			return ssp;
		});
		
		Direccion.setCellValueFactory(cliente -> {
			SimpleStringProperty ssp = new SimpleStringProperty();
			ssp.setValue(cliente.getValue().getDireccion());
			return ssp;
		});
		
		Codigo_Postal.setCellValueFactory(cliente -> {
			SimpleStringProperty ssp = new SimpleStringProperty();
			ssp.setValue(cliente.getValue().getCodigo_postal());
			return ssp;
		});
	}

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
    
    @FXML
    private void switchToModClient() throws IOException {
        App.setRoot("ModificaCliente");
    }
}
