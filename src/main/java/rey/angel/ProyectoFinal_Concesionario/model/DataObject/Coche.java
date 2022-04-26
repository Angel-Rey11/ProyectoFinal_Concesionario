package rey.angel.ProyectoFinal_Concesionario.model.DataObject;

public class Coche {
	private String matricula;
	private String marca;
	private String modelo;
	private String ano;
	private String color;
	private String kilometros;
	private String precio;
	
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

	@Override
	public String toString() {
		return "Coche [matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", ano=" + ano + ", color="
				+ color + ", kilometros=" + kilometros + ", precio=" + precio + "]";
	}
	
	

}
