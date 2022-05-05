package rey.angel.ProyectoFinal_Concesionario.model.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import rey.angel.ProyectoFinal_Concesionario.model.DataObject.Coche;
import rey.angel.ProyectoFinal_Concesionario.utils.Connect;

public class CarDao extends CocheDao {
	private Connection miConexion;
	
	public CarDao() {
		this.miConexion = Connect.getConnection();
	}
	
	@Override
	public boolean insert(Coche ob) {
		boolean result=false;
		String sql = "INSERT INTO coche VALUES (?,?,?,?,?,?,?)";
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
	
	
	@Override
	public boolean update(Coche ob) {
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
