package rey.angel.ProyectoFinal_Concesionario.model.DataObject;

import java.util.Objects;

import rey.angel.ProyectoFinal_Concesionario.Interfaces.IClient;

public class Cliente implements IClient{
	private int id;
	private String dni;
	private String nombre;
	private String apellidos;
	private String correo;
	private String telefono;
	private String direccion;
	private String codigo_postal;
	
	public Cliente() {
		
	}

	public Cliente(int id, String dni, String nombre, String apellidos, String correo, String telefono,
			String direccion, String codigo_postal) {
		super();
		this.id = id;
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.correo = correo;
		this.telefono = telefono;
		this.direccion = direccion;
		this.codigo_postal = codigo_postal;
	}
	
	public Cliente(String dni, String nombre, String apellidos, String correo, String telefono, String direccion,
			String codigo_postal) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.correo = correo;
		this.telefono = telefono;
		this.direccion = direccion;
		this.codigo_postal = codigo_postal;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCodigo_postal() {
		return codigo_postal;
	}

	public void setCodigo_postal(String codigo_postal) {
		this.codigo_postal = codigo_postal;
	}

	@Override
	public String toString() {
		return "Cliente ->" + "DNI =" + dni + ", Nombre=" + nombre + ", Apellidos=" + apellidos + ", Correo="
				+ correo + ", Telefono=" + telefono + ", Direccion=" + direccion + ", Codigo Postal=" + codigo_postal;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(dni, other.dni);
	}
	
	
	
	
}
