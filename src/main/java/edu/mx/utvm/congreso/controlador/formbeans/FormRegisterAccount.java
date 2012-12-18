package edu.mx.utvm.congreso.controlador.formbeans;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class FormRegisterAccount {
	
	@NotEmpty
	@Email
	private String correoElectronico;
	
	@NotEmpty
	@Email
	private String confirmarcorreoElectronico;	
	
	@NotEmpty
	@Size(min = 6, max = 15)
	private String clave;
	
	@NotEmpty
	@Size(min = 6, max = 15)
	private String confirmacionClave;
	
	private String claveValidator = "";

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getConfirmarcorreoElectronico() {
		return confirmarcorreoElectronico;
	}

	public void setConfirmarcorreoElectronico(String confirmarcorreoElectronico) {
		this.confirmarcorreoElectronico = confirmarcorreoElectronico;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getConfirmacionClave() {
		return confirmacionClave;
	}

	public void setConfirmacionClave(String confirmacionClave) {
		this.confirmacionClave = confirmacionClave;
	}

	public String getClaveValidator() {
		return claveValidator;
	}

	public void setClaveValidator(String claveValidator) {
		this.claveValidator = claveValidator;
	}
	
}