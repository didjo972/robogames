package fr.insta.robot.services.impl;

import org.junit.Test;

import fr.insta.robot.bo.BilletEntity;
import fr.insta.robot.bo.EvenementEntity;
import fr.insta.robot.bo.UserEntity;
import fr.insta.robot.exceptions.FonctionnelleException;
import fr.insta.robot.services.ActionBilletService;
import fr.insta.robot.services.ActionEvenementService;
import fr.insta.robot.services.ActionUserService;

public class ITTestBilletService {

	@Test
	public void testBilletcreate() throws FonctionnelleException{
		ActionUserService actionUS = new ActionUserServiceImpl();
		ActionEvenementService actionES = new ActionEvenementServiceImpl();
		ActionBilletService actionBS = new ActionBilletServiceImpl();
		
		UserEntity user = actionUS.findUserById(Long.parseLong("104"));
		EvenementEntity event = actionES.findById(Long.parseLong("19"));
		BilletEntity billet = actionBS.createBillet(user, event);
		
	}
}
