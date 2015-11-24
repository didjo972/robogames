package fr.insta.robot.services.impl;

import java.util.List;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import fr.insta.robot.services.MailService;

public class MailServiceImpl implements MailService {

	@Override
	public void sendMail(String subject, String text, List<String> destinataire) {
		
		final String username = "robogames75@gmail.com";
		final String password = "insta_rg";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {
			Address[] tableauAdresse = new Address[destinataire.size()];
			int i = 0;
			Address adresse = null;
			for (String dest : destinataire) {
				adresse = new InternetAddress(dest);
				tableauAdresse[i] = adresse;
				i++;
			}
			
			
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("nepasrepondre@nepasrepondre"));
			message.setRecipients(Message.RecipientType.TO, tableauAdresse);
			message.setSubject(subject);
			message.setText(text+"\nCordialement, \nL'équipe de Robogames75.");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		
	}

}
