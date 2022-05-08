package rey.angel.ProyectoFinal_Concesionario.utils;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

public class Connect {
	

	private static Connection con;
	private static String file = "conexion.xml";
	private static Connect _newInstance;
	
	private Connect() {
		//cargamos los datos de la conexion xml
		DatosConexion dc=load();
		//establecemos la conexion
		try {
			con =DriverManager.getConnection(dc.getServer()+"/"+dc.getDatabase(),dc.getUsername(),dc.getPassword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			con=null;
		}
	}
	
	/**
	 * Metodo del patron singleton para instanciar la conexion
	 * @return devuelve la conexion creada
	 */
	public static Connection getConnection() {
		if(_newInstance == null) {
			_newInstance = new Connect();
		}
		return con;
	}
	
	/**
	 * Metodo que carga los datos de la conexion con el fichero xml
	 * @return los datos de la conexion
	 */
	public DatosConexion load() {
		DatosConexion con = new DatosConexion();
		JAXBContext contexto;
		try {
			contexto = JAXBContext.newInstance(DatosConexion.class);
			Unmarshaller um = contexto.createUnmarshaller();
			DatosConexion newR = (DatosConexion) um.unmarshal(new File(file));
			con = newR;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return con;
		
	}
	
}
