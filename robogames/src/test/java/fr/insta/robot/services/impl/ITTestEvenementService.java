package fr.insta.robot.services.impl;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;

import fr.insta.robot.bo.EvenementEntity;
import fr.insta.robot.bo.UserEntity;
import fr.insta.robot.exceptions.DonneesInexistantException;
import fr.insta.robot.exceptions.FonctionnelleException;

public class ITTestEvenementService {

	@Test
	public void testCreateEvenement() throws DonneesInexistantException, FonctionnelleException{
		ActionUserServiceImpl actionService = new ActionUserServiceImpl();
		actionService.createUser("tang", "lam", "kingcat", "123456", "kingcat@yolo.fr");

		UserEntity user = actionService.findUserbyPseudo("kingcat");
		
		//Ceation d'un evenement
		ActionEvenementServiceImpl evenementService = new ActionEvenementServiceImpl();
		Calendar c = Calendar.getInstance();
		c.set(2015, Calendar.DECEMBER, 7);
		Calendar d = Calendar.getInstance();
		d.set(2015,Calendar.DECEMBER, 13);
		//ajout d'un evenement
		EvenementEntity evenement = evenementService.createEvenement(user, c.getTime(), d.getTime(), "17, rue Linné", "Paris", 75011, 100, 15, "combat de robots evenement");
		
		Assert.assertEquals("Paris", evenement.getVille());
	}


}
