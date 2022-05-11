package rey.angel.ProyectoFinal_Concesionario.model.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import rey.angel.ProyectoFinal_Concesionario.model.DataObject.Car;
import rey.angel.ProyectoFinal_Concesionario.utils.Connect;


public class CarDao extends CocheDao<Car> {
	private static Connection miConexion;
	
	public CarDao() {
		miConexion = Connect.getConnection();
	}
	
	/**
	 * Metodo para insertar un coche en la base de datos
	 * Le pasamos un coche con todos sus atributos y lo insertamos
	 * Devuelve boolean true si ha conseguido insertarlo y false si no ha podido
	 */
	@Override
	public boolean insert(Car ob) {
		boolean result=false;
		String sql = "INSERT INTO coche VALUES (?,?,?,?,?,?,?,'')";
		try {
			PreparedStatement sentencia = miConexion.prepareStatement(sql);
			sentencia.setString(1, ob.getMatricula());
			sentencia.setString(2, ob.getMarca());
			sentencia.setString(3, ob.getModelo());
			sentencia.setString(4, ob.getAno());
			sentencia.setString(5, ob.getColor());
			sentencia.setString(6, ob.getKilometros());
			sentencia.setString(7, ob.getPrecio());
			sentencia.executeUpdate();
			result=true;
		} catch (SQLException e) {
			result=false;
			e.printStackTrace();
		}
	return result;
	}
	
	/**
	 * Metodo para modificar un coche con todos sus campos menos la Matricula del coche
	 * Hace un set de todos sus atributos y se modifica
	 * Devuelve boolean true si ha podido modificar el coche y false si no ha podido
	 */
	@Override
	public boolean update(Car ob) {
		boolean result=false;
		String consulta="UPDATE coche SET Marca=?, Modelo=?, Ano=?, Color=?, Kilometros=?, "
				+ "Precio=? WHERE Matricula=?";
		try {
			PreparedStatement sentencia = miConexion.prepareStatement(consulta);
			sentencia.setString(7, ob.getMatricula());
			sentencia.setString(1, ob.getMarca());
			sentencia.setString(2, ob.getModelo());
			sentencia.setString(3, ob.getAno());
			sentencia.setString(4, ob.getColor());
			sentencia.setString(5, ob.getKilometros());
			sentencia.setString(6, ob.getPrecio());
			sentencia.executeUpdate();
			result=true;
		} catch (SQLException e) {
			result=false;
			e.printStackTrace();
		}
		return result;
	}
}
