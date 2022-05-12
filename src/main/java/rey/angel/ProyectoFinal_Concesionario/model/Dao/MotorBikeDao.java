package rey.angel.ProyectoFinal_Concesionario.model.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import rey.angel.ProyectoFinal_Concesionario.model.DataObject.MotorBike;
import rey.angel.ProyectoFinal_Concesionario.utils.Connect;

public class MotorBikeDao extends CocheDao<MotorBike> {
	private static Connection miConexion;
	
	public MotorBikeDao() {
		miConexion = Connect.getConnection();
	}
	
	/**
	 * Metodo para insertar una moto en la base de datos
	 * Le pasamos una moto con todos sus atributos y lo insertamos
	 * Devuelve boolean true si ha conseguido insertarla y false si no ha podido
	 */
	@Override
	public boolean insert(MotorBike ob) {
		boolean result=false;
		String sql = "INSERT INTO coche VALUES (?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement sentencia = miConexion.prepareStatement(sql);
			sentencia.setString(1, ob.getMatricula());
			sentencia.setString(2, ob.getMarca());
			sentencia.setString(3, ob.getModelo());
			sentencia.setString(4, ob.getAno());
			sentencia.setString(5, ob.getColor());
			sentencia.setString(6, ob.getKilometros());
			sentencia.setString(7, ob.getPrecio());
			sentencia.setString(8, ob.getCilindrada());
			sentencia.executeUpdate();
			result=true;
		} catch (SQLException e) {
			result=false;
			e.printStackTrace();
		}
	return result;
	}
	
	/**
	 * Metodo para modificar un coche con todos sus campos menos la Matricula de la moto
	 * Hace un set de todos sus atributos y se modifica
	 * Devuelve boolean true si ha podido modificar la moto y false si no ha podido
	 */
	@Override
	public boolean update(MotorBike ob) {
		boolean result=false;
		String consulta="UPDATE coche SET Marca=?, Modelo=?, Ano=?, Color=?, Kilometros=?, "
				+ "Precio=?, Cilindrada=? WHERE Matricula=?";
		try {
			PreparedStatement sentencia = miConexion.prepareStatement(consulta);
			sentencia.setString(8, ob.getMatricula());
			sentencia.setString(1, ob.getMarca());
			sentencia.setString(2, ob.getModelo());
			sentencia.setString(3, ob.getAno());
			sentencia.setString(4, ob.getColor());
			sentencia.setString(5, ob.getKilometros());
			sentencia.setString(6, ob.getPrecio());
			sentencia.setString(7, ob.getCilindrada());
			sentencia.executeUpdate();
			result=true;
		} catch (SQLException e) {
			result=false;
			e.printStackTrace();
		}
		return result;
	}

}
