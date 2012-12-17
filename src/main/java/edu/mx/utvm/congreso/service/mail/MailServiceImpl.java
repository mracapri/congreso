package edu.mx.utvm.congreso.service.mail;

import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;
@Service
public class MailServiceImpl implements MailService{
	
	public static final String TEMPLATE_CONFIRMATION = "mail_confirmation.vm";
	public static final String TEMPLATE_SUCCESS = "mail_success.vm";

	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private VelocityEngine velocityEngine;
 
	public void sendMail(final String from, final String to,
			final String subject, final Map<String, String> model, final String template) {
 
		MimeMessagePreparator preparator = new MimeMessagePreparator() {
			
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
		mailSender.send(preparator);
	}
}
