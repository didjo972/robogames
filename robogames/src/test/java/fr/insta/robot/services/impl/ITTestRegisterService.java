package fr.insta.robot.services.impl;

import java.security.NoSuchAlgorithmException;

import org.junit.Assert;
import org.junit.Test;

import fr.insta.robot.bo.UserEntity;
import fr.insta.robot.exceptions.DonneesInexistantException;
import fr.insta.robot.exceptions.FonctionnelleException;
import fr.insta.robot.services.ActionUserService;
import fr.insta.robot.services.RGServiceFactory;
import fr.insta.robot.services.UserService;

public class ITTestRegisterService {
	/**
	 * Test du service createUser cas nominal
	 * 
	 * @throws DonneesInexistantException erreur donnée manquante
	 * @throws FonctionnelleException 
	 */
	@Test
	public void testCreateUserNominal() throws DonneesInexistantException, FonctionnelleException {
		ActionUserService actService = new ActionUserServiceImpl();
		UserEntity user = null;
		user = actService.findUserbyPseudo("kingcat77");
		if(user == null){
		user = actService.createUser("catman", "catman", "catman@cat.com", "imageTest");
		}
		Assert.assertNotNull(user);
	}

	@Test
	public void testCreateUserParametresNullOuVide() {
		ActionUserServiceImpl actionService = new ActionUserServiceImpl();
		try {
			actionService.createUser(null, null, null, null);
			Assert.fail();
		} catch (DonneesInexistantException e) {
			Assert.assertEquals("Erreur, toutes les données doivent être fournies.", e.getMessage());
		} catch (FonctionnelleException e) {
			Assert.assertEquals("Erreur, le cryptage md5 a échoué.", e.getMessage());
		}

		try {
			actionService.createUser("", "", "", "");
			Assert.fail();
		} catch (DonneesInexistantException e) {
			Assert.assertEquals("Erreur, toutes les données doivent être fournies.", e.getMessage());
		} catch (FonctionnelleException e) {
			Assert.assertEquals("Erreur, le cryptage md5 a échoué.", e.getMessage());
		}
	}

	@Test
	public void testFindUser() throws DonneesInexistantException, FonctionnelleException{
		ActionUserServiceImpl actionService = new ActionUserServiceImpl();
		UserEntity user = actionService.findUserbyPseudo("kingcat77");
		Assert.assertNotNull(user);
	}

	@Test 
	public void testUpdateUser() throws DonneesInexistantException, FonctionnelleException{
		ActionUserServiceImpl actionService = new ActionUserServiceImpl();
		UserEntity user = actionService.findUserbyPseudo("kingcat77");
		actionService.updateUser(user, "tangonu", "lam", null, "123456", "123456");		
		Assert.assertEquals("tangonu",user.getInformation().getNom());

	}

	@Test 
	public void testLoginUser() throws DonneesInexistantException, FonctionnelleException{
		ActionUserServiceImpl actionService = new ActionUserServiceImpl();
		UserEntity user = actionService.loginUser("kingcat77", "123456");
		Assert.assertNotNull(user);
	}

	@Test
	public void testDisableUser() throws InterruptedException {
		ActionUserServiceImpl actionService = new ActionUserServiceImpl();
		UserEntity userRetour = null;
		try {
			userRetour = actionService.createUser("dijo77", "123456", "dijo77@yolo.fr", "imageTest");
			Assert.assertNotNull(userRetour);
		} catch (DonneesInexistantException | FonctionnelleException e) {
			Assert.fail();
		}

		Assert.assertNotNull(userRetour);
		actionService.disableUser(userRetour,"tu es ban", 10);

		UserService userService = RGServiceFactory.getInstance().getUserService();
		Thread.sleep(5000);
		userService.deleteUser(userRetour);
	}
	@Test
	public void resetpassword() throws FonctionnelleException, DonneesInexistantException, NoSuchAlgorithmException{

		ActionUserServiceImpl actionService = new ActionUserServiceImpl();
		UserEntity user = actionService.loginUser("kingcat77", "123456");
		String newpass = actionService.resetPasswordUser(user.getInformation().getEmail());
		Assert.assertEquals(actionService.encodeMd5(newpass), user.getInformation().getPassword());
		System.out.println(newpass);
	}
	
	@Test 
	public void testSetUser() throws DonneesInexistantException, FonctionnelleException{
		ActionUserServiceImpl actionService = new ActionUserServiceImpl();
		UserEntity user = actionService.findUserbyPseudo("didjo972");
		Assert.assertNotNull(actionService.findAllUser(user));
		System.out.println(actionService.findAllUser(user));
		
	}
}
