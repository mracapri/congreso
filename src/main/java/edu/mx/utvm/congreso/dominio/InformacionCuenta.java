package edu.mx.utvm.congreso.dominio;

public class InformacionCuenta {
	private String correo;
	private String clave;
	private String claveConfirmacion;
	
	public InformacionCuenta(String correo, String clave,
			String claveConfirmacion) {
		this.correo = correo;
		this.clave = clave;
		this.claveConfirmacion = claveConfirmacion;
	}
	
	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getClaveConfirmacion() {
		return claveConfirmacion;
	}

	public void setClaveConfirmacion(String claveConfirmacion) {
		this.claveConfirmacion = claveConfirmacion;
	}
}
