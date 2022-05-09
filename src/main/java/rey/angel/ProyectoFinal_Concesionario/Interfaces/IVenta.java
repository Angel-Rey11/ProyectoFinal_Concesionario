package rey.angel.ProyectoFinal_Concesionario.Interfaces;

import java.sql.Date;

import rey.angel.ProyectoFinal_Concesionario.model.DataObject.Cliente;
import rey.angel.ProyectoFinal_Concesionario.model.DataObject.Coche;

public interface IVenta {
	Date getFecha_Compra();
	Cliente getCliente();
	Coche getCoche();
	void setFecha_Compra(Date fecha_Compra);
	void setCliente(Cliente cliente);
	void setCoche(Coche coche);
	boolean equals(Object o);
	String toString();
	int hashCode();
}
