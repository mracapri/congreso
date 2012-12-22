package edu.mx.utvm.congreso.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class SecurityHandler implements AuthenticationSuccessHandler, AuthenticationFailureHandler{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest arg0,
			HttpServletResponse response, Authentication authentication) throws IOException,
			ServletException {
		System.out.println("La autenticacion es correcta");
		if (authentication != null && authentication.isAuthenticated()) {
			response.sendRedirect("resolver/index.htm");
		}
		
	}

	@Override
	public void onAuthenticationFailure(HttpServletRequest arg0,
			HttpServletResponse response, AuthenticationException authenticationException)
			throws IOException, ServletException {
		
		System.out.println("Fallo la autenticacion: " + authenticationException.getMessage());
		arg0.getSession().invalidate(); // invalida la sesion
		response.getOutputStream().print(authenticationException.getMessage());
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
	}

}
	