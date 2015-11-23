package fr.insta.robot.services.impl;

import java.util.Date;
import java.util.List;

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
	public EvenementEntity createEvenement(UserEntity user, String nom, Date d_debut, Date d_fin, String adresse,
			String ville, int codePostal, int nb_place, int prix, String infos)
					throws DonneesInexistantException, FonctionnelleException {
		if (user == null || d_debut == null || d_debut == null || StringUtils.isBlank(adresse)
				|| StringUtils.isBlank(ville) || codePostal == 0 || nb_place <= 0 || prix < 0
				|| StringUtils.isBlank(nom)) {
			throw new DonneesInexistantException("Erreur, toutes les données doivent être fournies.");
		}
		// Verifier la date
		Date tmp = new Date();
		if (d_debut.before(tmp) || d_debut.after(d_fin)) {
			throw new FonctionnelleException("Erreur, les dates données sont incorrects");
		}
		// Initialisation de l'entité debrief
		DebriefEntity debrief = RGEntityFactory.getDebriefEntityInstance();
		// Initialisation de l'entité evenement
		EvenementEntity evenement = RGEntityFactory.getEvenementEntityInstance();
		// Affectation des variables dans evenement
		evenement.setDateDebut(d_debut);
		evenement.setDateFin(d_fin);
		// recherche si le nom est unique
		if (findByNameEvenement(nom) != null) {
			throw new FonctionnelleException("Erreur, le nom de l'evenement existe en base");
		} else {
			evenement.setNom(nom);
		}
		evenement.setNom(nom);
		evenement.setAdresse(adresse);
		evenement.setVille(ville);
		evenement.setCodePostal(codePostal);
		evenement.setNbPlace(nb_place);
		evenement.setPrix(prix);
		evenement.setEtat(0);
		evenement.setInfos(infos);

		// Affectation de l'evenement dans user
		evenement.setDebrief(debrief);
		evenement.setUser(user);
		user.addEvenement(evenement);
		debrief.setEvenement(evenement);

		EvenementService evenementService = RGServiceFactory.getInstance().getEvenementService();
		evenementService.persistEvenement(evenement);

		return evenement;
	}

	@Override
	public EvenementEntity updateEvenement(UserEntity user, Long id, Date d_debut, Date d_fin, String adresse,
			String ville, int codePostal, int nb_place, int prix, String infos)
					throws FonctionnelleException, DonneesInexistantException {
		if (user == null) {
			throw new FonctionnelleException("Erreur, user inconnu.");
		}
		if (id < 0) {
			throw new DonneesInexistantException("nom de l'evenement inexistant");
		}
		EvenementEntity evenement = findById(id);

		EvenementService evenementService = RGServiceFactory.getInstance().getEvenementService();
		if (evenement == null) {
			throw new FonctionnelleException("Erreur, evenement inconnu.");
		}
		if (d_debut != null) {
			evenement.setDateDebut(d_debut);
		}
		if (d_fin != null) {
			evenement.setDateFin(d_fin);
		}
		if (StringUtils.isNotBlank(adresse)) {
			evenement.setAdresse(adresse);
		}
		if (StringUtils.isNotBlank(ville)) {
			evenement.setVille(ville);
		}
		if (StringUtils.isNotBlank(infos)) {
			evenement.setInfos(infos);
		}
		if (codePostal > 0) {
			evenement.setCodePostal(codePostal);
		}
		if (nb_place > 0) {
			evenement.setNbPlace(nb_place);
		}
		if (prix >= 0) {
			evenement.setPrix(prix);
		}
		evenementService.updateEvenement(evenement);
		return evenement;
	}

	@Override
	public EvenementEntity updateEvenementAdmin(Long idEvent, Date d_debut, Date d_fin, String adresse, String ville,
			int codePostal, int nb_place, int prix, String infos)
					throws FonctionnelleException, DonneesInexistantException {

		if (idEvent < 0) {
			throw new DonneesInexistantException("nom de l'evenement inexistant");
		}
		EvenementEntity evenement = findById(idEvent);
		EvenementService evenementService = RGServiceFactory.getInstance().getEvenementService();
		if (evenement == null) {
			throw new FonctionnelleException("Erreur, evenement inconnu.");
		}
		if (d_debut != null) {
			evenement.setDateDebut(d_debut);
		}
		if (d_fin != null) {
			evenement.setDateFin(d_fin);
		}
		if (StringUtils.isNotBlank(adresse)) {
			evenement.setAdresse(adresse);
		}
		if (StringUtils.isNotBlank(ville)) {
			evenement.setVille(ville);
		}
		if (StringUtils.isNotBlank(infos)) {
			evenement.setInfos(infos);
		}
		if (codePostal > 0) {
			evenement.setCodePostal(codePostal);
		}
		if (nb_place > 0) {
			evenement.setNbPlace(nb_place);
		}
		if (prix >= 0) {
			evenement.setPrix(prix);
		}
		evenementService.updateEvenement(evenement);
		return evenement;
	}

	@Override
	public void deleteEvenement(EvenementEntity evenement) {
		EvenementService evenementService = RGServiceFactory.getInstance().getEvenementService();
		evenementService.deleteEvenement(evenement);
	}

	@Override
	public EvenementEntity findByNameEvenement(String nom) {
		EvenementService eveService = RGServiceFactory.getInstance().getEvenementService();
		EvenementEntity evenement = eveService.findEvenementByName(nom);
		return evenement;
	}

	@Override
	public EvenementEntity findById(Long id) {
		EvenementService eventService = RGServiceFactory.getInstance().getEvenementService();
		return eventService.findEvenementById(id);
	}

	@Override
	public List<EvenementEntity> findAllEnvenement() {
		EvenementService eventService = RGServiceFactory.getInstance().getEvenementService();
		return eventService.findAllEvenement();
	}

	@Override
	public List<EvenementEntity> findAllEventByUser(UserEntity user) {
		EvenementService eventService = RGServiceFactory.getInstance().getEvenementService();
		return eventService.findAllEventByUser(user);
	}

	@Override
	public void updateStateEvenement() {
		EvenementService eventService = RGServiceFactory.getInstance().getEvenementService();
		List<EvenementEntity> listEvent = eventService.findAllEvenement();
		for (EvenementEntity event : listEvent) {
			Date date = new Date();
			if (event.getDateDebut().after(date) && event.getDateFin().after(date)) {
				event.setEtat(2);
			} else if (event.getDateDebut().after(date) && event.getDateFin().before(date)) {
				event.setEtat(1);
			}
		}
	}
}
