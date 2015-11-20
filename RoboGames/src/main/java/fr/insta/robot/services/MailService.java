package fr.insta.robot.services;

public interface MailService {

	void sendMail(String subject, String text, String destinataire, String copyDest);
	
}
