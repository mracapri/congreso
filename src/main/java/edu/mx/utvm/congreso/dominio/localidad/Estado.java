package edu.mx.utvm.congreso.dominio.localidad;


public class Estado {
	private String id;
	private String estado;

	public Estado(String id, String estado) {
		this.id = id;
		this.estado = estado;
	}
	
	public String getId() {
		return id;
	}
	public String getEstado() {
		return estado;
	}
}
