package edu.mx.utvm.congreso.dominio;

public class Activitie {
	private int id;
	private PlaceSection placeSection;
	private String day;
	private String activitie;
	private String hour;
	private int h1;
	private int h2;
	private int capacityMax;
	private int capacityMin;
	private int asignacion;
	private String visit;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public PlaceSection getPlaceSection() {
		return placeSection;
	}
	public void setPlaceSection(PlaceSection placeSection) {
		this.placeSection = placeSection;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getActivitie() {
		return activitie;
	}
	public void setActivitie(String activitie) {
		this.activitie = activitie;
	}
	public String getHour() {
		return hour;
	}
	public void setHour(String hour) {
		this.hour = hour;
	}
	public int getH1() {
		return h1;
	}
	public void setH1(int h1) {
		this.h1 = h1;
	}
	public int getH2() {
		return h2;
	}
	public void setH2(int h2) {
		this.h2 = h2;
	}
	public int getCapacityMax() {
		return capacityMax;
	}
	public void setCapacityMax(int capacityMax) {
		this.capacityMax = capacityMax;
	}
	public int getCapacityMin() {
		return capacityMin;
	}
	public void setCapacityMin(int capacityMin) {
		this.capacityMin = capacityMin;
	}
	public int getAsignacion() {
		return asignacion;
	}
	public void setAsignacion(int asignacion) {
		this.asignacion = asignacion;
	}
	public String getVisit() {
		return visit;
	}
	public void setVisit(String visit) {
		this.visit = visit;
	}	
}
