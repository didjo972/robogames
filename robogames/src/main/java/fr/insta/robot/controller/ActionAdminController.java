package fr.insta.robot.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.insta.robot.bo.BilletEntity;
import fr.insta.robot.bo.EvenementDTO;
import fr.insta.robot.bo.EvenementEntity;
import fr.insta.robot.bo.ReponseDTO;
import fr.insta.robot.bo.RetourDTO;
import fr.insta.robot.bo.UserDTO;
import fr.insta.robot.bo.UserEntity;
import fr.insta.robot.exceptions.DonneesInexistantException;
import fr.insta.robot.exceptions.FonctionnelleException;
import fr.insta.robot.services.impl.ActionEvenementServiceImpl;
import fr.insta.robot.services.impl.ActionUserServiceImpl;

@Controller
public class ActionAdminController {
	
	Logger LOG = Logger.getLogger(ActionAdminController.class);

	@RequestMapping(value = "/ADMIN/getAllEvenement", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ReponseDTO getAllEvenement(@RequestBody String infoAdmin) {
		LOG.info(infoAdmin);
		// Récupération de l'id de l'admin
		String[] tableau = infoAdmin.split("&");
		String idAdmin = null;

		try {
			for (int i = 0; i <= tableau.length - 1; i++) {
				String map = tableau[i];
				String[] tableauCleValue = map.split("=");

				if (tableauCleValue[0].equalsIgnoreCase("idAdmin")) {
					idAdmin = tableauCleValue[1];
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
		
		// Récupération de l'admin
		ActionUserServiceImpl actionUser = new ActionUserServiceImpl();
		UserEntity userEntityAdmin = actionUser.findUserById(Long.parseLong(idAdmin));
		if (userEntityAdmin == null) {
			RetourDTO retour = new RetourDTO();
			LOG.error("Erreur lors de la récupération des utilisateurs");
			retour.setMessage("Erreur lors de la récupération des utilisateurs");
			ReponseDTO reponse = new ReponseDTO();
			reponse.setRetour(retour);
			return reponse;
		}
		
		// Récupération des évènements
		List<EvenementDTO> listEvenement = new ArrayList<EvenementDTO>();
		ActionEvenementServiceImpl actionEvenement = new ActionEvenementServiceImpl();
		List<EvenementEntity> listEvenementEntity;
		try {
			listEvenementEntity = actionEvenement.findAllEnvenement(userEntityAdmin);
		} catch (FonctionnelleException e) {
			RetourDTO retour = new RetourDTO();
			LOG.error(e.getMessage());
			retour.setMessage(e.getMessage());
			ReponseDTO reponse = new ReponseDTO();
			reponse.setRetour(retour);
			return reponse;
		}
		
		// Remplissage de l'évènementDTO
		for (EvenementEntity evenementEntity : listEvenementEntity) {
			listEvenement.add(fillEvenementDTO(evenementEntity));
		}		
		
		// Remplissage de la réponse
		ReponseDTO reponse = new ReponseDTO();
		RetourDTO retour = new RetourDTO();
		LOG.info("OK");
		retour.setMessage("OK");
		reponse.setRetour(retour);
		reponse.setObject(listEvenement);
		return reponse;
	}
	
	/**
	 * Modification de l'évènement 
	 * @param infoEvenement les informations de l'évènement
	 * @return une réponse
	 */
	@RequestMapping(value = "/ADMIN/modifierEvenement", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ReponseDTO modifierEvenement(@RequestBody String infoEvenement) {
		LOG.info(infoEvenement);
		// Récupération des informations de création de compte
		String[] tableau = infoEvenement.split("&");
		String adresse = null;
		String codePostal = null;
		String ville = null;
		String nbPlace = null;
		String prix = null;
		String infos = null;
		String idUser = null;
		String dateDebut = null;
		String dateFin = null;
		String nomEvent = null;
		String idAdmin = null;
		
		try {
			for (int i = 0; i <= tableau.length - 1; i++) {
				String map = tableau[i];
				String[] tableauCleValue = map.split("=");

				if (tableauCleValue[0].equalsIgnoreCase("adresse")) {
					adresse = tableauCleValue[1];
				}
				if (tableauCleValue[0].equalsIgnoreCase("codePostal")) {
					codePostal = tableauCleValue[1];
				}
				if (tableauCleValue[0].equalsIgnoreCase("ville")) {
					ville = tableauCleValue[1];
				}
				if (tableauCleValue[0].equalsIgnoreCase("nbPlace")) {
					nbPlace = tableauCleValue[1];
				}
				if (tableauCleValue[0].equalsIgnoreCase("prix")) {
					prix = tableauCleValue[1];
				}
				if (tableauCleValue[0].equalsIgnoreCase("infos")) {
					infos = tableauCleValue[1];
				}
				if (tableauCleValue[0].equalsIgnoreCase("idUser")) {
					idUser = tableauCleValue[1];
				}
				if (tableauCleValue[0].equalsIgnoreCase("dateDebut")) {
					dateDebut = tableauCleValue[1];
				}
				if (tableauCleValue[0].equalsIgnoreCase("dateFin")) {
					dateFin = tableauCleValue[1];
				}
				if (tableauCleValue[0].equalsIgnoreCase("nomEvent")) {
					nomEvent = tableauCleValue[1];
				}
				if (tableauCleValue[0].equalsIgnoreCase("idAdmin")) {
					idAdmin = tableauCleValue[1];
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
		
		if (StringUtils.isBlank(idAdmin)) {
			RetourDTO retour = new RetourDTO();
			LOG.error("Erreur, donnee manquante");
			retour.setMessage("Erreur, donnee manquante");
			ReponseDTO reponse = new ReponseDTO();
			reponse.setRetour(retour);
			return reponse;
		}
		
		// Récupération de l'admin
		ActionUserServiceImpl actionUser = new ActionUserServiceImpl();
		UserEntity userEntityAdmin = actionUser.findUserById(Long.parseLong(idAdmin));
		if (userEntityAdmin == null) {
			RetourDTO retour = new RetourDTO();
			LOG.error("Erreur lors de la modification des évènements");
			retour.setMessage("Erreur lors de la modification des évènements");
			ReponseDTO reponse = new ReponseDTO();
			reponse.setRetour(retour);
			return reponse;
		}

		// Récupération de l'USER
		UserEntity userEntity = actionUser.findUserById(Long.parseLong(idUser));
		if (userEntity == null) {
			ReponseDTO reponse = new ReponseDTO();
			RetourDTO retour = new RetourDTO();
			LOG.error("Aucun utilisateur correspondant pour l'id "+idUser);
			retour.setMessage("Aucun utilisateur correspondant pour l'id "+idUser);
			reponse.setRetour(retour);
			return reponse;
		}

		// Modification de l'évènement
		ActionEvenementServiceImpl actionEvenement = new ActionEvenementServiceImpl();
		EvenementEntity evenement = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date d_Debut = sdf.parse(dateDebut);
			Date d_Fin = sdf.parse(dateFin);
			evenement = actionEvenement.updateEvenementAdmin(Long.parseLong(nomEvent), d_Debut, d_Fin, adresse, ville, Integer.parseInt(codePostal), Integer.parseInt(nbPlace), Integer.parseInt(prix), infos);
		} catch (NumberFormatException e) {
			RetourDTO retour = new RetourDTO();
			LOG.error("Erreur, une donnée n'est pas correct");
			retour.setMessage("Erreur, une donnée n'est pas correct");
			ReponseDTO reponse = new ReponseDTO();
			reponse.setRetour(retour);
			return reponse;
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
		} catch (ParseException e) {
			RetourDTO retour = new RetourDTO();
			LOG.error(e.getMessage());
			retour.setMessage(e.getMessage());
			ReponseDTO reponse = new ReponseDTO();
			reponse.setRetour(retour);
			return reponse;
		}
		
		// Remplissage du DTO
		EvenementDTO evenementDTO = fillEvenementDTO(evenement);

		RetourDTO retour = new RetourDTO();
		LOG.info("OK");
		retour.setMessage("OK");
		ReponseDTO reponse = new ReponseDTO();
		reponse.setObject(evenementDTO);
		reponse.setRetour(retour);
		return reponse;
	}
	
	public EvenementDTO fillEvenementDTO(EvenementEntity evenement) {
		EvenementDTO evenementDTO = new EvenementDTO();
		evenementDTO.setAdresse(evenement.getAdresse());
		evenementDTO.setCodePostal(evenement.getCodePostal());
		evenementDTO.setDateDebut(evenement.getDateDebut().toString());
		evenementDTO.setDateFin(evenement.getDateFin().toString());
		evenementDTO.setDebrief(evenement.getDebrief().getDebrief());
		evenementDTO.setEtat(evenement.getEtat());
		evenementDTO.setIdEvent(evenement.getId().toString());
		evenementDTO.setIdUser(evenement.getUser().getId().toString());
		evenementDTO.setInfos(evenement.getInfos());
		evenementDTO.setNbPlace(evenement.getNbPlace());
		evenementDTO.setNomEvent(evenement.getNom());
		evenementDTO.setPrix(evenement.getPrix());
		evenementDTO.setValide(evenement.getValide());
		evenementDTO.setVille(evenement.getVille());
		int i = 0;
		for (BilletEntity billet : evenement.getBillets()) {
			if (billet != null && billet.getUser() != null) {
				i++;
			}
		}
		evenementDTO.setNbPlaceRestant(i);
		
		return evenementDTO;
	}
	
	@RequestMapping(value = "/ADMIN/getAllUtilisateur", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ReponseDTO getAllUtilisateur(@RequestBody String infoAdmin) {
		LOG.info(infoAdmin);
		// Récupération de l'id de l'admin
		String[] tableau = infoAdmin.split("&");
		String idAdmin = null;

		try {
			for (int i = 0; i <= tableau.length - 1; i++) {
				String map = tableau[i];
				String[] tableauCleValue = map.split("=");

				if (tableauCleValue[0].equalsIgnoreCase("idAdmin")) {
					idAdmin = tableauCleValue[1];
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
		
		// Récupération de l'admin
		ActionUserServiceImpl actionUser = new ActionUserServiceImpl();
		UserEntity userEntityAdmin = actionUser.findUserById(Long.parseLong(idAdmin));
		if (userEntityAdmin == null) {
			RetourDTO retour = new RetourDTO();
			LOG.error("Erreur lors de la récupération des utilisateurs");
			retour.setMessage("Erreur lors de la récupération des utilisateurs");
			ReponseDTO reponse = new ReponseDTO();
			reponse.setRetour(retour);
			return reponse;
		}
		
		// Récupération de tous les utilisateurs
		List<UserEntity> listUserEntity = null;
		try {
			listUserEntity = actionUser.findAllUser(userEntityAdmin);
		} catch (FonctionnelleException e) {
			RetourDTO retour = new RetourDTO();
			LOG.error(e.getMessage());
			retour.setMessage(e.getMessage());
			ReponseDTO reponse = new ReponseDTO();
			reponse.setRetour(retour);
			return reponse;
		}

		// Remplissage de la liste de DTO
		List<UserDTO> listUserDTO = new ArrayList<UserDTO>();
		for (UserEntity userEntity : listUserEntity) {
			listUserDTO.add(fillUserDTO(userEntity));
		}
		RetourDTO retour = new RetourDTO();
		LOG.info("OK");
		retour.setMessage("OK");
		ReponseDTO reponse = new ReponseDTO();
		reponse.setObject(listUserDTO);
		reponse.setRetour(retour);
		return reponse;
	}

	private UserDTO fillUserDTO(UserEntity userEntity) {
		UserDTO userDTO = new UserDTO();
		if (userEntity.getEtat()) {
			userDTO.setEtat("true");
		} else {
			userDTO.setEtat("false");
		}
		userDTO.setId(userEntity.getId());
		userDTO.setLibelleHabilitation(userEntity.getHabilitation().getRole().getLibelle());
		userDTO.setNom(userEntity.getInformation().getNom());
		userDTO.setPrenom(userEntity.getInformation().getPrenom());
		userDTO.setPseudo(userEntity.getInformation().getPseudo());
		return userDTO;
	}
	
}
