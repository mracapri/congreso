package edu.mx.utvm.congreso.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import edu.mx.utvm.congreso.dao.impl.PreRegisterInformationDaoImpl;
import edu.mx.utvm.congreso.dominio.PreRegisterInformation;
import edu.mx.utvm.congreso.mail.MailService;
import edu.mx.utvm.congreso.util.Util;
@Service
public class PreRegisterInformationServiceImpl implements PreRegisterInformationService{

	@Autowired
	private MailService mail;
	
	@Autowired
	private InformationAccountService accountService;
	
	@Autowired
	private UserRoleService roleService;
	
	@Autowired	
	private PreRegisterInformationDaoImpl informationDao;
	
	@Value("${URL_CONFIRM_PREREGISTER}")
	private String urlConfirm;
	
	@Value("${MAIL_SENDER}")
	private String mailSender;
		
	
	@Override
	public void save(PreRegisterInformation preRegisterInformation) {

    	/* Build name */
    	StringBuffer nombre = new StringBuffer();
    	nombre.append(preRegisterInformation.getName()).append(" ");
    	nombre.append(preRegisterInformation.getSecondName()).append(" ");
    	nombre.append(preRegisterInformation.getThirdName()).append(" ");
    	
		/* Generate token and set to object*/
		String token = Util.generateToken(preRegisterInformation.getInformationAccount().getEmail());
		preRegisterInformation.getInformationAccount().setToken(token);
		preRegisterInformation.getInformationAccount().setReferenceKey(token);
		
		/* Generate url confirm */
		String urlConfirm = this.urlConfirm + token;
		
		/* Mapa de propiedades */
    	Map<String, String> model = new HashMap<String, String>();
    	model.put("nombre", nombre.toString());
    	model.put("url", urlConfirm);

    	System.out.println(urlConfirm);
    	
		mail.sendMail(mailSender, preRegisterInformation
				.getInformationAccount().getEmail(), "Confirmación de cuenta",
				model, MailService.TEMPLATE_PREREGISTER_CONFIRMATION);
		
		accountService.save(preRegisterInformation.getInformationAccount());
		roleService.save(preRegisterInformation.getUserRole());
		informationDao.create(preRegisterInformation);
	}


	@Override
	public List<PreRegisterInformation> findAllPreRegisters() {
		return informationDao.findAll();
	}

	@Override
	public boolean getPaymentStatus(String token) {
		return informationDao.getPaymentStatus(token);
	}


	@Override
	public void changePaymentStatus(boolean status, String token) {
		informationDao.changePaymentStatus(status, token);
	}


	@Override
	public PreRegisterInformation findPreRegisterInformationByToken(String token) {
		return informationDao.findPreRegisterInformationByToken(token);
	}
}