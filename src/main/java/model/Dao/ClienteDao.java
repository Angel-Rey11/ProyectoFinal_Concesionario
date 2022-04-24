package model.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import Interfaces.IDao;
import model.DataObject.Cliente;
import utils.Connect;

public class ClienteDao implements IDao<Cliente,String>{
	private Connection miConexion;
	
	public ClienteDao() {
	
	}

	public ClienteDao(Connection miConexion) {
		this.miConexion = Connect.getConnection();
	}

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
			sentencia.setInt(6, ob.getTelefono());
			sentencia.setString(7, ob.getDireccion());
			sentencia.setInt(8, ob.getCodigo_postal());
			sentencia.executeUpdate();
			result=true;
		} catch (SQLException e) {
			result=false;
			e.printStackTrace();
		}
	return result;
	}

	@Override
	public Cliente get(String id) {
		Cliente c = null;
		String sql = "SELECT ID,DNI,Nombre,Apellidos,Correo,Teléfono,Dirección,Codigo_Postal FROM cliente WHERE DNI=?";
		try {
			PreparedStatement sentencia = miConexion.prepareStatement(sql);
			sentencia.setString(1, id);
			ResultSet rs = sentencia.executeQuery();
			rs.next();
			c = new Cliente();
			c.setId(rs.getInt(1));
			c.setDni(rs.getString(2));
			c.setNombre(rs.getString(3));
			c.setApellidos(rs.getString(4));
			c.setCorreo(rs.getString(5));
			c.setTelefono(rs.getInt(6));
			c.setDireccion(rs.getString(7));
			c.setCodigo_postal(rs.getInt(8));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

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
				aux.setTelefono(rs.getInt(6));
				aux.setDireccion(rs.getString(7));
				aux.setCodigo_postal(rs.getInt(8));
				result.add(aux);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int update(Cliente ob) {
		int up = 0;
		String consulta="UPDATE cliente SET ID=?, DNI=?, Nombre=?, Apellidos=?, Correo=?, Teléfono=?, Dirección=?, "
				+ "Codigo_Postal=? WHERE DNI=?";
		try {
			PreparedStatement sentencia = miConexion.prepareStatement(consulta);
			sentencia.setString(9, ob.getDni());
			ResultSet rs = sentencia.executeQuery();
			rs.next();
			Cliente c = new Cliente();
			c.setId(rs.getInt(1));
			c.setDni(rs.getString(2));
			c.setNombre(rs.getString(3));
			c.setApellidos(rs.getString(4));
			c.setCorreo(rs.getString(5));
			c.setTelefono(rs.getInt(6));
			c.setDireccion(rs.getString(7));
			c.setCodigo_postal(rs.getInt(8));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return up;
	}

}
