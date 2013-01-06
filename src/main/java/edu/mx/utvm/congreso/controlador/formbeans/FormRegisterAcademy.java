package edu.mx.utvm.congreso.controlador.formbeans;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class FormRegisterAcademy extends FormRegisterAccount {

	@NotEmpty
	private String idInstitucionProcedencia;

	@NotEmpty
	@Size(min = 1, max = 50)
	private String nombreDelCuerpoAcademico;

	@NotEmpty
	private String lineasDeInvestigacion;
	
	@NotEmpty
	private String contacto;

	public String getIdInstitucionProcedencia() {
		return idInstitucionProcedencia;
	}

	public void setIdInstitucionProcedencia(String idInstitucionProcedencia) {
		this.idInstitucionProcedencia = idInstitucionProcedencia;
	}

	public String getNombreDelCuerpoAcademico() {
		return nombreDelCuerpoAcademico;
	}

	public void setNombreDelCuerpoAcademico(String nombreDelCuerpoAcademico) {
		this.nombreDelCuerpoAcademico = nombreDelCuerpoAcademico;
	}

	public String getLineasDeInvestigacion() {
		return lineasDeInvestigacion;
	}

	public void setLineasDeInvestigacion(String lineasDeInvestigacion) {
		this.lineasDeInvestigacion = lineasDeInvestigacion;
	}

	public String getContacto() {
		return contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}
}