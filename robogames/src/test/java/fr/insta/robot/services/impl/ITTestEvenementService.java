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

public class ITTestEvenementService {

	@Test
	public void testCreateEvenement() throws DonneesInexistantException, FonctionnelleException{
		ActionUserServiceImpl actionService = new ActionUserServiceImpl();
		UserEntity user = actionService.findUserById(Long.parseLong("107"));
	
		//Ceation d'un evenement
		ActionEvenementServiceImpl evenementService = new ActionEvenementServiceImpl();
		Calendar c = Calendar.getInstance();
		c.set(2015, Calendar.DECEMBER, 10);
		Calendar d = Calendar.getInstance();
		d.set(2015,Calendar.DECEMBER, 15);
		//ajout d'un evenement
		EvenementEntity evenement = evenementService.createEvenement(user,"Fighting robot",c.getTime(), d.getTime(), "17, rue Linné", "Paris", 75011, 100, 15, "combat de robots evenement");
		Assert.assertNotNull(evenement);
	}
	@Test 
	public void testUpdateEvenement() throws FonctionnelleException, DonneesInexistantException{
		ActionUserService actionService = new ActionUserServiceImpl();
		UserEntity user = actionService.findUserById(Long.parseLong("107"));
		ActionEvenementService actionEveService = new ActionEvenementServiceImpl();
		EvenementEntity evenement = actionEveService.findByNameEvenement("Fighting robot");
		actionEveService.updateEvenement(user, evenement.getId(),null, null, "2 ruelle aux loups", "Bussy", 75000, 10, 15, "oeoeo");
		Assert.assertEquals("Bussy", evenement.getVille());
	}

	@Test
	public void testDebriefEvenement() throws DonneesInexistantException, FonctionnelleException{

		ActionEvenementServiceImpl evenementService = new ActionEvenementServiceImpl();
		EvenementEntity evenement = evenementService.findByNameEvenement("Fighting robot");
		ActionDebriefService debriefService = new ActionDebriefServiceImpl();
		
		debriefService.addDebriefEvenement(evenement, "c'etait un match incroyable");
		Assert.assertEquals("c'etait un match incroyable", evenement.getDebrief().getDebrief());
	}
	
/*	@Test
	public void testFindByUser(){
		ActionUserService userService = new ActionUserServiceImpl();
		UserEntity user = userService.findUserById(new Long(103));
		ActionEvenementService eventService = new ActionEvenementServiceImpl();
		System.out.println(eventService.findAllEventByUser(user));
	}
	@Test
	public void testEvenementAdd() throws DonneesInexistantException, FonctionnelleException{
		ActionUserService userService = new ActionUserServiceImpl();
		UserEntity user = userService.findUserById(new Long(103));
		ActionEvenementService eventService = new ActionEvenementServiceImpl();
		Calendar c = Calendar.getInstance();
		c.set(2015, 12, 1, 12, 00, 00);
		Calendar d = Calendar.getInstance();
		d.set(2015, 12, 1, 14, 00, 00);
	
		eventService.createEvenement(user,"Lego Ope123n",c.getTime(), d.getTime(), "17, rue Linné", "Paris", 75011, 100, 15, "combat de robots evenement");
	}*/
	@Test
	public void testListEvenement(){
		ActionEvenementService eventService = new ActionEvenementServiceImpl();
		System.out.println(eventService.findAllEnvenement());
	}
	


}
