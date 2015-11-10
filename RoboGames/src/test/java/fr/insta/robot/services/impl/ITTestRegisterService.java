package fr.insta.robot.services.impl;

import org.junit.Assert;
import org.junit.Test;

import fr.insta.robot.AbstractRgItTest;
import fr.insta.robot.bo.UserEntity;
import fr.insta.robot.exceptions.DonneesInexistantException;
import fr.insta.robot.exceptions.FonctionnelleException;
import fr.insta.robot.services.RGServiceFactory;
import fr.insta.robot.services.UserService;

public class ITTestRegisterService extends AbstractRgItTest {
	/**
	 * Test du service createUser cas nominal
	 * 
	 * @throws DonneesInexistantException erreur donnée manquante
	 * @throws FonctionnelleException 
	 */
	@Test
	public void testCreateUserNominal() throws DonneesInexistantException, FonctionnelleException {
		ActionUserServiceImpl registerService = new ActionUserServiceImpl();
		registerService.createUser("tang", "lam", "kingcat", "123456", "kingcat@yolo.fr");
	}
	
	@Test
	public void testCreateUserParametresNullOuVide() {
		ActionUserServiceImpl registerService = new ActionUserServiceImpl();
		try {
			registerService.createUser(null, null, null, null,null);
			Assert.fail();
		} catch (DonneesInexistantException e) {
			Assert.assertEquals("Erreur, toutes les données doivent être fournies.", e.getMessage());
		} catch (FonctionnelleException e) {
			Assert.assertEquals("Erreur, le cryptage md5 a échoué.", e.getMessage());
		}
		
		try {
			registerService.createUser("", "", "", "","");
			Assert.fail();
		} catch (DonneesInexistantException e) {
			Assert.assertEquals("Erreur, toutes les données doivent être fournies.", e.getMessage());
		} catch (FonctionnelleException e) {
			Assert.assertEquals("Erreur, le cryptage md5 a échoué.", e.getMessage());
		}
	}
	@Test
	public void testFindUser() throws DonneesInexistantException, FonctionnelleException{
		ActionUserServiceImpl registerService = new ActionUserServiceImpl();
		registerService.createUser("tang", "lam", "kingcat", "123456", "kingcat@yolo.fr");
		
		UserService userService = RGServiceFactory.getInstance().getUserService();
		UserEntity user = userService.findUserByPseudo("kingcat");
		
		Assert.assertEquals("kingcat@yolo.fr", user.getEmail());
	}
	
	@Test 
	public void testUpdateUser() throws DonneesInexistantException, FonctionnelleException{
		UserService userService = RGServiceFactory.getInstance().getUserService();
		UserEntity user = userService.findUserByPseudo("kingcat");
		
		ActionUserServiceImpl registerService = new ActionUserServiceImpl();
		registerService.updateUser(user, "tang", "lam", "123456", "123456");
		Assert.assertEquals("lam", user.getPrenom());
	}
}
