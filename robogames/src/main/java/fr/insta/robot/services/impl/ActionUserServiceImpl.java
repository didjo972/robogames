package fr.insta.robot.services.impl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

import fr.insta.robot.bo.InformationsEntity;
import fr.insta.robot.bo.UserEntity;
import fr.insta.robot.entities.RGEntityFactory;
import fr.insta.robot.exceptions.DonneesInexistantException;
import fr.insta.robot.exceptions.FonctionnelleException;
import fr.insta.robot.services.ActionUserService;
import fr.insta.robot.services.InformationsService;
import fr.insta.robot.services.RGServiceFactory;
import fr.insta.robot.services.UserService;

public class ActionUserServiceImpl implements ActionUserService {

	public ActionUserServiceImpl() {

	}
	// A rajouter habilitation date fin 
	@Override
	public UserEntity createUser(String nom, String prenom, String pseudo, String password, String mail)
			throws DonneesInexistantException, FonctionnelleException {
		if (StringUtils.isBlank(nom) || StringUtils.isBlank(prenom) || StringUtils.isBlank(pseudo)
				|| StringUtils.isBlank(password) || StringUtils.isBlank(mail)) {
			throw new DonneesInexistantException("Erreur, toutes les données doivent être fournies.");
		}
		// Initialisation de l'entité user
		UserEntity user = RGEntityFactory.getUserEntityInstance();
		user.setEtat(true);
		// Initialisation de l'entité information
		InformationsEntity informations = RGEntityFactory.getInformationsEntityInstance();
		// Affectation des valeurs 
		informations.setNom(nom);
		informations.setPrenom(prenom);
		informations.setPseudo(pseudo);
		informations.setEmail(mail);
		// Cryptage du mot de passe en md5
		try {
			informations.setPassword(encodeMd5(password));
		} catch (NoSuchAlgorithmException e) {
			throw new FonctionnelleException("Erreur, le cryptage md5 a échoué.");
		}
		//Ajout dans les deux entites l'information dans l'user et inversement
		user.setInformation(informations);
		informations.setUser(user);

		//Appel des services DAO
		UserService userService = RGServiceFactory.getInstance().getUserService();
		InformationsService infoService = RGServiceFactory.getInstance().getInformationsService();

		//Recherche si le mail ou pseudo existe deja en base
		InformationsEntity infos2 = infoService.findInformationsByPseudo(pseudo);

		if (infos2 != null) {
			if (infos2.getPseudo().equals(informations.getPseudo()) || infos2.getEmail().equals(informations.getEmail())) {
				throw new FonctionnelleException("Erreur, le pseudo ou l'email existe déjà!");
			}
		}
		//Persist en base
		userService.persistUser(user);

		return user;
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
	public void updateUser(UserEntity user, String nom, String prenom, String oldpass, String newpass)
			throws DonneesInexistantException, FonctionnelleException {
		//Initialisation des services
		//InformationsService infoService = RGServiceFactory.getInstance().getInformationsService();
		UserService userService = RGServiceFactory.getInstance().getUserService();
		if (user == null) {
			throw new FonctionnelleException("Erreur, utilsateur inconnu.");
		}
		//Modifie le nom
		if (StringUtils.isNotBlank(nom)) {
			user.getInformation().setNom(nom);
		}
		//Modifie le prenom
		if (StringUtils.isNotBlank(nom)) {
			user.getInformation().setPrenom(prenom);
		}
		//modifie mot de passe
		if (StringUtils.isNotBlank(oldpass) && StringUtils.isNotBlank(newpass)) {
			try {
				if (encodeMd5(oldpass).equalsIgnoreCase(user.getInformation().getPassword())) {
					user.getInformation().setPassword(encodeMd5(newpass));
				}
			} catch (final NoSuchAlgorithmException e) {
				throw new FonctionnelleException("Erreur, le cryptage md5 a échoué.");
			}
		}
		System.out.println(user.getInformation().getNom());
		//infoService.updateInformations(user.getInformation());
		userService.updateUser(user);
	}

	@Override
	public UserEntity loginUser(String pseudo, String password)
			throws DonneesInexistantException, FonctionnelleException {
		if (StringUtils.isBlank(pseudo) || StringUtils.isBlank(password)) {
			throw new DonneesInexistantException("Erreur, veuillez remplir les champs");
		}
		//Initialisation des Services DAO
		UserService userService = RGServiceFactory.getInstance().getUserService();
		InformationsService infosService = RGServiceFactory.getInstance().getInformationsService();

		//Retrouver les infos par pseudo
		InformationsEntity infos = infosService.findInformationsByPseudo(pseudo);
		if (infos == null) {
			throw new FonctionnelleException("Erreur, pseudo incorrect.");
		}
		//teste du mot en login
		try {
			if (!encodeMd5(password).equalsIgnoreCase(infos.getPassword())) {
				throw new FonctionnelleException("Erreur, mot de passe incorrect.");
			}
		} catch (NoSuchAlgorithmException e) {
			throw new FonctionnelleException("Erreur, le cryptage du mot passe en parametre a échoué.");
		}
		//Retrouver le UserEntity a partir de l'informations
		UserEntity user = userService.findUserById(infos.getUser().getId());
		return user;
	}

	@Override
	public void disableUser(UserEntity user) {
		if (!Objects.isNull(user)) {
			user.setEtat(false);
			UserService userService = RGServiceFactory.getInstance().getUserService();
			userService.updateUser(user);
		}
	}

	@Override
	public String resetPasswordUser(String email) throws FonctionnelleException {
		String generatepassword = RandomStringUtils.randomAlphanumeric(10);
		UserService userService = RGServiceFactory.getInstance().getUserService();
		UserEntity user = findUserbyEmail(email);
		if(user == null){
			throw new FonctionnelleException("Erreur, l'email n'existe pas.");
		}
		try {
			user.getInformation().setPassword(encodeMd5(generatepassword));
		}catch (NoSuchAlgorithmException e) {
			throw new FonctionnelleException("Erreur, le cryptage du mot passe en parametre a échoué.");
		}
		userService.updateUser(user);

		return generatepassword;


	}

	@Override
	public UserEntity findUserbyPseudo(String pseudo) {
		UserService userService = RGServiceFactory.getInstance().getUserService();
		InformationsService infosService = RGServiceFactory.getInstance().getInformationsService();

		InformationsEntity infos = infosService.findInformationsByPseudo(pseudo);
		UserEntity user = userService.findUserById(infos.getUser().getId());
		return user;
	}
	@Override
	public UserEntity findUserbyEmail(String email){
		UserService userService = RGServiceFactory.getInstance().getUserService();
		InformationsService infosService = RGServiceFactory.getInstance().getInformationsService();

		InformationsEntity infos = infosService.findInformationsByEmail(email);
		UserEntity user = userService.findUserById(infos.getUser().getId());
		return user;
	}

}
