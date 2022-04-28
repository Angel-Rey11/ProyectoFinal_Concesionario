package rey.angel.ProyectoFinal_Concesionario.model.Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import rey.angel.ProyectoFinal_Concesionario.Interfaces.IDao;
import rey.angel.ProyectoFinal_Concesionario.Interfaces.IVenta;
import rey.angel.ProyectoFinal_Concesionario.model.DataObject.Cliente;
import rey.angel.ProyectoFinal_Concesionario.model.DataObject.Coche;
import rey.angel.ProyectoFinal_Concesionario.model.DataObject.Venta;
import rey.angel.ProyectoFinal_Concesionario.utils.Connect;

public class VentaDao implements IVenta<Venta, Coche>{
	private Connection miConexion;
	
	public VentaDao() {
		this.miConexion = Connect.getConnection();
	}
	
	ClienteDao cd = new ClienteDao();
	CocheDao cod = new CocheDao();

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
				Cliente c = cd.get(rs.getString(2));
				aux.setCliente(c);
				Coche co = cod.get(rs.getString(3));
				aux.setCoche(co);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean update(Venta ob) {
		boolean result = false;
		String sql = "UPDATE venta SET Fecha_Compra=? WHERE DNI=?";
		try {
			PreparedStatement sentencia = miConexion.prepareStatement(sql);
			Cliente c = cd.get(ob.getCliente().getDni()); 
			sentencia.setString(2, c.getDni());
			sentencia.setDate(1, ob.getFecha_Compra());
			sentencia.executeUpdate();
			result=true;
		} catch (SQLException e) {
			result=false;
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public Venta get(String id) {
		Venta v = null;
		String sql = "SELECT Fecha_Compra,DNI,Matricula FROM venta WHERE DNI=?";
		try {
			PreparedStatement sentencia = miConexion.prepareStatement(sql);
			sentencia.setString(1, id);
			ResultSet rs = sentencia.executeQuery();
			rs.next();
			v = new Venta();
			v.setFecha_Compra(rs.getDate(1));
			Cliente c = cd.get(rs.getString(2));
			v.setCliente(c);
			Coche co = cod.get(rs.getString(3));
			v.setCoche(co);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
