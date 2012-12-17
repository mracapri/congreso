package edu.mx.utvm.congreso.dominio;

public class Ocupacion {
	private String id;
	private String ocupacion;
	public Ocupacion(String id, String ocupacion) {
		this.id = id;
		this.ocupacion = ocupacion;
	}
	public String getId() {
		return id;
	}
	public String getOcupacion() {
		return ocupacion;
	}
}
