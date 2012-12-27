package edu.mx.utvm.congreso.dominio;

public class AcademyRegisterInformation {
	private String name;
	private String investigationLines;
	private String contact;
	private University university;
	private InformationAccount informationAccount;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInvestigationLines() {
		return investigationLines;
	}
	public void setInvestigationLines(String investigationLines) {
		this.investigationLines = investigationLines;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
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