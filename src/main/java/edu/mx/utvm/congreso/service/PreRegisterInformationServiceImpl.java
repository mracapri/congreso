package edu.mx.utvm.congreso.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import edu.mx.utvm.congreso.dominio.PreRegisterInformation;
import edu.mx.utvm.congreso.mail.MailService;
import edu.mx.utvm.congreso.mail.MailServiceImpl;
import edu.mx.utvm.congreso.util.Util;
@Service
public class PreRegisterInformationServiceImpl implements PreRegisterInformationService{

	@Autowired
	private MailService mail;
	
	@Value("${URL_CONFIRM_PREREGISTER}")
	private String urlConfirm;
	
	@Value("${MAIL_SENDER}")
	private String mailSender;		
	
	@Override
	public void save(PreRegisterInformation preRegisterInformation) {

    	/* Build name */
    	StringBuffer nombre = new StringBuffer();
    	nombre.append(preRegisterInformation.getName() + " ");
    	nombre.append(preRegisterInformation.getSecondName() + " ");
    	nombre.append(preRegisterInformation.getThirdName() + " ");
    	
		/* Generate token */
		String token = Util.generateToken();
		
		/* Generate url confirm */
		String urlConfirm = this.urlConfirm + token;
		
		/* Mapa de propiedades */
    	Map<String, String> model = new HashMap<String, String>();
    	model.put("nombre", nombre.toString());
    	model.put("url", urlConfirm);
    	
		mail.sendMail(mailSender, preRegisterInformation.getInformationAccount().getEmail(),
				"Confirmación de cuenta", model, MailServiceImpl.TEMPLATE_PREREGISTER_CONFIRMATION);
	}

}
