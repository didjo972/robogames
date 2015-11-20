package fr.insta.robot.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ITTestMailService {

	@Test
	public void testEnvoieMailNominal() {
		MailServiceImpl mailService = new MailServiceImpl();
		List<String> listDest = new ArrayList<String>();
		listDest.add("didjo972@gmail.com");
		listDest.add("tanglam77@gmail.com");
		mailService.sendMail("Test", "Voici mon test", listDest);
	}
	
}
