package banco;

public class Cliente {
	private String DNI;
	private String Nombre;
	private String Apellidos;
	private String Direccion;
	private String Telefono;
	
	Cliente(){
		this.setDNI("");
		this.setNombre("");
		this.setApellidos("");
		this.setDireccion("");
		this.setTelefono("");
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellidos() {
		return Apellidos;
	}

	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}

	public String getDireccion() {
		return Direccion;
	}

	public void setDireccion(String direccion) {
		Direccion = direccion;
	}

	public String getTelefono() {
		return Telefono;
	}

	public void setTelefono(String telefono) {
		Telefono = telefono;
	}

	public String toString() {
		return "_________________________________________________________________\nNombre: "+getNombre()+" "+getApellidos()+"\nDNI:"+getDNI()+"\nDireccion: "+getDireccion()+"\nTelefono: "+getTelefono()+"\n_________________________________________________________________";
	}
	
}
