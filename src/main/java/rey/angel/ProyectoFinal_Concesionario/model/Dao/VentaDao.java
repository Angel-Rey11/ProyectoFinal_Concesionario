package rey.angel.ProyectoFinal_Concesionario.model.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import rey.angel.ProyectoFinal_Concesionario.Interfaces.IDao;
import rey.angel.ProyectoFinal_Concesionario.model.DataObject.Cliente;
import rey.angel.ProyectoFinal_Concesionario.model.DataObject.Coche;
import rey.angel.ProyectoFinal_Concesionario.model.DataObject.Venta;
import rey.angel.ProyectoFinal_Concesionario.utils.Connect;

public class VentaDao implements IDao<Venta, Cliente>{
	private Connection miConexion;
	
	public VentaDao() {
		this.miConexion = Connect.getConnection();
	}

	@Override
	public boolean insert(Venta ob) {
		boolean result = false;
		String sql = "INSERT INTO venta VALUES (?,?,?)";
		try {
			PreparedStatement sentencia = miConexion.prepareStatement(sql);
			sentencia.setDate(1, ob.getFecha_Compra());
			sentencia.setObject(2, ob.getCliente().getDni());
			sentencia.setObject(3, ob.getCoche().getMatricula());
			sentencia.executeUpdate();
			result=true;
		} catch (SQLException e) {
			result=false;
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Venta get(Cliente id) {
		
		return null;
	}

	@Override
	public Collection<Venta> getAll() {
		Collection<Venta> result = new ArrayList<Venta>();
		String consulta="SELECT Fecha_Compra,DNI,Matricula FROM venta";
		Statement st;
		try {
			st = miConexion.createStatement();
			ResultSet rs = st.executeQuery(consulta);
			while (rs.next()) {
				Venta aux = new Venta();
				result.add(aux);
				aux.setFecha_Compra(rs.getDate(1));
				aux.setCliente((Cliente) rs.getObject(2));
				aux.setCoche((Coche) rs.getObject(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean update(Venta ob) {
		
		return false;
	}

	

}
