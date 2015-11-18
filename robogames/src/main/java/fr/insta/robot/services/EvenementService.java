package fr.insta.robot.services;

import java.util.List;

import fr.insta.robot.bo.EvenementEntity;
import fr.insta.robot.bo.UserEntity;

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
	EvenementEntity findEvenementById(Long id);
	
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
	/**
	 * Retourne l'evenement par le nom
	 * @param nom
	 * @return
	 */
	EvenementEntity findEvenementByName(String nom);
	/**
	 * Retourne tous les evenements
	 * @return
	 */
	List<EvenementEntity> findAllEvenement();
	/**
	 * 
	 * @param user
	 */
	List<EvenementEntity> findAllEventByUser(UserEntity user);
	
}
