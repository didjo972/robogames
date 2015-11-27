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

import fr.insta.robot.bo.LiveDTO;
import fr.insta.robot.bo.LiveEntity;
import fr.insta.robot.bo.ReponseDTO;
import fr.insta.robot.bo.RetourDTO;
import fr.insta.robot.bo.UserEntity;
import fr.insta.robot.exceptions.DonneesInexistantException;
import fr.insta.robot.services.impl.ActionLiveServiceImpl;
import fr.insta.robot.services.impl.ActionUserServiceImpl;

@Controller
public class ActionLiveController {
	
	Logger LOG = Logger.getLogger(ActionLiveController.class);

	/**
	 * Récupération de l'url du live
	 * @return
	 */
	@RequestMapping(value = "/ADMIN/recupererUrlLive", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ReponseDTO getUrlLive(@RequestBody String infoAdmin) {
		LOG.info(infoAdmin);
		try {
			infoAdmin = URLDecoder.decode(infoAdmin, "UTF-8");
			LOG.info(infoAdmin);
		} catch (UnsupportedEncodingException e1) {
			RetourDTO retour = new RetourDTO();
			retour.setMessage("Erreur d'encodage, veuillez contacter l'administrateur du site.");
			ReponseDTO reponse = new ReponseDTO();
			reponse.setRetour(retour);
			return reponse;
		}
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
		
		// Récupération du live
		ActionLiveServiceImpl actionLive = new ActionLiveServiceImpl();
		LiveEntity liveEntity = actionLive.findURL();
		
		// Remplissage du DTO
		LiveDTO liveDTO = new LiveDTO();
		if (liveEntity != null) {
			liveDTO.setUrl(liveEntity.getUrl());
		} else {
			liveDTO.setUrl("");
		}
		
		
		ReponseDTO reponse = new ReponseDTO();
		RetourDTO retour = new RetourDTO();
		LOG.info("OK");
		retour.setMessage("OK");
		reponse.setObject(liveDTO);
		reponse.setRetour(retour);
		return reponse;
	}
	
	@RequestMapping(value = "/ADMIN/updateUrlLive", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ReponseDTO setUrlLive(@RequestBody String infoUrl) {
		LOG.info(infoUrl);
		try {
			infoUrl = URLDecoder.decode(infoUrl, "UTF-8");
			LOG.info(infoUrl);
		} catch (UnsupportedEncodingException e1) {
			RetourDTO retour = new RetourDTO();
			retour.setMessage("Erreur d'encodage, veuillez contacter l'administrateur du site.");
			ReponseDTO reponse = new ReponseDTO();
			reponse.setRetour(retour);
			return reponse;
		}
		// Récupération des informations de création de compte
		String[] tableau = infoUrl.split("&");
		String url = null;
		String idAdmin = null;

		try {
			for (int i = 0; i <= tableau.length - 1; i++) {
				String map = tableau[i];
				String[] tableauCleValue = map.split("=");

				if (tableauCleValue[0].equalsIgnoreCase("url")) {
					url = tableauCleValue[1];
					if (url.contains("%3A")) {
						url = url.replaceAll("%3A", ":");
						url = url.replaceAll("%2F", "/");
						url = url.replaceAll("%3F", "?");
						url = url.replaceAll("%3D", "=");
					}
				}
				if (tableauCleValue[0].equalsIgnoreCase("idAdmin")) {
					idAdmin = tableauCleValue[1];
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
		if (StringUtils.isBlank(url) || StringUtils.isBlank(idAdmin)) {
			RetourDTO retour = new RetourDTO();
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
		
		// Mise à jour de l'url
		ActionLiveServiceImpl actionLive = new ActionLiveServiceImpl();
		try {
			actionLive.ajouteUrl(url);
		} catch (DonneesInexistantException e) {
			RetourDTO retour = new RetourDTO();
			LOG.error(e.getMessage());
			retour.setMessage(e.getMessage());
			ReponseDTO reponse = new ReponseDTO();
			reponse.setRetour(retour);
			return reponse;
		}
		
		ReponseDTO reponseDTO = new ReponseDTO();
		RetourDTO retour = new RetourDTO();
		LOG.info("OK");
		retour.setMessage("OK");
		reponseDTO.setRetour(retour);
		return reponseDTO;
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
