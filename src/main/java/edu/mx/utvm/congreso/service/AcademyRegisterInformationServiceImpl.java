package edu.mx.utvm.congreso.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import edu.mx.utvm.congreso.dao.impl.AcademyRegisterInformationDaoImpl;
import edu.mx.utvm.congreso.dominio.AcademyRegisterInformation;
import edu.mx.utvm.congreso.mail.MailService;
import edu.mx.utvm.congreso.util.Util;
@Service
public class AcademyRegisterInformationServiceImpl implements AcademyRegisterInformationService{

	@Autowired
	private MailService mail;
	
	@Autowired
	private InformationAccountService accountService;
	
	@Autowired
	private AcademyRegisterInformationDaoImpl informationDao;
	
	@Value("${URL_CONFIRM_PREREGISTER}")
	private String urlConfirm;
	
	@Value("${MAIL_SENDER}")
	private String mailSender;
		
	
	@Override
	public void save(AcademyRegisterInformation academyRegisterInformation) {

    	/* Build name */
    	StringBuffer nombre = new StringBuffer();
    	nombre.append(academyRegisterInformation.getName()).append(" ");
    	
		/* Generate token and set to object*/
		String token = Util.generateToken(academyRegisterInformation.getInformationAccount().getEmail());
		academyRegisterInformation.getInformationAccount().setToken(token);
		academyRegisterInformation.getInformationAccount().setReferenceKey(token);
		
		/* Generate url confirm */
		String urlConfirm = this.urlConfirm + token;
		
		/* Mapa de propiedades */
    	Map<String, String> model = new HashMap<String, String>();
    	model.put("nombre", nombre.toString());
    	model.put("url", urlConfirm);
    	
		mail.sendMail(mailSender, academyRegisterInformation
				.getInformationAccount().getEmail(), "Confirmaci�n de cuenta",
				model, MailService.TEMPLATE_PREREGISTER_CONFIRMATION);
		
		accountService.save(academyRegisterInformation.getInformationAccount());
		informationDao.create(academyRegisterInformation);
	}

}