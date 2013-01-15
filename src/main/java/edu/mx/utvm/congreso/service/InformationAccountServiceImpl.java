package edu.mx.utvm.congreso.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import edu.mx.utvm.congreso.dao.impl.InformationAccountDaoImpl;
import edu.mx.utvm.congreso.dominio.InformationAccount;
import edu.mx.utvm.congreso.mail.MailService;
@Service
public class InformationAccountServiceImpl implements InformationAccountService{

	@Autowired
	private InformationAccountDaoImpl accountDao;
	
	@Autowired
	private MailService mail;
	
	@Value("${MAIL_SENDER}")
	private String mailSender;
	
	@Value("${URL_LOGIN}")
	private String urlLogin;
	
	@Override
	public boolean existEmailAccount(String email) {
		InformationAccount findAccountWithEmail = accountDao.findAccountWithEmail(email);
		if(findAccountWithEmail == null){
			return false;
		}else {
			return true;
		}
	}

	@Override
	public void save(InformationAccount account) {
		accountDao.create(account);
	}

	@Override
	public void confirmToken(String token, Map<String, String> params) {
		params.put("url", urlLogin);
		accountDao.confirmToken(token);		
		mail.sendMail(
			mailSender, 
			params.get("usuario"), 
			"Confirmación de cuenta",
			params, 
			MailService.TEMPLATE_SUCCESS_ACCOUNT
		);
	}
}
