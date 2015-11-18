package fr.insta.robot.services.impl;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;

import fr.insta.robot.bo.EvenementEntity;
import fr.insta.robot.bo.UserEntity;
import fr.insta.robot.exceptions.DonneesInexistantException;
import fr.insta.robot.exceptions.FonctionnelleException;
import fr.insta.robot.services.ActionDebriefService;
import fr.insta.robot.services.ActionEvenementService;
import fr.insta.robot.services.ActionUserService;
import fr.insta.robot.services.EvenementService;
import fr.insta.robot.services.RGServiceFactory;

public class ITTestEvenementService {

	@Test
	public void testCreateEvenement() throws DonneesInexistantException, FonctionnelleException{
		ActionUserServiceImpl actionService = new ActionUserServiceImpl();
		actionService.createUser("tang", "lam", "kingcat", "123456", "kingcat@yolo.fr",null);

		UserEntity user = actionService.findUserbyPseudo("kingcat");

		//Ceation d'un evenement
		ActionEvenementServiceImpl evenementService = new ActionEvenementServiceImpl();
		Calendar c = Calendar.getInstance();
		c.set(2015, Calendar.DECEMBER, 7);
		Calendar d = Calendar.getInstance();
		d.set(2015,Calendar.DECEMBER, 13);
		//ajout d'un evenement
		EvenementEntity evenement = evenementService.createEvenement(user,"Lego Open",c.getTime(), d.getTime(), "17, rue Linné", "Paris", 75011, 100, 15, "combat de robots evenement");

		Assert.assertEquals("Paris", evenement.getVille());
		//UserService userService = RGServiceFactory.getInstance().getUserService();

		//userService.deleteUser(user);

	}
	@Test 
	public void testUpdateEvenement() throws FonctionnelleException, DonneesInexistantException{
		ActionUserService actionService = new ActionUserServiceImpl();
		UserEntity user = actionService.findUserbyPseudo("kingcat");
		ActionEvenementService actionEveService = new ActionEvenementServiceImpl();
		actionEveService.updateEvenement(user, "Lego Open",null, null, "2 ruelle aux loups", "Bussy", 75000, 10, 15, "oeoeo");
		EvenementEntity event = actionEveService.findByNameEvenement("Lego Open");
		Assert.assertEquals("Bussy", event.getVille());
	}

	@Test 
	public void testSuppressionEvenement() throws DonneesInexistantException, FonctionnelleException{
		ActionEvenementService actionEveService = new ActionEvenementServiceImpl();
		EvenementEntity evenement = actionEveService.findByNameEvenement("Lego Open");
		EvenementService evenementService = RGServiceFactory.getInstance().getEvenementService();
		evenementService.deleteEvenement(evenement);
	}

	@Test
	public void testDebriefEvenement() throws DonneesInexistantException, FonctionnelleException{

		ActionEvenementServiceImpl evenementService = new ActionEvenementServiceImpl();
	/*	Calendar c = Calendar.getInstance();
		c.set(2015, Calendar.DECEMBER, 7);
		Calendar d = Calendar.getInstance();
		d.set(2015,Calendar.DECEMBER, 13);
		//ajout d'un evenement
		EvenementEntity evenement = evenementService.createEvenement(user,"Lego Open",c.getTime(), d.getTime(), "17, rue Linné", "Paris", 75011, 100, 15, "combat de robots evenement");
		*/
		EvenementEntity evenement = evenementService.findByNameEvenement("Lego2 Open");
		
		ActionDebriefService debriefService = new ActionDebriefServiceImpl();
		
		debriefService.addDebriefEvenement(evenement, "c'etait un match incroyable oo!");
		Assert.assertEquals("c'etait un match incroyable oo!", evenement.getDebrief().getDebrief());
	}
	
	@Test
	public void testFindByUser(){
		ActionUserService userService = new ActionUserServiceImpl();
		UserEntity user = userService.findUserById(new Long(103));
		ActionEvenementService eventService = new ActionEvenementServiceImpl();
		System.out.println(eventService.findAllEventByUser(user));
	}
	


}
