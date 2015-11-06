package fr.insta.robot.services;

import fr.insta.robot.bo.BilletEntity;

public interface BilletService {

	/**
	 * Persiste l'entite en base
	 * @param billet l'billet
	 */
	void persistBillet(BilletEntity billet);
	
	/**
	 * Cherche l'entite en base par son id
	 * @param id l'id
	 * @return un UserEntity
	 */
	BilletEntity findBilletById(String id);
	
	/**
	 * Met à jour l'entite
	 * @param billet l'billet
	 */
	void updateBillet(BilletEntity billet);

	/**
	 * Supprime l'entite
	 * @param billet l'billet
	 */
	void deleteBillet(BilletEntity billet);
	
}
