package rey.angel.ProyectoFinal_Concesionario.model.Dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import rey.angel.ProyectoFinal_Concesionario.Interfaces.IDao;
import rey.angel.ProyectoFinal_Concesionario.model.DataObject.Cliente;
import rey.angel.ProyectoFinal_Concesionario.utils.Connect;

public class ClienteDao implements IDao<Cliente,String>{
	private Connection miConexion;
	
	public ClienteDao() {
		this.miConexion = Connect.getConnection();
	}

	/**
	 * Metodo para insertar un cliente en la base de datos
	 * Le pasamos un cliente con todos sus atributos y lo insertamos
	 * Devuelve boolean true si ha conseguido insertarlo y false si no ha podido
	 */
	@Override
	public boolean insert(Cliente ob) {
		boolean result=false;
		String sql = "INSERT INTO cliente VALUES (?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement sentencia = miConexion.prepareStatement(sql);
			sentencia.setInt(1, ob.getId());
			sentencia.setString(2, ob.getDni());
			sentencia.setString(3, ob.getNombre());
			sentencia.setString(4, ob.getApellidos());
			sentencia.setString(5, ob.getCorreo());
			sentencia.setString(6, ob.getTelefono());
			sentencia.setString(7, ob.getDireccion());
			sentencia.setString(8, ob.getCodigo_postal());
			sentencia.executeUpdate();
			result=true;
		} catch (SQLException e) {
			result=false;
			e.printStackTrace();
		}
	return result;
	}
	
	/**
	 * Metodo para buscar un cliente segun su DNI, recogemos todos los datos de ese cliente y lo devolvemos
	 * Cliente que devolvemos con todos sus datos
	 */
	@Override
	public Cliente get(String id) {
		Cliente c = null;
		String sql = "SELECT ID,DNI,Nombre,Apellidos,Correo,Teléfono,Dirección,Codigo_Postal FROM cliente WHERE DNI=?";
		try {
			PreparedStatement sentencia = miConexion.prepareStatement(sql);
			sentencia.setString(1, id);
			ResultSet rs = sentencia.executeQuery();
			if(rs.next()) {
				c = new Cliente();
				c.setId(rs.getInt(1));
				c.setDni(rs.getString(2));
				c.setNombre(rs.getString(3));
				c.setApellidos(rs.getString(4));
				c.setCorreo(rs.getString(5));
				c.setTelefono(rs.getString(6));
				c.setDireccion(rs.getString(7));
				c.setCodigo_postal(rs.getString(8));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}
	
	/**
	 * Metodo para traer todos los clientes en una coleccion
	 * Bucle While para ir buscando todos los clientes y traer todos sus datos
	 * Se devuelve una coleccion con todos los clientes
	 */
	@Override
	public Collection<Cliente> getAll() {
		Collection<Cliente> result = new ArrayList<Cliente>();
		String consulta="SELECT ID,DNI,Nombre,Apellidos,Correo,Teléfono,Dirección,Codigo_Postal FROM cliente";
		Statement st;
		try {
			st = miConexion.createStatement();
			ResultSet rs = st.executeQuery(consulta);
			while (rs.next()) {
				Cliente aux = new Cliente();
				aux.setId(rs.getInt(1));
				aux.setDni(rs.getString(2));
				aux.setNombre(rs.getString(3));
				aux.setApellidos(rs.getString(4));
				aux.setCorreo(rs.getString(5));
				aux.setTelefono(rs.getString(6));
				aux.setDireccion(rs.getString(7));
				aux.setCodigo_postal(rs.getString(8));
				result.add(aux);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * Metodo para modificar un cliente con todos sus campos menos el DNI y el ID del cliente
	 * Hace un set de todos sus atributos y se modifica
	 * Devuelve boolean true si ha podido modificar el cliente y false si no ha podido
	 */
	@Override
	public boolean update(Cliente ob) {
		boolean result = false;
		String consulta="UPDATE cliente SET Nombre=?, Apellidos=?, Correo=?, Teléfono=?, Dirección=?, "
				+ "Codigo_Postal=? WHERE DNI=?";
		try {
			PreparedStatement sentencia = miConexion.prepareStatement(consulta);
			sentencia.setString(7, ob.getDni());
			sentencia.setString(1, ob.getNombre());
			sentencia.setString(2, ob.getApellidos());
			sentencia.setString(3, ob.getCorreo());
			sentencia.setString(4, ob.getTelefono());
			sentencia.setString(5, ob.getDireccion());
			sentencia.setString(6, ob.getCodigo_postal());
			sentencia.executeUpdate();
			result=true;
		} catch (SQLException e) {
			result=false;
			e.printStackTrace();
		}
		
		return result;
	}

	
	/**
	 * Metodo para borrar el cliente, le pasamos el cliente con su DNI y lo elimina
	 * Devuelve boolean true si ha podido borrarlo y false si no ha podido
	 */
	@Override
	public boolean delete(Cliente ob) {
		boolean result = false;
		String sql = "DELETE FROM cliente WHERE DNI=?";
		try {
			PreparedStatement sentencia = miConexion.prepareStatement(sql);
			sentencia.setString(1, ob.getDni());
			sentencia.executeUpdate();
			result=true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
