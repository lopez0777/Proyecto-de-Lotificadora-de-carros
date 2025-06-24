package modelo;

public class Usuario {
	private int id;
	private String codUsuario;
	private String nombreUsuario;
	private String contrasena;
	private String email;
	private boolean rbEstado;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCodUsuario() {
		return codUsuario;
	}
	public void setCodUsuario(String codUsuario) {
		this.codUsuario = codUsuario;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public boolean getisRbEstado() {
		return rbEstado;
	}
	public void setRbEstado(boolean rbEstado) {
		this.rbEstado = rbEstado;
	}

	
	
	
}
