package edu.mx.utvm.congreso.dominio;

public class Organizacion {
	private String nombre;
	private Sector sector;
	private Ocupacion ocupacion;

	public Organizacion(String nombre, Sector sector, Ocupacion ocupacion) {
		this.nombre = nombre;
		this.sector = sector;
		this.ocupacion = ocupacion;
	}

	public String getNombre() {
		return nombre;
	}

	public Sector getSector() {
		return sector;
	}

	public Ocupacion getOcupacion() {
		return ocupacion;
	}

}
