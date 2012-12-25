package edu.mx.utvm.congreso.dominio;

public class PreRegisterInformation {
	private String name;
	private String secondName;
	private String thirdName;
	private String phone;
	private Ocupation ocupation;
	private String email;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSecondName() {
		return secondName;
	}
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
	public String getThirdName() {
		return thirdName;
	}
	public void setThirdName(String thirdName) {
		this.thirdName = thirdName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Ocupation getOcupation() {
		return ocupation;
	}
	public void setOcupation(Ocupation ocupation) {
		this.ocupation = ocupation;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}	
}
