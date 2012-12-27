package edu.mx.utvm.congreso.dominio;

public class ParticipationRegisterInformation {
	private String name;
	private String secondName;
	private String thirdName;
	private String phone;
	private Ocupation ocupation;
	private University university;
	private InformationAccount informationAccount;
	private String participationName;
	private byte[] participationFile;
	private String participationFileName;
	private Participation participation;
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
	public String getParticipationName() {
		return participationName;
	}
	public void setParticipationName(String participationName) {
		this.participationName = participationName;
	}
	public byte[] getParticipationFile() {
		return participationFile;
	}
	public void setParticipationFile(byte[] participationFile) {
		this.participationFile = participationFile;
	}
	public String getParticipationFileName() {
		return participationFileName;
	}
	public void setParticipationFileName(String participationFileName) {
		this.participationFileName = participationFileName;
	}
	public Participation getParticipation() {
		return participation;
	}
	public void setParticipation(Participation participation) {
		this.participation = participation;
	}
}