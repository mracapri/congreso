package edu.mx.utvm.congreso.controlador.formbeans;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class FormCapture{
	
	@NotEmpty
	@Size(min = 1, max = 30)
	private String nombre;
	
	@NotEmpty
	@Size(min = 1, max = 30)
	private String apellidoPaterno;
	
	@NotEmpty
	@Size(min = 1, max = 30)
	private String apellidoMaterno;
	
	@NotEmpty
	private String idInstitucionProcedencia;	
	
	@NotEmpty
	private String idOcupacion;
	
	@NotEmpty
	@Email
	private String correoElectronico;
	

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

	public String getIdInstitucionProcedencia() {
		return idInstitucionProcedencia;
	}

	public void setIdInstitucionProcedencia(String idInstitucionProcedencia) {
		this.idInstitucionProcedencia = idInstitucionProcedencia;
	}

	public String getIdOcupacion() {
		return idOcupacion;
	}

	public void setIdOcupacion(String idOcupacion) {
		this.idOcupacion = idOcupacion;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
	
}