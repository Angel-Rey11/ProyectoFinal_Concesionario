package rey.angel.ProyectoFinal_Concesionario.Interfaces;

import java.util.Collection;

/**
 * Interfaz que implementa la clase ClienteDao para el CRUD
 * @author Angel
 *
 * @param <T> objeto Cliente
 * @param <K> clave del objeto Cliente
 */
public interface IDao<T,K> {
	boolean insert (T ob);
	T get (String id);
	Collection <T> getAll();
	boolean update (T ob);
	boolean delete (T ob);
}
