package rey.angel.ProyectoFinal_Concesionario;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
	private TextField search;
	private List<Cliente> misClientes = (List<Cliente>) cd.getAll();
	private final ObservableList<Cliente> data = FXCollections.observableArrayList(misClientes);
	
	/**
	 * Metodo que se inicializa al entrar a esta pantalla
	 * Muestra todos los clientes en la tabla y tiene un filtro para poder buscar el cliente por el DNI
	 * Set de todos los campos correspondientes llamando al getAll del DAO de clientes
	 */
	@FXML
	protected void initialize() {
		this.configuraTabla();
		tab.setItems(FXCollections.observableArrayList(misClientes));
		FilteredList<Cliente> filteredData = new FilteredList<>(data, e -> true);
		search.setOnKeyReleased(e -> {
			search.textProperty().addListener((observableValue, oldValue, newValue) -> {
				filteredData.setPredicate((Predicate<? super Cliente>) cliente-> {
					if(newValue == null || newValue.isEmpty()) {
						return true;
					}
					if (cliente.getDni().contains(newValue)) {
						return true;
					}
					return false;
				});
			});
			SortedList<Cliente> sortedData = new SortedList<>(filteredData);
			sortedData.comparatorProperty().bind(tab.comparatorProperty());
			tab.setItems(sortedData);
		});
	}
	
	/**
	 * Metodo que configura la tabla para que pueda mostrar la información correcta según los campos
	 * Hacemos un set de las columnas a los atributos correspondientes del objeto Clientes
	 */
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
	
	/**
	 * Metodo para cambiar a la pantalla del formulario de clientes
	 * @throws IOException que muestra si no se puede cambiar de pantalla al pulsar el botón
	 */
    @FXML
    private void switchToFormulario() throws IOException {
        App.setRoot("FormularioCliente");
    }
    
    /**
	 * Metodo para cambiar a la pantalla de coches
	 * @throws IOException que muestra si no se puede cambiar de pantalla al pulsar el botón
	 */
    @FXML
    private void switchToCoches() throws IOException {
        App.setRoot("Coches");
    }
    
    /**
	 * Metodo para cambiar a la pantalla de ventas
	 * @throws IOException que muestra si no se puede cambiar de pantalla al pulsar el botón
	 */
    @FXML
    private void switchToVentas() throws IOException {
        App.setRoot("Ventas");
    }
    
    /**
	 * Metodo para cambiar a la pantalla del menu principal
	 * @throws IOException que muestra si no se puede cambiar de pantalla al pulsar el botón
	 */
    @FXML
    private void switchToMenu() throws IOException {
        App.setRoot("MenuPrincipal");
    }
    
    /**
	 * Metodo para cambiar a la pantalla de modificar cliente
	 * @throws IOException que muestra si no se puede cambiar de pantalla al pulsar el botón
	 */
    @FXML
    private void switchToModClient() throws IOException {
        App.setRoot("ModificaCliente");
    }
    
    /**
	 * Metodo para cambiar a la pantalla de eliminar cliente
	 * @throws IOException que muestra si no se puede cambiar de pantalla al pulsar el botón
	 */
    @FXML
    private void switchToDelete() throws IOException {
        App.setRoot("Delete");
    }
}
