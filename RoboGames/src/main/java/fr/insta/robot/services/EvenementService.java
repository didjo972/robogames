package fr.insta.robot.services;

import fr.insta.robot.bo.EvenementEntity;

public interface EvenementService {
	
	/**
	 * Persiste l'entite en base
	 * @param evenement l'evenement
	 */
	void persistEvenement(EvenementEntity evenement);
	
	/**
	 * Cherche l'entite en base par son id
	 * @param id l'id
	 * @return un EvenementEntity
	 */
	EvenementEntity findEvenementById(String id);
	
	/**
	 * Met à jour l'entite
	 * @param evenement l'evenement
	 */
	void updateEvenement(EvenementEntity evenement);

	/**
	 * Supprime l'entite
	 * @param evenement l'evenement
	 */
	void deleteEvenement(EvenementEntity evenement);
	
}
