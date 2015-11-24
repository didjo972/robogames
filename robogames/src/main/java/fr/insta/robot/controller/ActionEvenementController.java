package fr.insta.robot.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import fr.insta.robot.bo.UserEntity;
import fr.insta.robot.entities.RGEntityFactory;
import fr.insta.robot.exceptions.DonneesInexistantException;
import fr.insta.robot.exceptions.FonctionnelleException;
import fr.insta.robot.services.impl.ActionDebriefServiceImpl;
import fr.insta.robot.services.impl.ActionEvenementServiceImpl;
import fr.insta.robot.services.impl.ActionUserServiceImpl;
import fr.insta.robot.util.DateUtil;

@Controller
public class ActionEvenementController {
	
	Logger LOG = Logger.getLogger(ActionEvenementController.class);

	/**
	 * Creer un évènement 
	 * @param infoEvenement les informations de l'évènement
	 * @return une réponse
	 */
	@RequestMapping(value = "/USER/creerEvenement", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ReponseDTO creerUnEvenement(@RequestBody String infoEvenement) {
		LOG.info(infoEvenement);
		try {
			infoEvenement = URLDecoder.decode(infoEvenement, "UTF-8");
			LOG.info(infoEvenement);
		} catch (UnsupportedEncodingException e1) {
			RetourDTO retour = new RetourDTO();
			retour.setMessage("Erreur d'encodage, veuillez contacter l'administrateur du site.");
			ReponseDTO reponse = new ReponseDTO();
			reponse.setRetour(retour);
			return reponse;
		}
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
			}
		} catch (Exception e) {
			RetourDTO retour = new RetourDTO();
			LOG.error("Erreur, donnee manquante");
			retour.setMessage("Erreur, donnee manquante");
			ReponseDTO reponse = new ReponseDTO();
			reponse.setRetour(retour);
			return reponse;
		}

		// Vérification
		if (StringUtils.isBlank(adresse) || StringUtils.isBlank(codePostal)
				|| StringUtils.isBlank(ville) || StringUtils.isBlank(nbPlace)
				|| StringUtils.isBlank(prix) || StringUtils.isBlank(idUser)
				|| StringUtils.isBlank(dateDebut) || StringUtils.isBlank(dateFin)
				|| StringUtils.isBlank(nomEvent)) {
			RetourDTO retour = new RetourDTO();
			LOG.error("Erreur, donnee manquante");
			retour.setMessage("Erreur, donnee manquante");
			ReponseDTO reponse = new ReponseDTO();
			reponse.setRetour(retour);
			return reponse;
		}
		
		// Récupération de l'USER
		ActionUserServiceImpl actionUser = new ActionUserServiceImpl();
		UserEntity userEntity = actionUser.findUserById(Long.parseLong(idUser));
		if (userEntity == null) {
			ReponseDTO reponse = new ReponseDTO();
			RetourDTO retour = new RetourDTO();
			LOG.error("Aucun utilisateur correspondant pour l'id "+idUser);
			retour.setMessage("Aucun utilisateur correspondant pour l'id "+idUser);
			reponse.setRetour(retour);
			return reponse;
		}

		// Création de l'évènement
		ActionEvenementServiceImpl actionEvenement = new ActionEvenementServiceImpl();
		EvenementEntity evenement = RGEntityFactory.getEvenementEntityInstance();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date d_Debut = sdf.parse(dateDebut);
			Date d_Fin = sdf.parse(dateFin);
			evenement = actionEvenement.createEvenement(userEntity, nomEvent, d_Debut, d_Fin, adresse, ville, Integer.parseInt(codePostal), Integer.parseInt(nbPlace), Integer.parseInt(prix), infos);
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

	/**
	 * Modification de l'évènement 
	 * @param infoEvenement les informations de l'évènement
	 * @return une réponse
	 */
	@RequestMapping(value = "/USER/modifierEvenement", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ReponseDTO modifierEvenement(@RequestBody String infoEvenement) {
		LOG.info(infoEvenement);
		try {
			infoEvenement = URLDecoder.decode(infoEvenement, "UTF-8");
			LOG.info(infoEvenement);
		} catch (UnsupportedEncodingException e1) {
			RetourDTO retour = new RetourDTO();
			retour.setMessage("Erreur d'encodage, veuillez contacter l'administrateur du site.");
			ReponseDTO reponse = new ReponseDTO();
			reponse.setRetour(retour);
			return reponse;
		}
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
		String idEvent = null;
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
				if (tableauCleValue[0].equalsIgnoreCase("idEvent")) {
					idEvent = tableauCleValue[1];
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
		
		if (StringUtils.isBlank(idEvent) || StringUtils.isBlank(idUser)) {
			RetourDTO retour = new RetourDTO();
			LOG.error("Erreur, donnee manquante");
			retour.setMessage("Erreur, donnee manquante");
			ReponseDTO reponse = new ReponseDTO();
			reponse.setRetour(retour);
			return reponse;
		}

		// Récupération de l'USER
		ActionUserServiceImpl actionUser = new ActionUserServiceImpl();
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
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
			Date d_Debut = sdf.parse(dateDebut);
			Date d_Fin = sdf.parse(dateFin);
			evenement = actionEvenement.updateEvenement(userEntity, Long.parseLong(idEvent), d_Debut, d_Fin, adresse, ville, Integer.parseInt(codePostal), Integer.parseInt(nbPlace), Integer.parseInt(prix), infos);
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

	/**
	 * Suppression de l'évènement 
	 * @param infoEvenement l'id de l'event
	 * @return une réponse
	 */
	@RequestMapping(value = "/USER/supprimerEvenement", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ReponseDTO supprimerEvenement(@RequestBody String infoEvenement) {
		LOG.info(infoEvenement);
		try {
			infoEvenement = URLDecoder.decode(infoEvenement, "UTF-8");
			LOG.info(infoEvenement);
		} catch (UnsupportedEncodingException e1) {
			RetourDTO retour = new RetourDTO();
			retour.setMessage("Erreur d'encodage, veuillez contacter l'administrateur du site.");
			ReponseDTO reponse = new ReponseDTO();
			reponse.setRetour(retour);
			return reponse;
		}
		// Récupération des informations de création de compte
		String[] tableau = infoEvenement.split("&");
		String idEvent = null;
		String idUser = null;
		try {
			for (int i = 0; i <= tableau.length - 1; i++) {
				String map = tableau[i];
				String[] tableauCleValue = map.split("=");

				if (tableauCleValue[0].equalsIgnoreCase("idEvent")) {
					idEvent = tableauCleValue[1];
				}
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
		
		if (StringUtils.isBlank(idUser) || StringUtils.isBlank(idEvent)) {
			RetourDTO retour = new RetourDTO();
			LOG.error("Erreur, donnee manquante");
			retour.setMessage("Erreur, donnee manquante");
			ReponseDTO reponse = new ReponseDTO();
			reponse.setRetour(retour);
			return reponse;
		}
		
		// Récupération de l'utilisateur
		ActionUserServiceImpl actionUser = new ActionUserServiceImpl();
		if (actionUser.findUserById(Long.parseLong(idUser)) == null) {
			RetourDTO retour = new RetourDTO();
			LOG.error("Aucun utilisateur correspondant pour l'id "+idUser);
			retour.setMessage("Aucun utilisateur correspondant pour l'id "+idUser);
			ReponseDTO reponse = new ReponseDTO();
			reponse.setRetour(retour);
			return reponse;
		}

		// Recherche de l'évènement par son id
		ActionEvenementServiceImpl actionEvenement = new ActionEvenementServiceImpl();
		EvenementEntity evenement = actionEvenement.findById(Long.parseLong(idEvent));
		if (evenement == null) {
			RetourDTO retour = new RetourDTO();
			LOG.error("Aucun évènement correspondant pour l'id "+idEvent);
			retour.setMessage("Aucun évènement correspondant pour l'id "+idEvent);
			ReponseDTO reponse = new ReponseDTO();
			reponse.setRetour(retour);
			return reponse;
		}
		
		// Suppression de l'évènement
		try {
			actionEvenement.deleteEvenement(evenement);
		} catch(Exception e) {
			RetourDTO retour = new RetourDTO();
			LOG.error("Erreur lors de la suppression de l'évènement");
			retour.setMessage("Erreur lors de la suppression de l'évènement");
			ReponseDTO reponse = new ReponseDTO();
			reponse.setRetour(retour);
			return reponse;
		}		
		
		RetourDTO retour = new RetourDTO();
		LOG.info("OK");
		retour.setMessage("OK");
		ReponseDTO reponse = new ReponseDTO();
		reponse.setRetour(retour);
		return reponse;
	}

	/**
	 * Récupère tous les évènement 
	 * @return
	 */
	@RequestMapping(value = "/USER/getAllEvenement", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ReponseDTO getAllEvenement() {
		// Récupération des évènements
		List<EvenementDTO> listEvenementDTO = new ArrayList<EvenementDTO>();
		ActionEvenementServiceImpl actionEvenement = new ActionEvenementServiceImpl();
		
		List<EvenementEntity> listEvenementEntity;
		listEvenementEntity = actionEvenement.findAllEnvenement();
		
		// Remplissage de l'évènementDTO
		Map<String, EvenementDTO> mapEvenement = new HashMap<String, EvenementDTO>();
		for (EvenementEntity evenementEntity : listEvenementEntity) {
			if (evenementEntity.getValide()) {
				EvenementDTO evenement = fillEvenementDTO(evenementEntity);
				mapEvenement.put(evenement.getIdEvent(), evenement);
			}			
		}
		listEvenementDTO.addAll(mapEvenement.values());
		
		ReponseDTO reponse = new ReponseDTO();
		reponse.setObject(listEvenementDTO);
		RetourDTO retour = new RetourDTO();
		LOG.info("OK");
		retour.setMessage("OK");
		reponse.setRetour(retour);
		return reponse;
	}

	@RequestMapping(value = "/USER/getEvenement", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ReponseDTO getEvenement(@RequestBody String infoEvenement) {
		LOG.info(infoEvenement);
		try {
			infoEvenement = URLDecoder.decode(infoEvenement, "UTF-8");
			LOG.info(infoEvenement);
		} catch (UnsupportedEncodingException e1) {
			RetourDTO retour = new RetourDTO();
			retour.setMessage("Erreur d'encodage, veuillez contacter l'administrateur du site.");
			ReponseDTO reponse = new ReponseDTO();
			reponse.setRetour(retour);
			return reponse;
		}
		// Récupération des informations de l'évent
		String[] tableau = infoEvenement.split("&");
		String idEvent = null;
		String idUser = null;
		try {
			for (int i = 0; i <= tableau.length - 1; i++) {
				String map = tableau[i];
				String[] tableauCleValue = map.split("=");

				if (tableauCleValue[0].equalsIgnoreCase("idEvent")) {
					idEvent = tableauCleValue[1];
				}
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
		
		if (StringUtils.isBlank(idUser) || StringUtils.isBlank(idEvent)) {
			RetourDTO retour = new RetourDTO();
			LOG.error("Erreur, donnee manquante");
			retour.setMessage("Erreur, donnee manquante");
			ReponseDTO reponse = new ReponseDTO();
			reponse.setRetour(retour);
			return reponse;
		}
		
		// Récupération de l'utilisateur
		ActionUserServiceImpl actionUser = new ActionUserServiceImpl();
		UserEntity userEntity = actionUser.findUserById(Long.parseLong(idUser));
		if (userEntity == null) {
			RetourDTO retour = new RetourDTO();
			LOG.error("Aucun utilisateur correspondant pour l'id "+idUser);
			retour.setMessage("Aucun utilisateur correspondant pour l'id "+idUser);
			ReponseDTO reponse = new ReponseDTO();
			reponse.setRetour(retour);
			return reponse;
		}

		// Recherche de l'évènement par son id
		ActionEvenementServiceImpl actionEvenement = new ActionEvenementServiceImpl();
		EvenementEntity evenement = actionEvenement.findById(Long.parseLong(idEvent));
		if (evenement == null) {
			RetourDTO retour = new RetourDTO();
			LOG.error("Aucun évènement correspondant pour l'id "+idEvent);
			retour.setMessage("Aucun évènement correspondant pour l'id "+idEvent);
			ReponseDTO reponse = new ReponseDTO();
			reponse.setRetour(retour);
			return reponse;
		}
		
		// Vérification de l'appartenance de l'évènement
		if (evenement.getUser().getId() != userEntity.getId()) {
			RetourDTO retour = new RetourDTO();
			LOG.error("Erreur lors de la récupération de l'évènement de cette utilisateur");
			retour.setMessage("Erreur lors de la récupération de l'évènement de cette utilisateur");
			ReponseDTO reponse = new ReponseDTO();
			reponse.setRetour(retour);
			return reponse;
		}
		
		// Retourne l'évènement
		EvenementDTO evenementDTO = fillEvenementDTO(evenement);
		RetourDTO retour = new RetourDTO();
		LOG.info("OK");
		retour.setMessage("OK");
		ReponseDTO reponse = new ReponseDTO();
		reponse.setObject(evenementDTO);
		reponse.setRetour(retour);
		return reponse;
	}
	
	private EvenementDTO fillEvenementDTO(EvenementEntity evenement) {
		EvenementDTO evenementDTO = new EvenementDTO();
		evenementDTO.setAdresse(evenement.getAdresse());
		evenementDTO.setCodePostal(evenement.getCodePostal());
		evenementDTO.setDateDebut(DateUtil.formatDate(evenement.getDateDebut()));
		evenementDTO.setDateFin(DateUtil.formatDate(evenement.getDateFin()));
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
		evenementDTO.setNbPlaceRestant(evenement.getNbPlace()-i);
		
		return evenementDTO;
	}
	
	@RequestMapping(value = "/USER/getEvenementByUser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ReponseDTO getEvenementsUtilisateur(@RequestBody String infoIdUser) {
		LOG.info(infoIdUser);
		try {
			infoIdUser = URLDecoder.decode(infoIdUser, "UTF-8");
			LOG.info(infoIdUser);
		} catch (UnsupportedEncodingException e1) {
			RetourDTO retour = new RetourDTO();
			retour.setMessage("Erreur d'encodage, veuillez contacter l'administrateur du site.");
			ReponseDTO reponse = new ReponseDTO();
			reponse.setRetour(retour);
			return reponse;
		}
		// Récupération des informations de création de compte
		String[] tableau = infoIdUser.split("&");
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
		
		
		// Recherche de l'utilisateur par son id
		ActionUserServiceImpl actionUser = new ActionUserServiceImpl();
		UserEntity userEntity = actionUser.findUserById(Long.parseLong(idUser));
		if (userEntity == null) {
			RetourDTO retour = new RetourDTO();
			LOG.error("Aucun utilisateur correspondant pour l'id "+idUser);
			retour.setMessage("Aucun utilisateur correspondant pour l'id "+idUser);
			ReponseDTO reponse = new ReponseDTO();
			reponse.setRetour(retour);
			return reponse;
		}
		
		// Récupération des évènements créé de l'utilisateur
		Map<String, EvenementDTO> mapEvenement = new HashMap<String, EvenementDTO>();
		List<EvenementDTO> listEvenement = new ArrayList<EvenementDTO>();
		for (EvenementEntity evenement : userEntity.getEvenements()) {
			EvenementDTO evenementDTO = fillEvenementDTO(evenement);
			mapEvenement.put(evenementDTO.getIdEvent(), evenementDTO);
		}
		listEvenement.addAll(mapEvenement.values());
		
		RetourDTO retour = new RetourDTO();
		LOG.info("OK");
		retour.setMessage("OK");
		ReponseDTO reponse = new ReponseDTO();
		reponse.setRetour(retour);
		reponse.setObject(listEvenement);
		return reponse;
	}
	
	@RequestMapping(value = "/USER/modifierDebrief", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ReponseDTO modifierDebrief(@RequestBody String infoDebrief) {
		LOG.info(infoDebrief);
		try {
			infoDebrief = URLDecoder.decode(infoDebrief, "UTF-8");
			LOG.info(infoDebrief);
		} catch (UnsupportedEncodingException e1) {
			RetourDTO retour = new RetourDTO();
			retour.setMessage("Erreur d'encodage, veuillez contacter l'administrateur du site.");
			ReponseDTO reponse = new ReponseDTO();
			reponse.setRetour(retour);
			return reponse;
		}
		// Récupération des informations de création de compte
		String[] tableau = infoDebrief.split("&");
		String idEvent = null;
		String debrief = null;
		String idUser = null;
		
		try {
			for (int i = 0; i <= tableau.length - 1; i++) {
				String map = tableau[i];
				String[] tableauCleValue = map.split("=");

				if (tableauCleValue[0].equalsIgnoreCase("idEvent")) {
					idEvent = tableauCleValue[1];
				}
				if (tableauCleValue[0].equalsIgnoreCase("debrief")) {
					debrief = tableauCleValue[1];
				}
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
		
		if (StringUtils.isBlank(idUser) || StringUtils.isBlank(debrief) || StringUtils.isBlank(idEvent)) {
			RetourDTO retour = new RetourDTO();
			LOG.error("Erreur, donnee manquante");
			retour.setMessage("Erreur, donnee manquante");
			ReponseDTO reponse = new ReponseDTO();
			reponse.setRetour(retour);
			return reponse;
		}
		
		// Récupération de l'user
		ActionUserServiceImpl actionUser = new ActionUserServiceImpl();
		UserEntity userEntity = actionUser.findUserById(Long.parseLong(idUser));
		if (userEntity == null) {
			RetourDTO retour = new RetourDTO();
			LOG.error("Erreur, aucun utilisateur correspondant à l'id "+idUser);
			retour.setMessage("Erreur, aucun utilisateur correspondant à l'id "+idUser);
			ReponseDTO reponse = new ReponseDTO();
			reponse.setRetour(retour);
			return reponse;
		}
		
		// Récupération de l'évènement
		ActionEvenementServiceImpl actionEvenement = new ActionEvenementServiceImpl();
		EvenementEntity evenement = actionEvenement.findById(Long.parseLong(idEvent));
		if (evenement == null) {
			RetourDTO retour = new RetourDTO();
			LOG.error("Erreur lors de la récupération de l'évènement");
			retour.setMessage("Erreur lors de la récupération de l'évènement");
			ReponseDTO reponse = new ReponseDTO();
			reponse.setRetour(retour);
			return reponse;
		}
		
		// Vérification de l'appartenance de l'évènement et de l'id
		if (evenement.getUser().getId() != userEntity.getId()) {
			RetourDTO retour = new RetourDTO();
			LOG.error("Erreur lors de la récupération de l'évènement de cette utilisateur");
			retour.setMessage("Erreur lors de la récupération de l'évènement de cette utilisateur");
			ReponseDTO reponse = new ReponseDTO();
			reponse.setRetour(retour);
			return reponse;
		}
		
		// Modification du débrief
		ActionDebriefServiceImpl actionDebrief = new ActionDebriefServiceImpl();
		try {
			actionDebrief.addDebriefEvenement(evenement, debrief);
		} catch (DonneesInexistantException e) {
			RetourDTO retour = new RetourDTO();
			retour.setMessage(e.getMessage());
			ReponseDTO reponse = new ReponseDTO();
			reponse.setRetour(retour);
			return reponse;
		}
		
		RetourDTO retour = new RetourDTO();
		LOG.info("OK");
		retour.setMessage("OK");
		ReponseDTO reponse = new ReponseDTO();
		reponse.setRetour(retour);
		return reponse;
	}

}
