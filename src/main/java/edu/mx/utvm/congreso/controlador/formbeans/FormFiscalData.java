package edu.mx.utvm.congreso.controlador.formbeans;

import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

public class FormFiscalData{
	
	@NotEmpty
	@Size(min = 1, max = 200)
	private String nombreFiscal;
	
	@NotEmpty
	@Size(min = 1, max = 200)
	private String direccion;
	
	@NotEmpty
	@Size(min = 13, max = 13)
	private String rfc;

	public String getNombreFiscal() {
		return nombreFiscal;
	}

	public void setNombreFiscal(String nombreFiscal) {
		this.nombreFiscal = nombreFiscal;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
}