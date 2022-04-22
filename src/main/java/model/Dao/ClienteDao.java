package model.Dao;

import java.util.Collection;

import Interfaces.IDao;
import model.DataObject.Cliente;

public class ClienteDao implements IDao<Cliente,String>{

	@Override
	public boolean insert(Cliente ob) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Cliente get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Cliente> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Cliente ob) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Cliente ob) {
		// TODO Auto-generated method stub
		return 0;
	}

}
