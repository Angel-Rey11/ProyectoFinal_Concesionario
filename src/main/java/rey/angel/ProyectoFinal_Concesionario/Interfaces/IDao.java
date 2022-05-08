package rey.angel.ProyectoFinal_Concesionario.Interfaces;

import java.util.Collection;

/**
 * Interfaz para los DAO de cliente y vehiculo
 * Crud basico de insertar, buscar, buscar todos, modificar y eliminar
 * @author Angel
 *
 * @param <T> objeto
 * @param <K> clave de ese objeto
 */
public interface IDao<T,K> {
	boolean insert (T ob);
	T get (K id);
	Collection <T> getAll();
	boolean update (T ob);
	boolean delete (T ob);
}
