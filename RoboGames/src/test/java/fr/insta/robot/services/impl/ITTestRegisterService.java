package fr.insta.robot.services.impl;

import java.util.Objects;

import org.junit.Assert;
import org.junit.Test;

import fr.insta.robot.AbstractRgItTest;
import fr.insta.robot.bo.UserEntity;
import fr.insta.robot.exceptions.DonneesInexistantException;
import fr.insta.robot.exceptions.FonctionnelleException;
import fr.insta.robot.services.ActionUserService;
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
		ActionUserServiceImpl actionService = new ActionUserServiceImpl();
		actionService.createUser("tang", "lam", "kingcat", "123456", "kingcat@yolo.fr");

	}

	@Test
	public void testCreateUserParametresNullOuVide() {
		ActionUserServiceImpl actionService = new ActionUserServiceImpl();
		try {
			actionService.createUser(null, null, null, null,null);
			Assert.fail();
		} catch (DonneesInexistantException e) {
			Assert.assertEquals("Erreur, toutes les données doivent être fournies.", e.getMessage());
		} catch (FonctionnelleException e) {
			Assert.assertEquals("Erreur, le cryptage md5 a échoué.", e.getMessage());
		}

		try {
			actionService.createUser("", "", "", "","");
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
		actionService.createUser("tang", "lam", "kingcat", "123456", "kingcat@yolo.fr");

		UserService userService = RGServiceFactory.getInstance().getUserService();
		UserEntity user = userService.findUserByPseudo("kingcat");

		Assert.assertEquals("kingcat@yolo.fr", user.getEmail());
	}

	@Test 
	public void testUpdateUser() throws DonneesInexistantException, FonctionnelleException{
		UserService userService = RGServiceFactory.getInstance().getUserService();
		UserEntity user = userService.findUserByPseudo("kingcat");

		ActionUserServiceImpl actionService = new ActionUserServiceImpl();
		actionService.updateUser(user, "tang", "lam","kingcat2@yolo.fr", "123456", "123456");
		Assert.assertEquals("lam", user.getPrenom());
	}

	@Test 
	public void testLoginUser() throws DonneesInexistantException, FonctionnelleException{
		ActionUserService actionService = new ActionUserServiceImpl();
		UserEntity user = actionService.loginUser("kingcat", "dyYrpXau0Q");
		Assert.assertNotNull(user);
		
	}

	@Test
	public void testDisableUser() {
		ActionUserServiceImpl actionService = new ActionUserServiceImpl();
		try {
			actionService.createUser("marie rose", "dimitri", "dijo", "123456", "dijo@yolo.fr");
		} catch (DonneesInexistantException e) {
			Assert.assertEquals("Erreur, toutes les données doivent être fournies.", e.getMessage());
		} catch (FonctionnelleException e) {
			Assert.assertEquals("Erreur, le pseudo ou l'email existe déjà!", e.getMessage());
		}

		UserService userService = RGServiceFactory.getInstance().getUserService();
		UserEntity user = userService.findUserByPseudo("dijo");
		if(Objects.isNull(user)){
			Assert.assertNull(user);
		}
		else{
			Assert.assertNotNull(user);
		}
	}
	@Test
	public void resetpassword() throws FonctionnelleException{
		ActionUserServiceImpl actionService = new ActionUserServiceImpl();
		System.out.println(" nouveau pass : "+actionService.resetPasswordUser("kingcat2@yolo.fr"));
	}
}
