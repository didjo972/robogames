package fr.insta.robot.services.impl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

import fr.insta.robot.bo.UserEntity;
import fr.insta.robot.entities.RGEntityFactory;
import fr.insta.robot.exceptions.DonneesInexistantException;
import fr.insta.robot.exceptions.FonctionnelleException;
import fr.insta.robot.services.ActionUserService;
import fr.insta.robot.services.RGServiceFactory;
import fr.insta.robot.services.UserService;

public class ActionUserServiceImpl implements ActionUserService {

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
		user.setEtat(true);
		try {
			user.setPassword(encodeMd5(password));
		} catch (NoSuchAlgorithmException e) {
			throw new FonctionnelleException("Erreur, le cryptage md5 a échoué.");
		}

		UserService userService = RGServiceFactory.getInstance().getUserService();
		UserEntity retourUser =  userService.findUserByPseudo(user.getPseudo());
		if (retourUser != null) {
			if (retourUser.getPseudo().equals(user.getPseudo()) || retourUser.getEmail().equals(user.getEmail())) {
				throw new FonctionnelleException("Erreur, le pseudo ou l'email existe déjà!");
			}
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
	public void updateUser(UserEntity user, String nom, String prenom, String email, String oldpass, String newpass) throws DonneesInexistantException, FonctionnelleException {
		UserService userService = RGServiceFactory.getInstance().getUserService();

		if (user == null) {
			throw new FonctionnelleException("Erreur, utilsateur inconnu.");
		}

		if (StringUtils.isNotBlank(nom)) {
			user.setNom(nom);
		}
		if (StringUtils.isNotBlank(prenom)) {
			user.setPrenom(prenom);
		}
		
		if (StringUtils.isNotBlank(email)) {
			if (userService.findUserByEmail(email) == null) {
				user.setEmail(email);
			} else {
				throw new FonctionnelleException("Erreur, cette email existe déjà");
			}
		}

		if (StringUtils.isNotBlank(oldpass) && StringUtils.isNotBlank(newpass)) {
			try {
				if (encodeMd5(oldpass).equalsIgnoreCase(user.getPassword())) {
					user.setPassword(encodeMd5(newpass));
				}
			} catch (final NoSuchAlgorithmException e) {
				throw new FonctionnelleException("Erreur, le cryptage md5 a échoué.");
			}
		}
		
		userService.updateUser(user);
	}

	@Override
	public UserEntity loginUser(String pseudo, String password)
			throws DonneesInexistantException, FonctionnelleException {
		if (StringUtils.isBlank(pseudo) || StringUtils.isBlank(password)) {
			throw new DonneesInexistantException("Erreur, veuillez remplir les champs");
		}
		UserService userService = RGServiceFactory.getInstance().getUserService();
		UserEntity user = userService.findUserByPseudo(pseudo);
		if (user == null) {
			throw new FonctionnelleException("Erreur, pseudo incorrect.");
		}
		try {
			if (!encodeMd5(password).equalsIgnoreCase(user.getPassword())) {
				throw new FonctionnelleException("Erreur, mot de passe incorrect.");
			}
		} catch (NoSuchAlgorithmException e) {
			throw new FonctionnelleException("Erreur, le cryptage du mot passe en parametre a échoué.");
		}
		if (user.getEtat()) {
			return user;
		} else {
			throw new FonctionnelleException("Erreur, votre compte est desactivé.");
		}

	}

	@Override
	public void disableUser(UserEntity user) {
		user.setEtat(false);
		UserService userService = RGServiceFactory.getInstance().getUserService();
		userService.updateUser(user);

	}

	@Override
	public String resetPasswordUser(String email) throws FonctionnelleException {
		String generatepassword = RandomStringUtils.randomAlphanumeric(10);
		UserService userService = RGServiceFactory.getInstance().getUserService();
		UserEntity user = userService.findUserByEmail(email);
		if(user == null) {
			throw new FonctionnelleException("Erreur, l'email n'existe pas.");
		}
		try {
			user.setPassword(encodeMd5(generatepassword));
		} catch (NoSuchAlgorithmException e) {
			throw new FonctionnelleException("Erreur, le cryptage du mot passe en parametre a échoué.");
		}
		userService.updateUser(user);
		
		// TODO Faire l'envoie du mail
		return generatepassword;
	}

}
