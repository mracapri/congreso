package edu.mx.utvm.congreso.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.tanesha.recaptcha.ReCaptchaImpl;
import net.tanesha.recaptcha.ReCaptchaResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class SecurityHandler implements AuthenticationSuccessHandler, AuthenticationFailureHandler{	
	
	@Value("${CAPTCHA_PRIVATE_KEY}")
	private String captchaPrivateKey;
	
	@Value("${IS_PRODUCTION_LOGIN}")
	private boolean isProductionMode;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication) throws IOException,
			ServletException {
		
		if(isProductionMode){
			String recaptchaChallenge = request.getParameter("recaptcha_challenge_field");
			String recaptchaResponse = request.getParameter("recaptcha_response_field");
	        ReCaptchaImpl reCaptcha = new ReCaptchaImpl();
	        reCaptcha.setPrivateKey(captchaPrivateKey);
	        
	        String remoteAddr = request.getRemoteAddr();
	        
	        /* valid captcha */
	        ReCaptchaResponse reCaptchaResponse = reCaptcha.checkAnswer(
	        		remoteAddr, 
	        		recaptchaChallenge, 
	        		recaptchaResponse);
	        
	        if(!reCaptchaResponse.isValid()){
	        	authentication.setAuthenticated(false);
	        }
		}
						
		if (authentication != null && authentication.isAuthenticated()) {
			response.sendRedirect("resolver/index.htm?unshow-message");
		}else{
			response.sendRedirect("resolver/login.htm");
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
		response.sendRedirect("resolver/login.htm");
	}

}
	