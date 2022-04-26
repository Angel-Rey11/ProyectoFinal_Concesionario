package rey.angel.ProyectoFinal_Concesionario.model.DataObject;

import java.util.Date;
import java.util.List;

public class Venta {
	private Date fecha_Compra;
	private Coche coche;
	private Cliente cliente;
	List<Cliente> misClientes;
	List<Coche> misCoches;

	public Venta() {
		
	}
	
	public Venta(Date fecha_Compra, Coche coche, Cliente cliente, List<Cliente> misClientes, List<Coche> misCoches) {
		this.fecha_Compra = fecha_Compra;
		this.coche = coche;
		this.cliente = cliente;
		this.misClientes = misClientes;
		this.misCoches = misCoches;
	}



	public Venta(Date fecha_Compra, Coche coche, Cliente cliente) {
		this.fecha_Compra = fecha_Compra;
		this.coche = coche;
		this.cliente = cliente;
	}

	public Date getFecha_Compra() {
		return fecha_Compra;
	}

	public void setFecha_Compra(Date fecha_Compra) {
		this.fecha_Compra = fecha_Compra;
	}

	public Coche getCoche() {
		return coche;
	}

	public void setCoche(Coche coche) {
		this.coche = coche;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getMisClientes() {
		return misClientes;
	}

	public void setMisClientes(List<Cliente> misClientes) {
		this.misClientes = misClientes;
	}

	public List<Coche> getMisCoches() {
		return misCoches;
	}

	public void setMisCoches(List<Coche> misCoches) {
		this.misCoches = misCoches;
	}
	
	
}
