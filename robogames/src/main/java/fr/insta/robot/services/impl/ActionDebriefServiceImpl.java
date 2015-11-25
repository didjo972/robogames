package fr.insta.robot.services.impl;

import org.apache.commons.lang3.StringUtils;

import fr.insta.robot.bo.DebriefEntity;
import fr.insta.robot.bo.EvenementEntity;
import fr.insta.robot.exceptions.DonneesInexistantException;
import fr.insta.robot.exceptions.FonctionnelleException;
import fr.insta.robot.services.ActionDebriefService;
import fr.insta.robot.services.DebriefService;
import fr.insta.robot.services.EvenementService;
import fr.insta.robot.services.RGServiceFactory;

public class ActionDebriefServiceImpl implements ActionDebriefService{

	@Override
	public void addDebriefEvenement(EvenementEntity evenement, String debrief) throws DonneesInexistantException, FonctionnelleException {
		if (StringUtils.isBlank(debrief) && evenement == null) {
			throw new DonneesInexistantException("Erreur, le débriefing est manquant");
		}
		if (!evenement.getValide()) {
			throw new FonctionnelleException("Erreur, impossible d'ajouter un débriefing car l'évènement n'a pas été validé.");
		}
		evenement.getDebrief().setDebrief(debrief);
		EvenementService eventService = RGServiceFactory.getInstance().getEvenementService();
		eventService.updateEvenement(evenement);
		
	}
	@Override
	public void deleteDebriefEvenement(EvenementEntity evenement) throws DonneesInexistantException{
		if(evenement == null){
			throw new DonneesInexistantException("Erreur, sur l'evenement");
		}
		evenement.getDebrief().setDebrief(null);
	}
	@Override
	public DebriefEntity findDebriefById(Long id){
		DebriefService debriefService = RGServiceFactory.getInstance().getDebriefService();
		return debriefService.findDebriefById(id);
	}

}
