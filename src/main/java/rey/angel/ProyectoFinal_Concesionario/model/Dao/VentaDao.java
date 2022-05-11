package rey.angel.ProyectoFinal_Concesionario.model.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import rey.angel.ProyectoFinal_Concesionario.Interfaces.IVentaDAO;
import rey.angel.ProyectoFinal_Concesionario.model.DataObject.Cliente;
import rey.angel.ProyectoFinal_Concesionario.model.DataObject.Coche;
import rey.angel.ProyectoFinal_Concesionario.model.DataObject.Venta;
import rey.angel.ProyectoFinal_Concesionario.utils.Connect;

public class VentaDao implements IVentaDAO<Venta, Coche>{
	private Connection miConexion;
	
	public VentaDao() {
		this.miConexion = Connect.getConnection();
	}
	
	ClienteDao cd = new ClienteDao();

	/**
	 * Metodo para insertar una venta en la base de datos
	 * Le pasamos una venta con todos sus atributos, cliente y coche y lo insertamos
	 * Devuelve boolean true si ha conseguido insertarla y false si no ha podido
	 */
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
	
	/**
	 * Metodo para traer todos las ventas en una coleccion con los clientes y coches asociadas
	 * Bucle While para ir buscando todos las ventas y traer todos sus datos
	 * Se devuelve una coleccion con todos las ventas
	 */
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
				Coche co = CocheDao.get(rs.getString(3));
				aux.setCoche(co);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * Metodo para modificar una venta con todos sus campos menos el Cliente y el Coche
	 * Hace un set de todos sus atributos y se modifica
	 * Devuelve boolean true si ha podido modificar la venta y false si no ha podido
	 */
	@Override
	public boolean update(Venta ob) {
		boolean result = false;
		String sql = "UPDATE venta SET Fecha_Compra=? WHERE Matricula=?";
		try {
			PreparedStatement sentencia = miConexion.prepareStatement(sql);
			Coche c = CocheDao.get(ob.getCoche().getMatricula());
			sentencia.setString(2, c.getMatricula());
			sentencia.setDate(1, ob.getFecha_Compra());
			sentencia.executeUpdate();
			result=true;
		} catch (SQLException e) {
			result=false;
			e.printStackTrace();
		}
		
		return result;
	}

	/**
	 * Metodo para buscar una venta segun su DNI de ese cliente asociado, recogemos todos los datos de esa
	 * venta y lo devolvemos
	 * Venta que devolvemos con todos sus datos
	 */
	@Override
	public Venta get(String id) {
		Venta v = null;
		String sql = "SELECT Fecha_Compra,DNI,Matricula FROM venta WHERE Matricula=?";
		try {
			PreparedStatement sentencia = miConexion.prepareStatement(sql);
			sentencia.setString(1, id);
			ResultSet rs = sentencia.executeQuery();
			rs.next();
			v = new Venta();
			v.setFecha_Compra(rs.getDate(1));
			Cliente c = cd.get(rs.getString(2));
			v.setCliente(c);
			Coche co = CocheDao.get(rs.getString(3));
			v.setCoche(co);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return v;
	}

}
