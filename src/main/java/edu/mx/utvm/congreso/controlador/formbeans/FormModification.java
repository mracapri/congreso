package edu.mx.utvm.congreso.controlador.formbeans;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class FormModification{
	
	@NotEmpty
	@Size(min = 1, max = 30)
	private String nombre;
	
	@NotEmpty
	@Size(min = 1, max = 30)
	private String apellidoPaterno;
	
	@NotEmpty
	@Size(min = 1, max = 30)
	private String apellidoMaterno;
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}
	
}