package model.Dao;

import java.util.Collection;

import Interfaces.IDao;
import model.DataObject.Coche;

public class CocheDao implements IDao<Coche, String>{

	@Override
	public boolean insert(Coche ob) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Coche get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Coche> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Coche ob) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Coche ob) {
		// TODO Auto-generated method stub
		return 0;
	}

}
