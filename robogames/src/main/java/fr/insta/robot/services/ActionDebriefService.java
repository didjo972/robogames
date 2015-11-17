package fr.insta.robot.services;

import fr.insta.robot.bo.DebriefEntity;
import fr.insta.robot.bo.EvenementEntity;
import fr.insta.robot.exceptions.DonneesInexistantException;

public interface ActionDebriefService {
	/**
	 * Ajouter un debrief a un event
	 * @param evenement
	 * @param debrief
	 * @throws DonneesInexistantException 
	 */
	void addDebriefEvenement(EvenementEntity evenement, String debrief) throws DonneesInexistantException;
	/**
	 * Supprime le contenu du debrief
	 * @param evenement
	 * @throws DonneesInexistantException
	 */
	void deleteDebriefEvenement(EvenementEntity evenement) throws DonneesInexistantException;
	/**
	 * Retourne le debrief par id
	 * @param id
	 * @return
	 */
	DebriefEntity findDebriefById(Long id);
}
