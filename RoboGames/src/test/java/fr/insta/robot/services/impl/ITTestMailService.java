package fr.insta.robot.services.impl;

import org.junit.Test;

public class ITTestMailService {

	@Test
	public void testEnvoieMailNominal() {
		MailServiceImpl mailService = new MailServiceImpl();
		mailService.sendMail("Test", "Voici mon test", "prout", "prout");
	}
	
}
