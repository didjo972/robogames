package fr.insta.robot.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
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
import fr.insta.robot.services.impl.ActionEvenementServiceImpl;
import fr.insta.robot.services.impl.ActionUserServiceImpl;

@Controller
public class ActionEvenementController {

	/**
	 * Creer un évènement 
	 * @param infoEvenement les informations de l'évènement
	 * @return une réponse
	 */
	@RequestMapping(value = "/USER/creerEvenement", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ReponseDTO creerUnEvenement(@RequestBody String infoEvenement) {
		System.out.println(infoEvenement);
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
			retour.setMessage("Erreur, donnee manquante");
			ReponseDTO reponse = new ReponseDTO();
			reponse.setRetour(retour);
			return reponse;
		}

		// Vérification
		if (StringUtils.isBlank(adresse) || StringUtils.isBlank(codePostal)
				|| StringUtils.isBlank(ville) || StringUtils.isBlank(nbPlace)
				|| StringUtils.isBlank(prix) || StringUtils.isBlank(infos)
				|| StringUtils.isBlank(idUser) || StringUtils.isBlank(dateDebut)
				|| StringUtils.isBlank(dateFin) || StringUtils.isBlank(nomEvent)) {
			RetourDTO retour = new RetourDTO();
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
			retour.setMessage("Erreur, une donnée n'est pas correct");
			ReponseDTO reponse = new ReponseDTO();
			reponse.setRetour(retour);
			return reponse;
		} catch (DonneesInexistantException e) {
			RetourDTO retour = new RetourDTO();
			retour.setMessage(e.getMessage());
			ReponseDTO reponse = new ReponseDTO();
			reponse.setRetour(retour);
			return reponse;
		} catch (FonctionnelleException e) {
			RetourDTO retour = new RetourDTO();
			retour.setMessage(e.getMessage());
			ReponseDTO reponse = new ReponseDTO();
			reponse.setRetour(retour);
			return reponse;
		} catch (ParseException e) {
			RetourDTO retour = new RetourDTO();
			retour.setMessage(e.getMessage());
			ReponseDTO reponse = new ReponseDTO();
			reponse.setRetour(retour);
			return reponse;
		}
		
		// Remplissage du DTO
		EvenementDTO evenementDTO = fillEvenementDTO(evenement);
		
		RetourDTO retour = new RetourDTO();
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
		System.out.println(infoEvenement);
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
			retour.setMessage("Aucun utilisateur correspondant pour l'id "+idUser);
			reponse.setRetour(retour);
			return reponse;
		}

		// Modification de l'évènement
		ActionEvenementServiceImpl actionEvenement = new ActionEvenementServiceImpl();
		EvenementEntity evenement = RGEntityFactory.getEvenementEntityInstance();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date d_Debut = sdf.parse(dateDebut);
			Date d_Fin = sdf.parse(dateFin);
			// TODO Ajouter le retour de l'update
			//evenement = 
			// TODO Modification de l'update (by id)
			actionEvenement.updateEvenement(userEntity, Long.parseLong(nomEvent), d_Debut, d_Fin, adresse, ville, Integer.parseInt(codePostal), Integer.parseInt(nbPlace), Integer.parseInt(prix), infos);
		} catch (NumberFormatException e) {
			RetourDTO retour = new RetourDTO();
			retour.setMessage("Erreur, une donnée n'est pas correct");
			ReponseDTO reponse = new ReponseDTO();
			reponse.setRetour(retour);
			return reponse;
		} catch (DonneesInexistantException e) {
			RetourDTO retour = new RetourDTO();
			retour.setMessage(e.getMessage());
			ReponseDTO reponse = new ReponseDTO();
			reponse.setRetour(retour);
			return reponse;
		} catch (FonctionnelleException e) {
			RetourDTO retour = new RetourDTO();
			retour.setMessage(e.getMessage());
			ReponseDTO reponse = new ReponseDTO();
			reponse.setRetour(retour);
			return reponse;
		} catch (ParseException e) {
			RetourDTO retour = new RetourDTO();
			retour.setMessage(e.getMessage());
			ReponseDTO reponse = new ReponseDTO();
			reponse.setRetour(retour);
			return reponse;
		}
		
		// Remplissage du DTO
		EvenementDTO evenementDTO = fillEvenementDTO(evenement);

		RetourDTO retour = new RetourDTO();
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
		System.out.println(infoEvenement);
		// Récupération des informations de création de compte
		String[] tableau = infoEvenement.split("&");
		String idEvent = null;
		for (int i = 0; i <= tableau.length - 1; i++) {
			String map = tableau[i];
			String[] tableauCleValue = map.split("=");

			if (tableauCleValue[0].equalsIgnoreCase("idEvent")) {
				idEvent = tableauCleValue[1];
			}
		}

		// Recherche de l'évènement par son id
		ActionEvenementServiceImpl actionEvenement = new ActionEvenementServiceImpl();
		EvenementEntity evenement = actionEvenement.findById(Long.parseLong(idEvent));
		if (evenement == null) {
			RetourDTO retour = new RetourDTO();
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
			retour.setMessage("Erreur lors de la suppression de l'évènement");
			ReponseDTO reponse = new ReponseDTO();
			reponse.setRetour(retour);
			return reponse;
		}		
		
		RetourDTO retour = new RetourDTO();
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
		List<EvenementDTO> listEvenement = new ArrayList<EvenementDTO>();
		ActionEvenementServiceImpl actionEvenement = new ActionEvenementServiceImpl();
		// TODO Faire la récupération des évènements et trier pour ne renvoyer que les évènements valider
		// TODO Fake retour		
		EvenementDTO evenement = new EvenementDTO();
		evenement.setAdresse("17 rue linné");
		evenement.setCodePostal(75005);
		Date date = new Date();
		evenement.setDateDebut(date.toString());
		evenement.setDateFin(date.toString());
		evenement.setDebrief("Aucun");
		evenement.setEtat(true);
		evenement.setIdEvent("103");
		evenement.setIdUser("10001");
		evenement.setInfos("Venez avec un parapluie.");
		evenement.setNbPlace(50);
		evenement.setNomEvent("Premier Combat");
		evenement.setPrix(15);
		evenement.setValide(true);
		evenement.setVille("Paris");
		evenement.setNbPlaceRestant(5);
		listEvenement.add(evenement);
		
		// 2ème itération test
		evenement = new EvenementDTO();
		evenement.setAdresse("36 rue du faubourg");
		evenement.setCodePostal(75003);
		date = new Date();
		evenement.setDateDebut(date.toString());
		evenement.setDateFin(date.toString());
		evenement.setDebrief("Aucun");
		evenement.setEtat(true);
		evenement.setIdEvent("103");
		evenement.setIdUser("10001");
		evenement.setInfos("Venez comme vous êtes");
		evenement.setNbPlace(50);
		evenement.setNomEvent("Deuxième Combat");
		evenement.setPrix(15);
		evenement.setValide(true);
		evenement.setVille("Paris");
		evenement.setNbPlaceRestant(45);
		listEvenement.add(evenement);
		
		ReponseDTO reponse = new ReponseDTO();
		reponse.setObject(listEvenement);
		RetourDTO retour = new RetourDTO();
		retour.setMessage("OK");
		reponse.setRetour(retour);
		return reponse;
	}

	@RequestMapping(value = "/USER/getEvenement", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ReponseDTO getEvenement(@RequestBody String infoEvenement) {
		System.out.println(infoEvenement);
		// Récupération des informations de création de compte
		String[] tableau = infoEvenement.split("&");
		String idEvent = null;
		for (int i = 0; i <= tableau.length - 1; i++) {
			String map = tableau[i];
			String[] tableauCleValue = map.split("=");

			if (tableauCleValue[0].equalsIgnoreCase("idEvent")) {
				idEvent = tableauCleValue[1];
			}
		}

		// Recherche de l'évènement par son id
		ActionEvenementServiceImpl actionEvenement = new ActionEvenementServiceImpl();
		EvenementEntity evenement = actionEvenement.findById(Long.parseLong(idEvent));
		if (evenement == null) {
			RetourDTO retour = new RetourDTO();
			retour.setMessage("Aucun évènement correspondant pour l'id "+idEvent);
			ReponseDTO reponse = new ReponseDTO();
			reponse.setRetour(retour);
			return reponse;
		}
		
		// Retourne l'évènement
		EvenementDTO evenementDTO = fillEvenementDTO(evenement);
		RetourDTO retour = new RetourDTO();
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
	
	@RequestMapping(value = "/USER/getEvenementByUser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ReponseDTO getEvenementsUtilisateur(@RequestBody String infoIdUser) {
		System.out.println(infoIdUser);
		// Récupération des informations de création de compte
		String[] tableau = infoIdUser.split("&");
		String idUser = null;
		for (int i = 0; i <= tableau.length - 1; i++) {
			String map = tableau[i];
			String[] tableauCleValue = map.split("=");

			if (tableauCleValue[0].equalsIgnoreCase("idUser")) {
				idUser = tableauCleValue[1];
			}
		}
		
		// Recherche de l'évènement par son id
		ActionUserServiceImpl actionUser = new ActionUserServiceImpl();
		UserEntity userEntity = actionUser.findUserById(Long.parseLong(idUser));
		if (userEntity == null) {
			RetourDTO retour = new RetourDTO();
			retour.setMessage("Aucun utilisateur correspondant pour l'id "+idUser);
			ReponseDTO reponse = new ReponseDTO();
			reponse.setRetour(retour);
			return reponse;
		}
		
		// Récupération des évènements créé de l'utilisateur
		List<EvenementDTO> listEvenement = new ArrayList<EvenementDTO>();
		EvenementDTO evenement = new EvenementDTO();
		evenement.setAdresse("17 rue linné");
		evenement.setCodePostal(75005);
		Date date = new Date();
		evenement.setDateDebut(date.toString());
		evenement.setDateFin(date.toString());
		evenement.setDebrief("Aucun");
		evenement.setEtat(true);
		evenement.setIdEvent("103");
		evenement.setIdUser("10001");
		evenement.setInfos("Venez avec un parapluie.");
		evenement.setNbPlace(50);
		evenement.setNomEvent("Premier Combat");
		evenement.setPrix(15);
		evenement.setValide(true);
		evenement.setVille("Paris");
		evenement.setNbPlaceRestant(5);
		listEvenement.add(evenement);
		/*for (EvenementEntity evenement : userEntity.getEvenements()) {
			listEvenement.add(fillEvenementDTO(evenement));
		}*/
		
		RetourDTO retour = new RetourDTO();
		retour.setMessage("OK");
		ReponseDTO reponse = new ReponseDTO();
		reponse.setRetour(retour);
		reponse.setObject(listEvenement);
		return reponse;
	}

}
