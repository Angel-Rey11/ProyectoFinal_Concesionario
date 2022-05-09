package rey.angel.ProyectoFinal_Concesionario;

import java.io.IOException;
import java.time.format.FormatStyle;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
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
	
	/**
	 * Metodo que añade todos los clientes y coches a los choiceBox para poder elegirlos después
	 * Metodo añadido al boton Añadir venta
	 * @throws IOException
	 */
	@FXML
	private void addSell() throws IOException {
		try {
			List<Cliente> misClientes = (List<Cliente>) cd.getAll();
			List<Coche> misCoches = (List<Coche>) cod.getAll();
			cliente.getItems().addAll(misClientes);
			coche.getItems().addAll(misCoches);
			AlertLoad();
		} catch(Exception e) {
			AlertErrorLoad();
		}
		
	}
	
	/**
	 * Metodo que recoge los valores de los campos, de los choiceBox y del calendario
	 * Crea una nueva venta con esos campos y lo inserta a la base de datos
	 * Muestra alertas si se ha podido insertar la venta o no
	 * @throws IOException
	 */
	@FXML
	private void SaveAndAdd() throws IOException {
		try {
			java.sql.Date data = java.sql.Date.valueOf(date.getValue()); 
			Cliente cli = (Cliente) cliente.getValue();
			Coche co = (Coche) coche.getValue();
			Venta v = new Venta(data,cli,co);
			vd.insert(v);
			date.getEditor().clear();
			cliente.getSelectionModel().clearSelection();
			coche.getSelectionModel().clearSelection();
			AlertAdd();
		} catch (Exception e) {
			AlertError();
		}
	}
	
	/**
	 * Metodo que configura el datePicker con el formato de fecha Long
	 */
	@FXML
	private void ConfiguraData() {
		date.setConverter(new LocalDateStringConverter(FormatStyle.LONG));
	}
	
	/**
	 * Metodo añadido al boton modificar venta para mostrar el panel de dialogo y ocultar el boton de guardar e
	 * insertar venta
	 * @throws IOException
	 */
	@FXML
	private void ModifyMenu() throws IOException {
		mod.setVisible(true);
		bot2.setVisible(false);
		
	}
	
	/**
	 * Metodo para modificar la fecha de la venta, recoge el DNI del cliente si es correcto y busca la venta
	 * con ese cliente, hace un set en los campos correspondientes con esos valores
	 * Muestra alerta si no ha encontrado el cliente o no existe
	 * @throws IOException
	 */
	@FXML
	private void ModifySell() throws IOException {
		if (modifica.getText().matches("^[0-9]{7,8}[A-Z]$")) {
		Venta v = vd.get(modifica.getText());
		date.setValue(v.getFecha_Compra().toLocalDate());
		cliente.setValue(v.getCliente());
		coche.setValue(v.getCoche());
		mod.setVisible(false);
		bot.setVisible(true);
		cliente.setDisable(true);
		coche.setDisable(true);
	} else {
		AlertErrorMod();
	}
	}
	
	/**
	 * Metodo que recoge el campo de fecha de compra si esta modificado o no, crea una nueva venta con esos datos
	 * y lo modifica
	 * Limpia todos los campos despues de modificar
	 * Muestra alerta si se ha podido modificar la venta
	 * @throws IOException
	 */
	@FXML
	private void saveModify() throws IOException {
		java.sql.Date data = java.sql.Date.valueOf(date.getValue()); 
		Cliente cli = (Cliente) cliente.getValue();
		Coche co = (Coche) coche.getValue();
		Venta v = new Venta(data,cli,co);
		vd.update(v);
		date.getEditor().clear();
		cliente.getSelectionModel().clearSelection();
		coche.getSelectionModel().clearSelection();
		bot2.setVisible(true);
		bot.setVisible(false);
		cliente.setDisable(false);
		coche.setDisable(false);
		date.getEditor().clear();
		cliente.getSelectionModel().clearSelection();
		coche.getSelectionModel().clearSelection();
		AlertMod();
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
	 * Metodo para cambiar a la pantalla de coches
	 * @throws IOException que muestra si no se puede cambiar de pantalla al pulsar el botón
	 */
	@FXML
	private void switchToCoches() throws IOException {
		App.setRoot("Coches");
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
	 * Metodo para cambiar a la pantalla de mostrar ventas
	 * @throws IOException que muestra si no se puede cambiar de pantalla al pulsar el botón
	 */
	@FXML
	private void switchToShowSells() throws IOException {
		App.setRoot("MostrarVentas");
	}
	
	/**
	 * Alerta que se muestra si se ha podido añadir la venta
	 * @throws IOException
	 */
	private void AlertAdd() throws IOException {
    	Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("INFORMACION");
        alert.setHeaderText("VENTA AÑADIDA");
        alert.setContentText("La venta se ha añadido correctamente");
        alert.show();
        Stage s = (Stage)alert.getDialogPane().getScene().getWindow();
        s.toFront();
    }
    
	/**
	 * Alerta que se muestra si no se ha podido añadir la venta
	 * @throws IOException
	 */
    private void AlertError() throws IOException {
    	Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setHeaderText("ERROR AL AÑADIR LA VENTA");
        alert.setContentText("Los datos introducidos de la venta no son correctos");
        alert.show();
        Stage s = (Stage)alert.getDialogPane().getScene().getWindow();
        s.toFront();
    }
    
    /**
     * Alerta que se muestra si no encuentra el DNI del cliente o no cumple el formato
     * @throws IOException
     */
    private void AlertErrorMod() throws IOException {
    	Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setHeaderText("ERROR AL MODIFICAR LA VENTA");
        alert.setContentText("Los datos introducidos de la venta no son correctos o no existe");
        alert.show();
        Stage s = (Stage)alert.getDialogPane().getScene().getWindow();
        s.toFront();
    }
    
    /**
     * Alerta que se muestra si se ha podido modificar la venta
     * @throws IOException
     */
    private void AlertMod() throws IOException {
    	Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("INFORMACIÓN");
        alert.setHeaderText("SE HA MODIFICADO LA VENTA CORRECTAMENTE");
        alert.setContentText("Se ha guardado los cambios de la venta correctamente");
        alert.show();
        Stage s = (Stage)alert.getDialogPane().getScene().getWindow();
        s.toFront();
    }
    
    /**
     * Alerta que se muestra si se ha podido cargar los datos
     * @throws IOException
     */
    private void AlertLoad() throws IOException {
    	Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("INFORMACIÓN");
        alert.setHeaderText("SE HAN CARGADO LOS DATOS CORRECTAMENTE");
        alert.setContentText("Se han cargado los datos correctamente");
        alert.show();
        Stage s = (Stage)alert.getDialogPane().getScene().getWindow();
        s.toFront();
    }
    
    /**
     * Alerta que se muestra si no se cargan los datos correctamente
     * @throws IOException
     */
    private void AlertErrorLoad() throws IOException {
    	Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setHeaderText("ERROR AL CARGAR LOS DATOS");
        alert.setContentText("Los datos no se han podido cargar correctamente");
        alert.show();
        Stage s = (Stage)alert.getDialogPane().getScene().getWindow();
        s.toFront();
    }
}
