package edu.mx.utvm.congreso.service.mail;

import java.util.Map;

public interface MailService {
	void sendMail(final String from, final String to, final String subject,
			final Map<String, String> model, String template);
}
