package edu.mx.utvm.congreso.dominio;

public class UserRole {
	
	public static final String ROLE_REGISTER_PARTICIPATION = "ROLE_REGISTER_PARTICIPATION";
	public static final String ROLE_PREREGISTER = "ROLE_PREREGISTER";
	public static final String ROLE_PREREGISTERED_SUCCESS = "ROLE_PREREGISTERED_SUCCESS";
	public static final String ROLE_PREREGISTERED = "ROLE_PREREGISTERED";
	public static final String ROLE_PREREGISTERED_SUCCESS_PAYMENT = "ROLE_PREREGISTERED_SUCCESS_PAYMENT";
	
	
	private String userId;
	private String authority;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
}
