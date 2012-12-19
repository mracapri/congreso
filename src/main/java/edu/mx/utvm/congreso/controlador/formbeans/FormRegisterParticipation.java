package edu.mx.utvm.congreso.controlador.formbeans;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class FormRegisterParticipation extends FormRegisterAccount {

	@NotEmpty
	private String idInstitucionProcedencia;

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
	private String telefono;

	@NotEmpty
	private String idOcupacion;

	@NotEmpty
	@Size(min = 1, max = 50)
	private String nombreDeLaParticipacion;

	@NotEmpty
	private String idTipoParticipacion;
	
	private CommonsMultipartFile archivo;

	public String getIdInstitucionProcedencia() {
		return idInstitucionProcedencia;
	}

	public void setIdInstitucionProcedencia(String idInstitucionProcedencia) {
		this.idInstitucionProcedencia = idInstitucionProcedencia;
	}

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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getIdOcupacion() {
		return idOcupacion;
	}

	public void setIdOcupacion(String idOcupacion) {
		this.idOcupacion = idOcupacion;
	}

	public String getNombreDeLaParticipacion() {
		return nombreDeLaParticipacion;
	}

	public void setNombreDeLaParticipacion(String nombreDeLaParticipacion) {
		this.nombreDeLaParticipacion = nombreDeLaParticipacion;
	}

	public String getIdTipoParticipacion() {
		return idTipoParticipacion;
	}

	public void setIdTipoParticipacion(String idTipoParticipacion) {
		this.idTipoParticipacion = idTipoParticipacion;
	}

	public CommonsMultipartFile getArchivo() {
		return archivo;
	}

	public void setArchivo(CommonsMultipartFile archivo) {
		this.archivo = archivo;
	}

}