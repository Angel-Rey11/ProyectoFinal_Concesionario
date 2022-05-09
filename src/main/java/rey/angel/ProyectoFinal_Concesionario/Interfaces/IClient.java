package rey.angel.ProyectoFinal_Concesionario.Interfaces;

public interface IClient {
	int getId();
	String getDni();
	String getNombre();
	String getApellidos();
	String getCorreo();
	String getTelefono();
	String getDireccion();
	String getCodigo_postal();
	void setId(int id);
	void setDni(String dni);
	void setNombre(String nombre);
	void setApellidos(String apellidos);
	void setCorreo(String correo);
	void setTelefono(String telefono);
	void setDireccion(String direccion);
	void setCodigo_postal(String codigo_postal);
	boolean equals(Object o);
	String toString();
	int hashCode();
}
