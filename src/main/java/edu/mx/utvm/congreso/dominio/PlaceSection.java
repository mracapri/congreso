package edu.mx.utvm.congreso.dominio;

public class PlaceSection {
	private int id;
	private Place place;
	private String placeSection;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Place getPlace() {
		return place;
	}
	public void setPlace(Place place) {
		this.place = place;
	}
	public String getPlaceSection() {
		return placeSection;
	}
	public void setPlaceSection(String placeSection) {
		this.placeSection = placeSection;
	}	
}
