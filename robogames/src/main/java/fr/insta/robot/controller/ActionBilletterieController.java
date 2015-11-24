package fr.insta.robot.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.insta.robot.bo.EvenementEntity;
import fr.insta.robot.bo.ReponseDTO;
import fr.insta.robot.bo.RetourDTO;
import fr.insta.robot.bo.UserEntity;
import fr.insta.robot.exceptions.FonctionnelleException;
import fr.insta.robot.services.impl.ActionBilletServiceImpl;
import fr.insta.robot.services.impl.ActionEvenementServiceImpl;
import fr.insta.robot.services.impl.ActionUserServiceImpl;

@Controller
public class ActionBilletterieController {

	Logger LOG = Logger.getLogger(ActionBilletterieController.class);

	@RequestMapping(value = "/USER/acheterBillet", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ReponseDTO acheterBillet(@RequestBody String infoAchatBillet) {
		LOG.info(infoAchatBillet);
		try {
			infoAchatBillet = URLDecoder.decode(infoAchatBillet, "UTF-8");
			LOG.info(infoAchatBillet);
		} catch (UnsupportedEncodingException e1) {
			RetourDTO retour = new RetourDTO();
			retour.setMessage("Erreur d'encodage, veuillez contacter l'administrateur du site.");
			ReponseDTO reponse = new ReponseDTO();
			reponse.setRetour(retour);
			return reponse;
		}
		// Récupération des informations de l'évent
		String[] tableau = infoAchatBillet.split("&");
		String idEvent = null;
		String idUser = null;
		String nbPlace = null;
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
				if (tableauCleValue[0].equalsIgnoreCase("nbPlace")) {
					nbPlace = tableauCleValue[1];
				}
			}
			if (StringUtils.isBlank(idUser) || StringUtils.isBlank(idEvent)
					|| StringUtils.isBlank(nbPlace)) {
				throw new FonctionnelleException("Erreur, donnee manquante");
			}
		} catch (Exception e) {
			RetourDTO retour = new RetourDTO();
			LOG.error(e.getMessage());
			retour.setMessage(e.getMessage());
			ReponseDTO reponse = new ReponseDTO();
			reponse.setRetour(retour);
			return reponse;
		}

		

		// Récupération de l'user
		ActionUserServiceImpl actionUser = new ActionUserServiceImpl();
		UserEntity userEntity = null;
		try {
			userEntity = actionUser.findUserById(Long
					.parseLong(idUser));
			if (userEntity == null) {
				throw new FonctionnelleException();
			}
		} catch (Exception e) {
			RetourDTO retour = new RetourDTO();
			LOG.error("Erreur, aucun utilisateur pour l'id :" + idUser);
			retour.setMessage("Erreur, aucun utilisateur pour l'id :"
					+ idUser);
			ReponseDTO reponse = new ReponseDTO();
			reponse.setRetour(retour);
			return reponse;
		}

		// Récupération de l'évènement
		ActionEvenementServiceImpl actionEvent = new ActionEvenementServiceImpl();
		EvenementEntity evenementEntity = null;
		try {
			evenementEntity = actionEvent.findById(Long.parseLong(idEvent));
		} catch (Exception e) {
			RetourDTO retour = new RetourDTO();
			LOG.error("Erreur le nombre passé en paramètre n'est pas correct");
			retour.setMessage("Erreur le nombre passé en paramètre n'est pas correct");
			ReponseDTO reponse = new ReponseDTO();
			reponse.setRetour(retour);
			return reponse;
		}

		// Acheter un billet
		ActionBilletServiceImpl actionBillet = new ActionBilletServiceImpl();
		try {
			int j = Integer.parseInt(nbPlace);
			for (int i = 0; i <= j; i++) {
				actionBillet.createBillet(userEntity, evenementEntity);
			}
		} catch (FonctionnelleException e) {
			RetourDTO retour = new RetourDTO();
			LOG.error("Erreur lors de l'achat de votre billet");
			retour.setMessage("Erreur lors de l'achat de votre billet");
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
}
