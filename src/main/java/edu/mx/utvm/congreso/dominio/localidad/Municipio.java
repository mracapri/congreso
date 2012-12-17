package edu.mx.utvm.congreso.dominio.localidad;

public class Municipio {
	private String id;
	private String municipio;
	
	public Municipio(String id, String municipio) {
		this.id = id;
		this.municipio = municipio;
	}
	
	public String getId() {
		return id;
	}
	public String getMunicipio() {
		return municipio;
	}
}
