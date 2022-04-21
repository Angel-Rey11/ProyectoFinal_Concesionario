package model.DataObject;

import java.util.Date;

public class Venta {
	private Date fecha_Compra;
	private Coche coche;
	private Cliente cliente;

	public Venta() {
		
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
	
	
}
