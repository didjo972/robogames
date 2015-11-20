package fr.insta.robot.services;

import java.util.List;

public interface MailService {

	void sendMail(String subject, String text, List<String> destinataire);
	
}
