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
import rey.angel.ProyectoFinal_Concesionario.model.Dao.CocheDao;
import rey.angel.ProyectoFinal_Concesionario.model.DataObject.Cliente;
import rey.angel.ProyectoFinal_Concesionario.model.DataObject.Coche;

public class CochesController {
	
	CocheDao cd = new CocheDao();
	
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
	private List<Coche> misCoches = (List<Coche>) cd.getAll();
	private final ObservableList<Coche> data = FXCollections.observableArrayList(misCoches);
	
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
	}
	
	@FXML
    private void switchToInicio() throws IOException {
        App.setRoot("Inicio");
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
    private void switchToFormularioCoches() throws IOException {
        App.setRoot("FormularioCoches");
    }
	
	@FXML
    private void switchToModCar() throws IOException {
        App.setRoot("ModificaCoche");
    }
}
