package rey.angel.ProyectoFinal_Concesionario;

import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import rey.angel.ProyectoFinal_Concesionario.model.Dao.VentaDao;
import rey.angel.ProyectoFinal_Concesionario.model.DataObject.Venta;

public class MostrarVentasController {
	
	VentaDao vd = new VentaDao();
	
	@FXML
	private TableView<Venta> tab;
	@FXML
	private TextField search;
	@FXML
	private TableColumn<Venta, String> DNI;
	@FXML
	private TableColumn<Venta, String> Nombre;
	@FXML
	private TableColumn<Venta, String> Apellidos;
	@FXML
	private TableColumn<Venta, String> Matricula;
	@FXML
	private TableColumn<Venta, String> Marca;
	@FXML
	private TableColumn<Venta, String> Modelo;
	@FXML
	private TableColumn<Venta, String> date;
	private List<Venta> misVentas = (List<Venta>) vd.getAll();
	final ObservableList<Venta> data = FXCollections.observableArrayList(misVentas);
	
	/**
	 * Metodo que se inicializa al entrar a esta pantalla, muestra todas las ventas con sus clientes y 
	 * coches correspondientes
	 * Tiene un fitro para poder buscar las ventas por el DNI del cliente o la Matricula del vehiculo
	 */
	@FXML
	private void initialize() {
		this.ConfiguraTabla();
		tab.setItems(FXCollections.observableArrayList(misVentas));
		FilteredList<Venta> filteredData = new FilteredList<>(data, e -> true);
		search.setOnKeyReleased(e -> {
			search.textProperty().addListener((observableValue, oldValue, newValue) -> {
				filteredData.setPredicate((Predicate<? super Venta>) venta-> {
					if(newValue == null || newValue.isEmpty()) {
						return true;
					}
					if (venta.getCliente().getDni().contains(newValue)) {
						return true;
					} else if (venta.getCoche().getMatricula().contains(newValue)) {
						return true;
					}
					return false;
				});
			});
			SortedList<Venta> sortedData = new SortedList<>(filteredData);
			sortedData.comparatorProperty().bind(tab.comparatorProperty());
			tab.setItems(sortedData);
		});
		
	}
	
	/**
	 * Metodo que configura la tabla para poder añadir los campos a los atributos correspondientes
	 * Hace un set de la columna con los datos del objeto
	 */
	private void ConfiguraTabla() {
		date.setCellValueFactory(venta -> {
			SimpleStringProperty ssp = new SimpleStringProperty();
			ssp.setValue(venta.getValue().getFecha_Compra().toString());
			return ssp;
		});
		
		DNI.setCellValueFactory(cliente -> {
			SimpleStringProperty ssp = new SimpleStringProperty();
			ssp.setValue(cliente.getValue().getCliente().getDni());
			return ssp;
		});
		
		Nombre.setCellValueFactory(cliente -> {
			SimpleStringProperty ssp = new SimpleStringProperty();
			ssp.setValue(cliente.getValue().getCliente().getNombre());
			return ssp;
		});
		
		Apellidos.setCellValueFactory(cliente -> {
			SimpleStringProperty ssp = new SimpleStringProperty();
			ssp.setValue(cliente.getValue().getCliente().getApellidos());
			return ssp;
		});
		
		Matricula.setCellValueFactory(coche -> {
			SimpleStringProperty ssp = new SimpleStringProperty();
			ssp.setValue(coche.getValue().getCoche().getMatricula());
			return ssp;
		});
		
		Marca.setCellValueFactory(coche -> {
			SimpleStringProperty ssp = new SimpleStringProperty();
			ssp.setValue(coche.getValue().getCoche().getMarca());
			return ssp;
		});
		
		Modelo.setCellValueFactory(coche -> {
			SimpleStringProperty ssp = new SimpleStringProperty();
			ssp.setValue(coche.getValue().getCoche().getModelo());
			return ssp;
		});
	}
	
	/**
	 * Metodo para cambiar a la pantalla del inicio
	 * @throws IOException que muestra si no se puede cambiar de pantalla al pulsar el botón
	 */
	@FXML
	private void switchToInicio() throws IOException {
		App.setRoot("Inicio");
	}
	
	/**
	 * Metodo para cambiar a la pantalla de coche
	 * @throws IOException que muestra si no se puede cambiar de pantalla al pulsar el botón
	 */
	@FXML
	private void switchToCoche() throws IOException {
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
	 * Metodo para cambiar a la pantalla del Menu Principal
	 * @throws IOException que muestra si no se puede cambiar de pantalla al pulsar el botón
	 */
	@FXML
	private void switchToMenuPrincipal() throws IOException {
		App.setRoot("MenuPrincipal");
	}
	
	
}
