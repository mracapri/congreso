package edu.mx.utvm.congreso.mail;

import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;
@Service
public class MailService implements Runnable{
	
	@Value("${IS_PRODUCTION_MAIL}")
	private boolean isProductionMode;
	
	public static final String TEMPLATE_CONFIRMATION_ACCOUNT = "template_confirmation_account.vm";	
	public static final String TEMPLATE_SUCCESS_ACCOUNT = "template_confirmation_success.vm";
	public static final String TEMPLATE_CHANGED_PAYMENT_STATUS = "template_changed_payment_status.vm";

	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private VelocityEngine velocityEngine;
	
	private MimeMessagePreparator messagePreparator;
 
	public void sendMail(final String from, final String to,
			final String subject, final Map<String, String> model, final String template) {
 
		this.messagePreparator = new MimeMessagePreparator() {
			
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
				message.setTo(to);
				message.setSubject(subject);
				message.setFrom(from);
				String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, template, model);
				message.setText(text, true);
			}
		};
		
		Thread process = new Thread(this);
		process.start();
	}

	@Override
	public void run() {
		if(isProductionMode){
			mailSender.send(messagePreparator);	
		}		
	}
	
	
}
