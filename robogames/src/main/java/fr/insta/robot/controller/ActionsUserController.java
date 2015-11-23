package fr.insta.robot.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.insta.robot.bo.LiveDTO;
import fr.insta.robot.bo.LiveEntity;
import fr.insta.robot.bo.ReponseDTO;
import fr.insta.robot.bo.RetourDTO;
import fr.insta.robot.bo.UserDTO;
import fr.insta.robot.bo.UserEntity;
import fr.insta.robot.exceptions.DonneesInexistantException;
import fr.insta.robot.exceptions.FonctionnelleException;
import fr.insta.robot.services.impl.ActionLiveServiceImpl;
import fr.insta.robot.services.impl.ActionUserServiceImpl;

@Controller
public class ActionsUserController {

	private static final String ATTRIBUT_SESSION = "USER";
	
	Logger LOG = Logger.getLogger(ActionsUserController.class);

	/**
	 * Creer un compte 
	 * @param infoCompte les informations de création de compte
	 * @return une réponse
	 */
	@RequestMapping(value = "/creerCompte", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ReponseDTO creerCompte(@RequestBody String infoCompte) {
		LOG.info(infoCompte);
		try {
			infoCompte = URLDecoder.decode(infoCompte, "UTF-8");
			LOG.info(infoCompte);
		} catch (UnsupportedEncodingException e1) {
			RetourDTO retour = new RetourDTO();
			retour.setMessage("Erreur d'encodage, veuillez contacter l'administrateur du site.");
			ReponseDTO reponse = new ReponseDTO();
			reponse.setRetour(retour);
			return reponse;
		}
		// Récupération des informations de création de compte
		String[] tableau = infoCompte.split("&");
		String nom = null;
		String prenom = null;
		String pseudo = null;
		String password = null;
		String email = null;
		String infos = null;
		String image = null;
		
		try {
			for (int i = 0; i <= tableau.length - 1; i++) {
				String map = tableau[i];
				String[] tableauCleValue = map.split("=");

				if (tableauCleValue[0].equalsIgnoreCase("prenom")) {
					prenom = tableauCleValue[1];
				}
				if (tableauCleValue[0].equalsIgnoreCase("email")) {
					email = tableauCleValue[1];
				}
				if (tableauCleValue[0].equalsIgnoreCase("pseudo")) {
					pseudo = tableauCleValue[1];
				}
				if (tableauCleValue[0].equalsIgnoreCase("password")) {
					password = tableauCleValue[1];
				}
				if (tableauCleValue[0].equalsIgnoreCase("nom")) {
					nom = tableauCleValue[1];
				}
				if (tableauCleValue[0].equalsIgnoreCase("infos")) {
					infos = tableauCleValue[1];
				}
				if (tableauCleValue[0].equalsIgnoreCase("image")) {
					image = tableauCleValue[1];
				}
			}
		} catch (Exception e) {
			RetourDTO retour = new RetourDTO();
			LOG.error("Erreur, donnee manquante");
			retour.setMessage("Erreur, donnee manquante");
			ReponseDTO reponse = new ReponseDTO();
			reponse.setRetour(retour);
			return reponse;
		}

		// Vérification des données
		if (StringUtils.isBlank(nom) || StringUtils.isBlank(prenom)
				|| StringUtils.isBlank(pseudo) || StringUtils.isBlank(password)
				|| StringUtils.isBlank(email)) {
			// Retourne une erreur
			RetourDTO retour = new RetourDTO();
			LOG.error("Erreur, donnee manquante");
			retour.setMessage("Erreur, donnee manquante");
			ReponseDTO reponse = new ReponseDTO();
			reponse.setRetour(retour);
			return reponse;
		}

		// Création du compte
		ActionUserServiceImpl actionUser = new ActionUserServiceImpl();
		UserEntity userEntity = null;
		try {
			userEntity = actionUser.createUser(nom, prenom, pseudo, password, email, infos, image);
		} catch (DonneesInexistantException e) {
			RetourDTO retour = new RetourDTO();
			LOG.error(e.getMessage());
			retour.setMessage(e.getMessage());
			ReponseDTO reponse = new ReponseDTO();
			reponse.setRetour(retour);
			return reponse;
		} catch (FonctionnelleException e) {
			RetourDTO retour = new RetourDTO();
			LOG.error(e.getMessage());
			retour.setMessage(e.getMessage());
			ReponseDTO reponse = new ReponseDTO();
			reponse.setRetour(retour);
			return reponse;
		}

		if (userEntity == null) {
			RetourDTO retour = new RetourDTO();
			LOG.error("Erreur lors de la création de compte");
			retour.setMessage("Erreur lors de la création de compte");
			ReponseDTO reponse = new ReponseDTO();
			reponse.setRetour(retour);
			return reponse;
		}

		UserDTO userDTO = new UserDTO();
		if (userEntity.getEtat()) {
			userDTO.setEtat("true");
		} else {
			userDTO.setEtat("false");
		}
		
		userDTO.setLibelleHabilitation(userEntity.getHabilitation().getRole().getLibelle());
		userDTO.setNom(userEntity.getInformation().getNom());
		userDTO.setPrenom(userEntity.getInformation().getPrenom());
		userDTO.setPseudo(userEntity.getInformation().getPseudo());
		userDTO.setIdUser(userEntity.getId());
		userDTO.setDateInscription(userEntity.getHabilitation().getDateFin().toString());

		RetourDTO retour = new RetourDTO();
		LOG.info("OK");
		retour.setMessage("OK");
		ReponseDTO reponse = new ReponseDTO();
		reponse.setObject(userDTO);
		reponse.setRetour(retour);
		return reponse;
	}

	/**
	 * Connexion 
	 * @param info les informations de connexion pseudo, password
	 * @param session la session
	 * @return les informations d'un USER
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ReponseDTO logIn(@RequestBody String info, HttpSession session) {
		LOG.info(info);
		try {
			info = URLDecoder.decode(info, "UTF-8");
			LOG.info(info);
		} catch (UnsupportedEncodingException e1) {
			RetourDTO retour = new RetourDTO();
			retour.setMessage("Erreur d'encodage, veuillez contacter l'administrateur du site.");
			ReponseDTO reponse = new ReponseDTO();
			reponse.setRetour(retour);
			return reponse;
		}
		// Récupération des informations de création de compte
		String[] tableau = info.split("&");
		String mail = null;
		String password = null;

		try {
			for (int i = 0; i <= tableau.length - 1; i++) {
				String map = tableau[i];
				String[] tableauCleValue = map.split("=");

				if (tableauCleValue[0].equalsIgnoreCase("mail")) {
					mail = tableauCleValue[1];
				}
				if (tableauCleValue[0].equalsIgnoreCase("password")) {
					password = tableauCleValue[1];
				}
			}
		} catch (Exception e) {
			RetourDTO retour = new RetourDTO();
			LOG.error("Erreur, donnee manquante");
			retour.setMessage("Erreur, donnee manquante");
			ReponseDTO reponse = new ReponseDTO();
			reponse.setRetour(retour);
			return reponse;
		}

		ActionUserServiceImpl actionUser = new ActionUserServiceImpl();
		UserEntity userEntity = null;
		try {
			userEntity = actionUser.loginUser(mail, password);
		} catch (DonneesInexistantException e) {
			RetourDTO retour = new RetourDTO();
			LOG.error(e.getMessage());
			retour.setMessage(e.getMessage());
			ReponseDTO reponse = new ReponseDTO();
			reponse.setRetour(retour);
			return reponse;
		} catch (FonctionnelleException e) {
			RetourDTO retour = new RetourDTO();
			LOG.error(e.getMessage());
			retour.setMessage(e.getMessage());
			ReponseDTO reponse = new ReponseDTO();
			reponse.setRetour(retour);
			return reponse;
		}

		UserDTO userDTO = new UserDTO();
		if (userEntity.getEtat()) {
			userDTO.setEtat("true");
		} else {
			userDTO.setEtat("false");
		}
		
		userDTO.setLibelleHabilitation(userEntity.getHabilitation().getRole().getLibelle());
		userDTO.setNom(userEntity.getInformation().getNom());
		userDTO.setPrenom(userEntity.getInformation().getPrenom());
		userDTO.setPseudo(userEntity.getInformation().getPseudo());
		userDTO.setIdUser(userEntity.getId());
		userDTO.setDateInscription(userEntity.getHabilitation().getDateDebut().toString());

		// Création de la session
		session.setAttribute(ATTRIBUT_SESSION, userDTO.getPseudo());

		RetourDTO retour = new RetourDTO();
		LOG.info("OK");
		retour.setMessage("OK");
		ReponseDTO reponse = new ReponseDTO();
		reponse.setObject(userDTO);
		reponse.setRetour(retour);
		return reponse;
	}

	/**
	 * Est connecté 
	 * @param session la session de l'USER
	 * @return une réponse
	 */
	@RequestMapping(value = "/isConnected", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ReponseDTO isConnected(HttpSession session) {
		String pseudo = (String) session.getAttribute(ATTRIBUT_SESSION);
		System.out.println(pseudo);
		System.out.println(session.getId());
		if (pseudo == null) {
			return null;
		}
		// TODO A voir quel retour renvoyer
		RetourDTO retour = new RetourDTO();
		retour.setMessage("OK");
		ReponseDTO reponse = new ReponseDTO();
		//TODO Pseudo à virer
		reponse.setObject(pseudo);
		reponse.setRetour(retour);
		return reponse;
	}

	/**
	 * Déconnexion 
	 * @param session la session de l'USER
	 * @return une réponse
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ReponseDTO logOut(HttpSession session) {
		session.removeAttribute(ATTRIBUT_SESSION);

		RetourDTO retour = new RetourDTO();
		LOG.info("OK");
		retour.setMessage("OK");
		ReponseDTO reponse = new ReponseDTO();
		reponse.setRetour(retour);
		return reponse;
	}

	@RequestMapping(value = "/USER/getUtilisateur", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ReponseDTO getUtilisateur(@RequestBody String infoUser) {
		LOG.info(infoUser);
		try {
			infoUser = URLDecoder.decode(infoUser, "UTF-8");
			LOG.info(infoUser);
		} catch (UnsupportedEncodingException e1) {
			RetourDTO retour = new RetourDTO();
			retour.setMessage("Erreur d'encodage, veuillez contacter l'administrateur du site.");
			ReponseDTO reponse = new ReponseDTO();
			reponse.setRetour(retour);
			return reponse;
		}
		// Récupération des informations de création de compte
		String[] tableau = infoUser.split("&");
		String idUser = null;

		try {
			for (int i = 0; i <= tableau.length - 1; i++) {
				String map = tableau[i];
				String[] tableauCleValue = map.split("=");

				if (tableauCleValue[0].equalsIgnoreCase("idUser")) {
					idUser = tableauCleValue[1];
				}
			}
		} catch (Exception e) {
			RetourDTO retour = new RetourDTO();
			LOG.error("Erreur, donnee manquante");
			retour.setMessage("Erreur, donnee manquante");
			ReponseDTO reponse = new ReponseDTO();
			reponse.setRetour(retour);
			return reponse;
		}

		ActionUserServiceImpl actionUser = new ActionUserServiceImpl();
		UserEntity userEntity = actionUser.findUserById(Long.parseLong(idUser));
		if (userEntity == null) {
			ReponseDTO reponse = new ReponseDTO();
			RetourDTO retour = new RetourDTO();
			LOG.error("Aucun utilisateur connu pour cette l'id "+idUser);
			retour.setMessage("Aucun utilisateur connu pour cette l'id "+idUser);
			reponse.setRetour(retour);
			return reponse;
		}

		UserDTO userDTO = new UserDTO();
		if (userEntity.getEtat()) {
			userDTO.setEtat("true");
		} else {
			userDTO.setEtat("false");
		}
		userDTO.setLibelleHabilitation(userEntity.getHabilitation().getRole().getLibelle());
		userDTO.setNom(userEntity.getInformation().getNom());
		userDTO.setPrenom(userEntity.getInformation().getPrenom());
		userDTO.setPseudo(userEntity.getInformation().getPseudo());
		userDTO.setIdUser(userEntity.getId());
		userDTO.setDateInscription(userEntity.getHabilitation().getDateDebut().toString());
		
		RetourDTO retour = new RetourDTO();
		LOG.info("OK");
		retour.setMessage("OK");
		ReponseDTO reponse = new ReponseDTO();
		reponse.setRetour(retour);
		reponse.setObject(userDTO);
		return reponse;
	}
	
	/**
	 * Récupération de l'url du live
	 * @return
	 */
	@RequestMapping(value = "/USER/recupererUrlLive", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ReponseDTO getUrlLive() {		
		// Récupération du live
		ActionLiveServiceImpl actionLive = new ActionLiveServiceImpl();
		LiveEntity liveEntity = actionLive.findURL();
		
		// Remplissage du DTO
		LiveDTO liveDTO = new LiveDTO();
		liveDTO.setUrl(liveEntity.getUrl());
		
		ReponseDTO reponse = new ReponseDTO();
		RetourDTO retour = new RetourDTO();
		LOG.info("OK");
		retour.setMessage("OK");
		reponse.setObject(liveDTO);
		reponse.setRetour(retour);
		return reponse;
	}

}
