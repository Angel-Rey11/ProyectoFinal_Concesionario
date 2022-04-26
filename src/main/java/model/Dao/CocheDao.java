package model.Dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import Interfaces.IDao;
import model.DataObject.Coche;
import rey.angel.ProyectoFinal_Concesionario.ErrorModController;
import utils.Connect;

public class CocheDao implements IDao<Coche, String>{
	private Connection miConexion;
	
	public CocheDao() {
	}

	public CocheDao(Connection miConexion) {
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
			sentencia.setInt(4, ob.getAno());
			sentencia.setString(5, ob.getColor());
			sentencia.setDouble(6, ob.getKilometros());
			sentencia.setDouble(6, ob.getPrecio());
			sentencia.executeUpdate();
			result=true;
		} catch (SQLException e) {
			result=false;
			e.printStackTrace();
		}
	return result;
	}

	@Override
	public Coche get(String id) {
		Coche c = null;
		String sql = "SELECT Matricula,Marca,Modelo,Ano,Color,Kilometros,Precio FROM coche WHERE Matricula=?";
		try {
			PreparedStatement sentencia = miConexion.prepareStatement(sql);
			sentencia.setString(1, id);
			ResultSet rs = sentencia.executeQuery();
			if (rs.next()) {
				c = new Coche();
				c.setMatricula(rs.getString(1));
				c.setMarca(rs.getString(2));
				c.setModelo(rs.getString(3));
				c.setAno(rs.getInt(4));
				c.setColor(rs.getString(5));
				c.setKilometros(rs.getDouble(6));
				c.setPrecio(rs.getDouble(7));
			} else {
				try {
					new ErrorModController().InitError();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

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
				aux.setAno(rs.getInt(4));
				aux.setColor(rs.getString(5));
				aux.setKilometros(rs.getDouble(6));
				aux.setPrecio(rs.getDouble(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean update(Coche ob) {
		boolean result=false;
		String consulta="UPDATE coche SET Matricula=?, Marca=?, Modelo=?, Ano=?, Color=?, Kilometros=?, "
				+ "Precio=? WHERE Matricula=?";
		try {
			PreparedStatement sentencia = miConexion.prepareStatement(consulta);
			sentencia.setString(8, ob.getMatricula());
			sentencia.executeUpdate();
			Coche c = get(ob.getMatricula());
			ob.setMatricula(c.getMatricula());
			ob.setMarca(c.getMarca());
			ob.setModelo(c.getModelo());
			ob.setAno(c.getAno());
			ob.setColor(c.getColor());
			ob.setKilometros(c.getKilometros());
			ob.setPrecio(c.getPrecio());
			result=true;
		} catch (SQLException e) {
			result=false;
			e.printStackTrace();
		}
		
		return result;
	}

}
