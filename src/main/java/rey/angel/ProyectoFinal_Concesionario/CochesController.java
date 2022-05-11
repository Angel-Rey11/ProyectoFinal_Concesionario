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
import javafx.scene.control.DialogPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import rey.angel.ProyectoFinal_Concesionario.model.Dao.CocheDao;
import rey.angel.ProyectoFinal_Concesionario.model.DataObject.Coche;

public class CochesController {
	
	@FXML
	private DialogPane changeAdd;
	@FXML
	private DialogPane changeMod;
	@FXML
	private TableView<Coche> tab;
	@FXML
	private TextField search;
	@FXML
	private TableColumn<Coche, String> Matricula;
	@FXML
	private TableColumn<Coche, String> Marca;
	@FXML
	private TableColumn<Coche, String> Modelo;
	@FXML
	private TableColumn<Coche, String> Ano;
	@FXML
	private TableColumn<Coche, String> Color;
	@FXML
	private TableColumn<Coche, String> Kms;
	@FXML
	private TableColumn<Coche, String> Precio;
	@FXML
	private TableColumn<Coche, String> CC;
	private List<Coche> misCoches = (List<Coche>) CocheDao.getAll();
	private final ObservableList<Coche> data = FXCollections.observableArrayList(misCoches);
	
	/**
	 * Método que se inicia al cambiar al apartado coches donde se muestra todos los coches en una tabla
	 * Además se le aplica un filtro para poder buscar coches por matricula.
	 */
	@FXML
	protected void initialize() {
		this.configureTabla();
		tab.setItems(FXCollections.observableArrayList(misCoches));
		FilteredList<Coche> filteredData = new FilteredList<>(data, e -> true);
		search.setOnKeyReleased(e -> {
			search.textProperty().addListener((observableValue, oldValue, newValue) -> {
				filteredData.setPredicate((Predicate<? super Coche>) coche-> {
					if(newValue == null || newValue.isEmpty()) {
						return true;
					}
					if (coche.getMatricula().contains(newValue)) {
						return true;
					}
					return false;
				});
			});
			SortedList<Coche> sortedData = new SortedList<>(filteredData);
			sortedData.comparatorProperty().bind(tab.comparatorProperty());
			tab.setItems(sortedData);
		});
	}
	
	/**
	 * Metodo para configurar la tabla para mostrar los coches, se asigna cada columna a su valor correspondiente
	 * Se hace un set a la tabla de los valores que queremos mostrar
	 */
	private void configureTabla() {
		Matricula.setCellValueFactory(coche -> {
			SimpleStringProperty ssp = new SimpleStringProperty();
			ssp.setValue(coche.getValue().getMatricula());
			return ssp;
		});
		
		Marca.setCellValueFactory(coche -> {
			SimpleStringProperty ssp = new SimpleStringProperty();
			ssp.setValue(coche.getValue().getMarca());
			return ssp;
		});
		
		Modelo.setCellValueFactory(coche -> {
			SimpleStringProperty ssp = new SimpleStringProperty();
			ssp.setValue(coche.getValue().getModelo());
			return ssp;
		});
		
		Ano.setCellValueFactory(coche -> {
			SimpleStringProperty ssp = new SimpleStringProperty();
			ssp.setValue(coche.getValue().getAno());
			return ssp;
		});
		
		Color.setCellValueFactory(coche -> {
			SimpleStringProperty ssp = new SimpleStringProperty();
			ssp.setValue(coche.getValue().getColor());
			return ssp;
		});
		
		Kms.setCellValueFactory(coche -> {
			SimpleStringProperty ssp = new SimpleStringProperty();
			ssp.setValue(coche.getValue().getKilometros());
			return ssp;
		});
		
		Precio.setCellValueFactory(coche -> {
			SimpleStringProperty ssp = new SimpleStringProperty();
			ssp.setValue(coche.getValue().getPrecio());
			return ssp;
		});
		
		CC.setCellValueFactory(coche -> {
			SimpleStringProperty ssp = new SimpleStringProperty();
			ssp.setValue(coche.getValue().getCilindrada());
			return ssp;
		});
	}
	
	/**
	 * Metodo para mostrar el menu para elegir que quieres añadir
	 * @throws IOException
	 */
	@FXML
	private void showAddMenu() throws IOException {
		changeAdd.setVisible(true);
	}
	
	/**
	 * Metodo para mostrar el menu para elegir que quieres modificar
	 * @throws IOException
	 */
	@FXML
	private void showModifyMenu() throws IOException {
		changeMod.setVisible(true);
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
	 * Metodo para cambiar a la pantalla de ventas
	 * @throws IOException que muestra si no se puede cambiar de pantalla al pulsar el botón
	 */
	@FXML
    private void switchToVentas() throws IOException {
        App.setRoot("Ventas");
    }
	
	/**
	 * Metodo para cambiar a la pantalla de Menu Principal
	 * @throws IOException que muestra si no se puede cambiar de pantalla al pulsar el botón
	 */
	@FXML
    private void switchToMenu() throws IOException {
        App.setRoot("MenuPrincipal");
    }
	
	/**
	 * Metodo para cambiar a la pantalla del formulario para añadir un coche
	 * @throws IOException que muestra si no se puede cambiar de pantalla al pulsar el botón
	 */
	@FXML
    private void switchToFormularioCoches() throws IOException {
        App.setRoot("FormularioCoches");
    }
	
	/**
	 * Metodo para cambiar a la pantalla del formulario para añadir un coche
	 * @throws IOException que muestra si no se puede cambiar de pantalla al pulsar el botón
	 */
	@FXML
    private void switchToFormularioMotos() throws IOException {
        App.setRoot("FormularioMotos");
    }
	
	/**
	 * Metodo para cambiar a la pantalla de modificar un coche
	 * @throws IOException que muestra si no se puede cambiar de pantalla al pulsar el botón
	 */
	@FXML
    private void switchToModCar() throws IOException {
        App.setRoot("ModificaCoche");
    }
	
	/**
	 * Metodo para cambiar a la pantalla de modificar una moto
	 * @throws IOException que muestra si no se puede cambiar de pantalla al pulsar el botón
	 */
	@FXML
    private void switchToModMoto() throws IOException {
        App.setRoot("ModificaMoto");
    }
	
	/**
	 * Metodo para cambiar a la pantalla de eliminar vehiculo
	 * @throws IOException que muestra si no se puede cambiar de pantalla al pulsar el botón
	 */
    @FXML
    private void switchToDelete() throws IOException {
        App.setRoot("DeleteCoche");
    }
}
