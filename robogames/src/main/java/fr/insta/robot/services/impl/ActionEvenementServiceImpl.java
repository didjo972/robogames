package fr.insta.robot.services.impl;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import fr.insta.robot.bo.DebriefEntity;
import fr.insta.robot.bo.EvenementEntity;
import fr.insta.robot.bo.UserEntity;
import fr.insta.robot.entities.RGEntityFactory;
import fr.insta.robot.exceptions.DonneesInexistantException;
import fr.insta.robot.exceptions.FonctionnelleException;
import fr.insta.robot.services.ActionEvenementService;
import fr.insta.robot.services.EvenementService;
import fr.insta.robot.services.RGServiceFactory;

public class ActionEvenementServiceImpl implements ActionEvenementService {

	@Override
	public EvenementEntity createEvenement(UserEntity user, Date d_debut, Date d_fin, String adresse, String ville, int codePostal,
			int nb_place, int prix, String infos) throws DonneesInexistantException {
		if (user == null || d_debut == null || d_debut == null || adresse == null || ville == null || codePostal == 0
				|| nb_place == 0 || prix == 0 || infos == null) {
			throw new DonneesInexistantException("Erreur, toutes les données doivent être fournies.");
		}
		// Initialisation de l'entité evenement
		EvenementEntity evenement = RGEntityFactory.getEvenementEntityInstance();
		//Affectation des variables dans evenement
		evenement.setDateDebut(d_debut);
		evenement.setDateFin(d_fin);
		evenement.setAdresse(adresse);
		evenement.setVille(ville);
		evenement.setCodePostal(codePostal);
		evenement.setNbPlace(nb_place);
		evenement.setPrix(prix);
		evenement.setEtat(true);
		evenement.setInfos(infos);
		
		//Affectation de l'evenement dans user
		evenement.setUser(user);
		user.addEvenement(evenement);

		EvenementService evenementService =  RGServiceFactory.getInstance().getEvenementService();
		evenementService.persistEvenement(evenement);

		return evenement;
	}

	@Override
	public void updateEvenement(EvenementEntity evenement, Date d_debut, Date d_fin, String adresse, String ville,
			int codePostal, int nb_place, int prix, String infos) throws FonctionnelleException {
		EvenementService evenementService = RGServiceFactory.getInstance().getEvenementService();
		if(evenement == null){
			throw new FonctionnelleException("Erreur, evenement inconnu.");
		}
		if(d_debut != null){
			evenement.setDateDebut(d_debut);
		}
		if(d_fin != null){
			evenement.setDateFin(d_fin);
		}
		if(StringUtils.isNotBlank(adresse)){
			evenement.setAdresse(adresse);
		}
		if(StringUtils.isNotBlank(ville)){
			evenement.setVille(ville);
		}
		if(StringUtils.isNotBlank(infos)){
			evenement.setInfos(infos);
		}
		if(codePostal > 0){
			evenement.setCodePostal(codePostal);
		}
		if(nb_place > 0){
			evenement.setNbPlace(nb_place);
		}
		if(prix > 0){
			evenement.setPrix(prix);
		}
		evenementService.updateEvenement(evenement);
	}

	@Override
	public void deleteEvenement(EvenementEntity evenement) {
		EvenementService evenementService = RGServiceFactory.getInstance().getEvenementService();
		evenementService.deleteEvenement(evenement);
	}
	@Override
	public void addDebriefEvenement(EvenementEntity evenement, String debrief) throws DonneesInexistantException{
		DebriefEntity debriefEntity = RGEntityFactory.getDebriefEntityInstance();
		if(StringUtils.isBlank(debrief)){
			throw new DonneesInexistantException("Erreur, renseignez le champ debrief");
		}
		evenement.setDebrief(debriefEntity);
		debriefEntity.setEvenement(evenement);
		
		EvenementService eveService = RGServiceFactory.getInstance().getEvenementService();
		eveService.updateEvenement(evenement);
		
		
	}

}
