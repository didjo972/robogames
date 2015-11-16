package fr.insta.robot.dao;

import fr.insta.robot.bo.EvenementEntity;

public interface EvenementDAO {

	/**
	 * Persiste l'entite en base
	 * @param evenementEntity l'EvenementEntity
	 */
	void persist(EvenementEntity evenementEntity);
	
	/**
	 * Cherche l'entite en base par son id
	 * @param id l'id
	 * @return un EvenementEntity
	 */
	EvenementEntity findById(Long id);

	/**
	 * Met à jour l'entite
	 * @param EvenementEntity l'EvenementEntity
	 */
	void update(EvenementEntity evenementEntity);

	/**
	 * Supprime l'entite
	 * @param EvenementEntity l'EvenementEntity
	 */
	void delete(EvenementEntity evenementEntity);
	
}
