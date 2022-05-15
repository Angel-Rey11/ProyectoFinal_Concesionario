package rey.angel.ProyectoFinal_Concesionario;

import java.io.IOException;
import java.util.List;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import rey.angel.ProyectoFinal_Concesionario.model.Dao.VentaDao;
import rey.angel.ProyectoFinal_Concesionario.model.DataObject.Venta;
import rey.angel.ProyectoFinal_Concesionario.utils.Loggers;

public class ConsultaController {
	VentaDao vd = new VentaDao();
	
	@FXML
	private TableView<Venta> tab;
	@FXML
	private TextField cons;
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
	
	/**
	 * Metodo que se inicializa al entrar a esta pantalla, muestra todas las ventas con sus clientes y 
	 * coches correspondientes
	 * Tiene un fitro para poder buscar las ventas por el DNI del cliente o la Matricula del vehiculo
	 */
	@FXML
	private void consultaMarca() throws IOException {
		try {
			List<Venta> consulta = (List<Venta>) vd.getAllForMarca(cons.getText());
			this.ConfiguraTable();
			tab.setItems(FXCollections.observableArrayList(consulta));
			Loggers.LogsInfo("Consulta realizada con exito");
		} catch (Exception e) {
			AlertErrorConsulta();
			Loggers.LogsSevere("La consulta no se ha podido realizar");
		}
		
	}
	
	/**
	 * Metodo que configura la tabla para poder añadir los campos a los atributos correspondientes
	 * Hace un set de la columna con los datos del objeto
	 */
	private void ConfiguraTable() {
		date.setCellValueFactory(venta -> {
			SimpleStringProperty ssp = new SimpleStringProperty();
			ssp.setValue(venta.getValue().getFecha_Compra().toString());
			return ssp;
		});
		
		DNI.setCellValueFactory(venta -> {
			SimpleStringProperty ssp = new SimpleStringProperty();
			ssp.setValue(venta.getValue().getCliente().getDni());
			return ssp;
		});
		
		Nombre.setCellValueFactory(venta -> {
			SimpleStringProperty ssp = new SimpleStringProperty();
			ssp.setValue(venta.getValue().getCliente().getNombre());
			return ssp;
		});
		
		Apellidos.setCellValueFactory(venta -> {
			SimpleStringProperty ssp = new SimpleStringProperty();
			ssp.setValue(venta.getValue().getCliente().getApellidos());
			return ssp;
		});
		
		Matricula.setCellValueFactory(venta -> {
			SimpleStringProperty ssp = new SimpleStringProperty();
			ssp.setValue(venta.getValue().getCoche().getMatricula());
			return ssp;
		});
		
		Marca.setCellValueFactory(venta -> {
			SimpleStringProperty ssp = new SimpleStringProperty();
			ssp.setValue(venta.getValue().getCoche().getMarca());
			return ssp;
		});
		
		Modelo.setCellValueFactory(venta -> {
			SimpleStringProperty ssp = new SimpleStringProperty();
			ssp.setValue(venta.getValue().getCoche().getModelo());
			return ssp;
		});
	}
	
	/**
     * Alerta que se muestra si la consulta no se ha podido realizar
     * @throws IOException
     */
    private void AlertErrorConsulta() throws IOException {
    	Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setHeaderText("ERROR AL CONSULTAR LOS DATOS");
        alert.setContentText("No se ha podido consultar los datos que solicita");
        Stage s = (Stage)alert.getDialogPane().getScene().getWindow();
        s.toFront();
        alert.showAndWait();
        alert.close();
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
