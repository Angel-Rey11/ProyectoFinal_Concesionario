package model.DataObject;

import java.util.List;

public class Coche {
	private String matricula;
	private String marca;
	private String modelo;
	private int ano;
	private String color;
	private Double kms;
	private double precio;
	List<Cliente> misClientes;
	
	public Coche() {
		
	}

	public Coche(String matricula, String marca, String modelo, int ano, String color, Double kms, double precio,
			List<Cliente> misClientes) {
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
		this.color = color;
		this.kms = kms;
		this.precio = precio;
		this.misClientes = misClientes;
	}

	public Coche(String matricula, String marca, String modelo, int ano, String color, Double kms, double precio) {
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
		this.color = color;
		this.kms = kms;
		this.precio = precio;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Double getKms() {
		return kms;
	}

	public void setKms(Double kms) {
		this.kms = kms;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public List<Cliente> getMisClientes() {
		return misClientes;
	}

	public void setMisClientes(List<Cliente> misClientes) {
		this.misClientes = misClientes;
	}
	
}