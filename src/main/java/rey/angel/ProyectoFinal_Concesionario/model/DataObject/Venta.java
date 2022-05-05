package rey.angel.ProyectoFinal_Concesionario.model.DataObject;

import java.sql.Date;


public class Venta {
	private Date fecha_Compra;
	private Cliente cliente;
	private Coche coche;

	public Venta() {
		
	}

	public Venta(Date fecha_Compra, Cliente cliente, Coche coche) {
		super();
		this.fecha_Compra = fecha_Compra;
		this.cliente = cliente;
		this.coche = coche;
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

	@Override
	public String toString() {
		return "Venta [fecha_Compra=" + fecha_Compra + ", cliente=" + cliente + ", coche=" + coche + "]";
	}
	
	
}
