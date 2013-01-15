package edu.mx.utvm.congreso.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import edu.mx.utvm.congreso.dao.impl.AcademyRegisterInformationDaoImpl;
import edu.mx.utvm.congreso.dominio.AcademyRegisterInformation;
import edu.mx.utvm.congreso.mail.MailService;
import edu.mx.utvm.congreso.util.Util;
@Service
public class AcademyRegisterInformationServiceImpl implements AcademyRegisterInformationService{

	protected final Log log = LogFactory.getLog(getClass());
	
	@Autowired
	private MailService mail;
	
	@Autowired
	private InformationAccountService accountService;
	
	@Autowired
	private AcademyRegisterInformationDaoImpl informationDao;
	
	@Value("${URL_CONFIRM_ACADEMY}")
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
    	
    	log.debug("ACADEMY URL: " + urlConfirm);
    	
		mail.sendMail(mailSender, academyRegisterInformation
				.getInformationAccount().getEmail(), "Confirmación de cuenta",
				model, MailService.TEMPLATE_PREREGISTER_CONFIRMATION);
		
		accountService.save(academyRegisterInformation.getInformationAccount());
		informationDao.create(academyRegisterInformation);
	}


	@Override
	public AcademyRegisterInformation findAcademyRegisterInformationByToken(
			String token) {
		return informationDao.findAcademyRegisterInformationByToken(token);
	}


	@Override
	public List<AcademyRegisterInformation> findAllAcademyRegisterInformation() {
		return informationDao.findAll();
	}

}
