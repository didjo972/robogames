package fr.insta.robot.services.impl;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import fr.insta.robot.bo.EvenementEntity;
import fr.insta.robot.bo.UserEntity;
import fr.insta.robot.exceptions.DonneesInexistantException;
import fr.insta.robot.exceptions.FonctionnelleException;
import fr.insta.robot.services.RGServiceFactory;
import fr.insta.robot.services.UserService;

public class ITTestEvenementService {
	
/*	@Test
	public void testCreateEvenement() throws DonneesInexistantException, FonctionnelleException{
		
		ActionUserServiceImpl actionService = new ActionUserServiceImpl();
		actionService.createUser("tang", "lam", "kingcat", "123456", "kingcat@yolo.fr");
		
		UserService userService = RGServiceFactory.getInstance().getUserService();
		UserEntity user = userService.findUserByPseudo("kingcat");
		
		Set<EvenementEntity> evenements = new HashSet<>();
		
		ActionEvenementServiceImpl actioneveService = new ActionEvenementServiceImpl();
		Calendar c = Calendar.getInstance();
		c.set(2015, Calendar.DECEMBER, 7);
		Calendar d = Calendar.getInstance();
		d.set(2015,Calendar.DECEMBER, 13);
		
		EvenementEntity evenement1 = actioneveService.createEvenement(user, c.getTime(), d.getTime(), "17, rue Linné", "Paris", 75011, 100, 15, "combat de robots evenement");
		
		evenements.add(evenement1);
		user.setEvenements(evenements);
		
		userService.updateUser(user);
		userService.deleteUser(user);
	}*/
	
	
}
