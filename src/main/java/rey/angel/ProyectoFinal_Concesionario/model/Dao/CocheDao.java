package rey.angel.ProyectoFinal_Concesionario.model.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import rey.angel.ProyectoFinal_Concesionario.Interfaces.IDao;
import rey.angel.ProyectoFinal_Concesionario.model.DataObject.Coche;
import rey.angel.ProyectoFinal_Concesionario.utils.Connect;

public class CocheDao implements IDao<Coche, String>{
	private Connection miConexion;
	
	public CocheDao() {
		this.miConexion = Connect.getConnection();
	}
	
	/**
	 * Metodo para insertar un coche en la base de datos
	 * Le pasamos un coche con todos sus atributos y lo insertamos
	 * Devuelve boolean true si ha conseguido insertarlo y false si no ha podido
	 */
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

	/**
	 * Metodo para buscar un coche segun su Matricula, recogemos todos los datos de ese coche y lo devolvemos
	 * Coche que devolvemos con todos sus datos
	 */
	@Override
	public Coche get(String id) {
		Coche c = null;
		String sql = "SELECT Matricula,Marca,Modelo,Ano,Color,Kilometros,Precio FROM coche WHERE Matricula=?";
		try {
			PreparedStatement sentencia = miConexion.prepareStatement(sql);
			sentencia.setString(1, id);
			ResultSet rs = sentencia.executeQuery();
			rs.next();
				c = new Coche();
				c.setMatricula(rs.getString(1));
				c.setMarca(rs.getString(2));
				c.setModelo(rs.getString(3));
				c.setAno(rs.getString(4));
				c.setColor(rs.getString(5));
				c.setKilometros(rs.getString(6));
				c.setPrecio(rs.getString(7));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

	/**
	 * Metodo para traer todos los coches en una coleccion
	 * Bucle While para ir buscando todos los coches y traer todos sus datos
	 * Se devuelve una coleccion con todos los coches
	 */
	@Override
	public Collection<Coche> getAll() {
		Collection<Coche> result = new ArrayList<Coche>();
		String consulta="SELECT Matricula,Marca,Modelo,Ano,Color,Kilometros,Precio FROM coche";
		Statement st;
		try {
			st = miConexion.createStatement();
			ResultSet rs = st.executeQuery(consulta);
			while (rs.next()) {
				Coche aux = new Coche();
				result.add(aux);
				aux.setMatricula(rs.getString(1));
				aux.setMarca(rs.getString(2));
				aux.setModelo(rs.getString(3));
				aux.setAno(rs.getString(4));
				aux.setColor(rs.getString(5));
				aux.setKilometros(rs.getString(6));
				aux.setPrecio(rs.getString(7));
			}
		} catch (SQLException e) {
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

	/**
	 * Metodo para borrar el coche, le pasamos el coche con su Matricula y lo elimina
	 * Devuelve boolean true si ha podido borrarlo y false si no ha podido
	 */
	@Override
	public boolean delete(Coche ob) {
		boolean result = true;
		String sql = "DELETE FROM coche WHERE Matricula=?";
		try {
			PreparedStatement sentencia = miConexion.prepareStatement(sql);
			sentencia.setString(1, ob.getMatricula());
			sentencia.executeUpdate();
			result=true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
