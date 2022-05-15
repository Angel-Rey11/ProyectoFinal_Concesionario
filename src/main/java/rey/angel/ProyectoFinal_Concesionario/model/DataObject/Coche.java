package rey.angel.ProyectoFinal_Concesionario.model.DataObject;

import rey.angel.ProyectoFinal_Concesionario.Interfaces.ICoche;

public class Coche implements ICoche{
	private String matricula;
	private String marca;
	private String modelo;
	private String ano;
	private String color;
	private String kilometros;
	private String precio;
	private String cilindrada;
	
	public Coche() {
		
	}

	public Coche(String matricula, String marca, String modelo, String ano, String color, String kilometros, String precio) {
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
		this.color = color;
		this.kilometros = kilometros;
		this.precio = precio;
	}
	
	public Coche(String matricula, String marca, String modelo, String ano, String color, String kilometros,
			String precio, String cilindrada) {
		super();
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
		this.color = color;
		this.kilometros = kilometros;
		this.precio = precio;
		this.cilindrada = cilindrada;
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

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getKilometros() {
		return kilometros;
	}

	public void setKilometros(String kilometros) {
		this.kilometros = kilometros;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}
	
	public String getCilindrada() {
		return cilindrada;
	}

	public void setCilindrada(String cilindrada) {
		this.cilindrada = cilindrada;
	}

	@Override
	public String toString() {
		return "Coche -> " + matricula + ", " + marca + " " + modelo + ", Año =" + ano + 
				", Kilometros =" + kilometros + ", Precio =" + precio + ", Cilindrada =" + cilindrada;
	}

	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		
		if (obj != null) {
			if (this == obj) {
				result=true;
			}else {
				if (getClass() == obj.getClass()) {
					Coche tmp = (Coche) obj;
					if(this.getMatricula().equals(tmp.getMatricula())) {
						result=true;
					}
				}	
			}
		}
		return result;
	}

}
