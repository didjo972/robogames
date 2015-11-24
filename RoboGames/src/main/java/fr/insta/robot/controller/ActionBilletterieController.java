package fr.insta.robot.controller;

import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.insta.robot.bo.ReponseDTO;

@Controller
public class ActionBilletterieController {

	Logger LOG = Logger.getLogger(ActionBilletterieController.class);

	@RequestMapping(value = "/USER/acheterBillet", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ReponseDTO acheterBillet() {
		
		
		
		// Acheter un billet
//		ActionBilletServiceImpl actionBillet = new ActionBilletServiceImpl();
//		actionBillet.createBillet(user, evenement);
//		
//		RetourDTO retour = new RetourDTO();
//		retour.setMessage("OK");
//		ReponseDTO reponse = new ReponseDTO();
//		reponse.setRetour(retour);
//		return reponse;
		return null;
	}
	
}
