package edu.mx.utvm.congreso.dominio;

public class PreRegisterInformation {
	private String name;
	private String secondName;
	private String thirdName;
	private String phone;
	private Ocupation ocupation;
	private University university;
	private InformationAccount informationAccount;
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
	public University getUniversity() {
		return university;
	}
	public void setUniversity(University university) {
		this.university = university;
	}
	public InformationAccount getInformationAccount() {
		return informationAccount;
	}
	public void setInformationAccount(InformationAccount informationAccount) {
		this.informationAccount = informationAccount;
	}	
}
