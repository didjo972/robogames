package fr.insta.robot.services;

import java.util.List;

import fr.insta.robot.bo.BilletEntity;
import fr.insta.robot.bo.EvenementEntity;
import fr.insta.robot.bo.UserEntity;

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
	BilletEntity findBilletById(Long id);
	
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
	/**
	 * Retourne tous les billets
	 * @return
	 */
	List<BilletEntity> findAllBillets();
	/**
	 * Retourne tous les billets user
	 * @param user
	 * @return
	 */
	List<BilletEntity> findAllBilletsByUser(UserEntity user);
	/**
	 * Retourne tous les billets par evenement
	 * @param evenement
	 * @return
	 */
	List<BilletEntity> findAllBilletsByEvenement(EvenementEntity evenement);
	
}
