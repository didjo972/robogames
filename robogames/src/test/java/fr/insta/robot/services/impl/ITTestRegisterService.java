package fr.insta.robot.services.impl;

import java.security.NoSuchAlgorithmException;

import org.junit.Assert;
import org.junit.Test;

import fr.insta.robot.AbstractRgItTest;
import fr.insta.robot.bo.UserEntity;
import fr.insta.robot.exceptions.DonneesInexistantException;
import fr.insta.robot.exceptions.FonctionnelleException;
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
		ActionUserServiceImpl actionService = new ActionUserServiceImpl();
		UserEntity user = actionService.createUser("tang", "lam", "kingcat", "123456", "kingcat@yolo.fr", null,null);

		UserService userService = RGServiceFactory.getInstance().getUserService();
		Assert.assertEquals("kingcat", user.getInformation().getPseudo());
		userService.deleteUser(user);
	}

	@Test
	public void testCreateUserParametresNullOuVide() {
		ActionUserServiceImpl actionService = new ActionUserServiceImpl();
		try {
			actionService.createUser(null, null, null, null,null, null,null);
			Assert.fail();
		} catch (DonneesInexistantException e) {
			Assert.assertEquals("Erreur, toutes les données doivent être fournies.", e.getMessage());
		} catch (FonctionnelleException e) {
			Assert.assertEquals("Erreur, le cryptage md5 a échoué.", e.getMessage());
		}

		try {
			actionService.createUser("", "", "", "","","","");
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
		actionService.createUser("tang", "lam", "kingcat", "123456", "kingcat@yolo.fr", null,null);

		UserEntity user = actionService.findUserbyPseudo("kingcat");
		UserService userService = RGServiceFactory.getInstance().getUserService();
		Assert.assertEquals("kingcat@yolo.fr", user.getInformation().getEmail());

		userService.deleteUser(user);
	}

	@Test 
	public void testUpdateUser() throws DonneesInexistantException, FonctionnelleException{
		ActionUserServiceImpl actionService = new ActionUserServiceImpl();
		actionService.createUser("tang", "lam", "kingcat", "123456", "kingcat@yolo.fr", null,null);
		UserEntity user = actionService.findUserbyPseudo("kingcat");
		actionService.updateUser(user, "tangonu", "lam",null, "123456", "123456");		
		Assert.assertEquals("tangonu",user.getInformation().getNom());

	}

	@Test 
	public void testLoginUser() throws DonneesInexistantException, FonctionnelleException{
		ActionUserServiceImpl actionService = new ActionUserServiceImpl();

		actionService.createUser("tang", "lam", "kingcat", "123456", "kingcat@yolo.fr", null,null);

		UserEntity user = actionService.loginUser("kingcat", "123456");
		Assert.assertNotNull(user);
		UserService userService = RGServiceFactory.getInstance().getUserService();

		userService.deleteUser(user);
	}

	@Test
	public void testDisableUser() {
		ActionUserServiceImpl actionService = new ActionUserServiceImpl();
		try {
			actionService.createUser("marie rose", "dimitri", "dijo", "123456", "dijo@yolo.fr", null,null);
		} catch (DonneesInexistantException e) {
			Assert.assertEquals("Erreur, toutes les données doivent être fournies.", e.getMessage());
		} catch (FonctionnelleException e) {
			Assert.assertEquals("Erreur, le pseudo ou l'email existe déjà!", e.getMessage());
		}

		UserEntity user = actionService.findUserbyPseudo("dijo");
		if(user == null){
			Assert.assertNull(user);
		}
		else{
			Assert.assertNotNull(user);
			actionService.disableUser(user);
		}
		UserService userService = RGServiceFactory.getInstance().getUserService();
		userService.deleteUser(user);
	}
	@Test
	public void resetpassword() throws FonctionnelleException, DonneesInexistantException, NoSuchAlgorithmException{

		ActionUserServiceImpl actionService = new ActionUserServiceImpl();
		actionService.createUser("tang", "lam", "kingcat2", "123456", "kingca8t@yolo.fr", null,null);
		String newpass = actionService.resetPasswordUser("kingcat@yolo.fr");
		UserService userService = RGServiceFactory.getInstance().getUserService();
		UserEntity user = actionService.findUserbyPseudo("kingcat2");

		Assert.assertEquals(actionService.encodeMd5(newpass), user.getInformation().getPassword());

		userService.deleteUser(user);
	}
	@Test 
	public void testSetUser() throws DonneesInexistantException, FonctionnelleException{
		ActionUserServiceImpl actionService = new ActionUserServiceImpl();
	//	actionService.createUser("tang", "lam", "kingcat1", "123456", "kingca1@yolo.fr", null);
	//	actionService.createUser("tang", "lam", "kingcat2", "123456", "kingca22t@yolo.fr", null);
	//	actionService.createUser("tang", "lam", "kingcat3", "123456", "kingca3t@yolo.fr", null);
		
		UserEntity user = actionService.findUserbyPseudo("kingcat1");
		System.out.println(actionService.findAllUser(user));
	}
}
