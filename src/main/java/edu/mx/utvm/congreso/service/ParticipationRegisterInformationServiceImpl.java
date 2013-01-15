package edu.mx.utvm.congreso.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import edu.mx.utvm.congreso.dao.impl.ParticipationRegisterInformationDaoImpl;
import edu.mx.utvm.congreso.dominio.ParticipationRegisterInformation;
import edu.mx.utvm.congreso.mail.MailService;
import edu.mx.utvm.congreso.util.Util;
@Service
public class ParticipationRegisterInformationServiceImpl implements ParticipationRegisterInformationService{

	protected final Log log = LogFactory.getLog(getClass());
	
	@Autowired
	private MailService mail;
	
	@Autowired
	private InformationAccountService accountService;
	
	@Autowired
	private UserRoleService roleService;
	
	@Autowired
	private ParticipationRegisterInformationDaoImpl informationDao;
	
	@Value("${URL_CONFIRM_PARTICIPATION}")
	private String urlConfirm;
	
	@Value("${MAIL_SENDER}")
	private String mailSender;
		
	
	@Override
	public void save(ParticipationRegisterInformation participationRegisterInformation) {

    	/* Build name */
    	StringBuffer nombre = new StringBuffer();
    	nombre.append(participationRegisterInformation.getName()).append(" ");
    	nombre.append(participationRegisterInformation.getSecondName()).append(" ");
    	nombre.append(participationRegisterInformation.getThirdName()).append(" ");
    	
		/* Generate token and set to object*/
		String token = Util.generateToken(participationRegisterInformation.getInformationAccount().getEmail());
		participationRegisterInformation.getInformationAccount().setToken(token);
		participationRegisterInformation.getInformationAccount().setReferenceKey("");
		
		/* Generate url confirm */
		String urlConfirm = this.urlConfirm + token;
		
		/* Mapa de propiedades */
    	Map<String, String> model = new HashMap<String, String>();
    	model.put("nombre", nombre.toString());
    	model.put("url", urlConfirm);
    	
    	log.debug("PARTICIPATION URL: " + urlConfirm);
    	
		mail.sendMail(mailSender, participationRegisterInformation
				.getInformationAccount().getEmail(), "Confirmación de cuenta",
				model, MailService.TEMPLATE_CONFIRMATION_ACCOUNT);
		
		accountService.save(participationRegisterInformation.getInformationAccount());
		roleService.save(participationRegisterInformation.getUserRole());
		informationDao.create(participationRegisterInformation);		
	}


	@Override
	public List<ParticipationRegisterInformation> findAllParticipationRegisters() {
		return informationDao.findAll();
	}


	@Override
	public List<ParticipationRegisterInformation> findAllParticipationRegistersByParamSearch(
			String searchParameter) {
		return informationDao.findParticipationRegisterInformationByParamSearch(searchParameter);
	}


	@Override
	public ParticipationRegisterInformation findParticipationRegisterInformationByToken(
			String token) {
		return informationDao.findParticipationRegisterInformationByToken(token);
	}

}