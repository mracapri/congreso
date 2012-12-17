package edu.mx.utvm.congreso.dominio;

public class Sector {
	private String id;
	private String sector;
	public Sector(String id, String sector) {
		this.id = id;
		this.sector = sector;
	}
	public String getId() {
		return id;
	}
	public String getSector() {
		return sector;
	}
}
