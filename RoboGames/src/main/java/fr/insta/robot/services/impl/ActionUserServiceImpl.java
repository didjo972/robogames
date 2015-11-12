package fr.insta.robot.services.impl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;

import fr.insta.robot.bo.UserEntity;
import fr.insta.robot.entities.RGEntityFactory;
import fr.insta.robot.exceptions.DonneesInexistantException;
import fr.insta.robot.exceptions.FonctionnelleException;
import fr.insta.robot.services.RGServiceFactory;
import fr.insta.robot.services.RegisterService;
import fr.insta.robot.services.UserService;

public class ActionUserServiceImpl implements RegisterService {

	public ActionUserServiceImpl() {

	}

	@Override
	public void createUser(String nom, String prenom, String pseudo, String password, String mail) throws DonneesInexistantException, FonctionnelleException {
		if (StringUtils.isBlank(nom) || StringUtils.isBlank(prenom) || StringUtils.isBlank(pseudo)
				|| StringUtils.isBlank(password) || StringUtils.isBlank(mail)) {
			throw new DonneesInexistantException("Erreur, toutes les données doivent être fournies.");
		}

		UserEntity user = RGEntityFactory.getUserEntityInstance();
		user.setNom(nom);
		user.setPrenom(prenom);
		user.setPseudo(pseudo);
		user.setEmail(mail);
		try {
			user.setPassword(encodeMd5(password));
		} catch (NoSuchAlgorithmException e) {
			throw new FonctionnelleException("Erreur, le cryptage md5 a échoué.");
		}

		UserService userService = RGServiceFactory.getInstance().getUserService();
		UserEntity user2 =  userService.findUserByPseudo(user.getPseudo());
		if(user2.getPseudo().equals(user.getPseudo())){
			throw new FonctionnelleException("Erreur, le pseudo existe déjà!");
		}
		else if(user2.getEmail().equals(user.getEmail())){
			throw new FonctionnelleException("Erreur, l'email existe déjà!");
		}
		userService.persistUser(user);
	}

	@Override
	public String encodeMd5(String password) throws NoSuchAlgorithmException {
		MessageDigest digist = MessageDigest.getInstance("MD5");
		digist.update(password.getBytes());

		byte byteData[] = digist.digest();

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		}
		return sb.toString();
	}

	@Override
	public void updateUser(UserEntity user, String nom, String prenom, String oldpass, String newpass) throws DonneesInexistantException, FonctionnelleException {
		if (user == null) {
			throw new FonctionnelleException("Erreur, utilsateur inconnu.");
		}
		
		if (StringUtils.isNotBlank(nom)) {
			user.setNom(nom);
		}
		if (StringUtils.isNotBlank(prenom)) {
			user.setPrenom(prenom);
		}
		
		if (StringUtils.isNotBlank(oldpass) && StringUtils.isNotBlank(newpass)) {
			try {
				if(encodeMd5(oldpass).equalsIgnoreCase(user.getPassword())) {
					user.setPassword(encodeMd5(newpass));
				}
			} catch(final NoSuchAlgorithmException e) {
				throw new FonctionnelleException("Erreur, le cryptage md5 a échoué.");
			}
		}
		
		UserService userService = RGServiceFactory.getInstance().getUserService();
		userService.updateUser(user);
	}

}
