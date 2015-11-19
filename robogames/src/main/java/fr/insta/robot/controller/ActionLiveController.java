package fr.insta.robot.controller;

import org.apache.commons.lang3.StringUtils;
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
import fr.insta.robot.entities.RGEntityFactory;

@Controller
public class ActionLiveController {

	/**
	 * Récupération de l'url du live
	 * @return
	 */
	@RequestMapping(value = "/USER/recupererUrlLive", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ReponseDTO getUrlLive() {
		
		// TODO Récupération du live
		LiveEntity liveEntity = RGEntityFactory.getLiveEntityInstance();
		
		// TODO Remplissage du DTO
		ReponseDTO reponse = new ReponseDTO();
		RetourDTO retour = new RetourDTO();
		retour.setMessage("OK");
		LiveDTO liveDTO = new LiveDTO();
		// TODO A supprimer
		liveDTO.setUrl("https://www.youtube.com/embed/fypJbdbU5iQ");
		reponse.setObject(liveDTO);
		reponse.setRetour(retour);
		return reponse;
	}
	
	@RequestMapping(value = "/ADM/updateUrlLive", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ReponseDTO setUrlLive(@RequestBody String infoUrl) {
		System.out.println(infoUrl);
		// Récupération des informations de création de compte
		String[] tableau = infoUrl.split("&");
		String url = null;
		
		try {
			for (int i = 0; i <= tableau.length - 1; i++) {
				String map = tableau[i];
				String[] tableauCleValue = map.split("=");

				if (tableauCleValue[0].equalsIgnoreCase("url")) {
					url = tableauCleValue[1];
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
		if (StringUtils.isBlank(url)) {
			RetourDTO retour = new RetourDTO();
			retour.setMessage("Erreur, donnee manquante");
			ReponseDTO reponse = new ReponseDTO();
			reponse.setRetour(retour);
			return reponse;
		}
		
		// TODO Mise à jour de l'url
		
		
		ReponseDTO reponseDTO = new ReponseDTO();
		RetourDTO retour = new RetourDTO();
		retour.setMessage("OK");
		reponseDTO.setRetour(retour);
		return reponseDTO;
	}
	
}
