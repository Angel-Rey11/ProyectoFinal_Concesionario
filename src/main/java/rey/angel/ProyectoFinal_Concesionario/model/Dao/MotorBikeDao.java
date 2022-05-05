package rey.angel.ProyectoFinal_Concesionario.model.Dao;

import java.sql.Connection;

import rey.angel.ProyectoFinal_Concesionario.model.DataObject.Coche;
import rey.angel.ProyectoFinal_Concesionario.utils.Connect;

public class MotorBikeDao extends CocheDao {
	Connection miConexion;
	
	public MotorBikeDao() {
		this.miConexion = Connect.getConnection();
	}

	@Override
	public boolean insert(Coche ob) {
		boolean result = true;
		return result;
	}

	@Override
	public boolean update(Coche ob) {
		boolean result = true;
		return result;
	}

}
