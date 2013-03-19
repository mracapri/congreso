package edu.mx.utvm.congreso.dominio;

import java.util.ArrayList;
import java.util.List;

public class ListAssistenceForActivitie {
	private List<String> names = new ArrayList<String>();
	private String nameActivitie = "";
	public List<String> getNames() {
		return names;
	}
	public void setNames(List<String> names) {
		this.names = names;
	}
	public String getNameActivitie() {
		return nameActivitie;
	}
	public void setNameActivitie(String nameActivitie) {
		this.nameActivitie = nameActivitie;
	}
}
