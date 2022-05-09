package rey.angel.ProyectoFinal_Concesionario.Interfaces;

public interface ICoche {
	String getMatricula();
	String getMarca();
	String getModelo();
	String getAno();
	String getColor();
	String getKilometros();
	String getPrecio();
	void setMatricula(String matricula);
	void setMarca(String marca);
	void setModelo(String modelo);
	void setAno(String ano);
	void setColor(String color);
	void setKilometros(String kilometros);
	void setPrecio(String precio);
	boolean equals(Object o);
	String toString();
	int hashCode();
}
