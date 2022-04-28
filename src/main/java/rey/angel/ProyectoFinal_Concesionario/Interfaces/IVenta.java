package rey.angel.ProyectoFinal_Concesionario.Interfaces;

import java.util.Collection;

import rey.angel.ProyectoFinal_Concesionario.model.DataObject.Cliente;
import rey.angel.ProyectoFinal_Concesionario.model.DataObject.Coche;

public interface IVenta<T,K> {
	boolean insert (T ob);
	T get (String id);
	Collection <T> getAll();
	boolean update (T ob);
}
