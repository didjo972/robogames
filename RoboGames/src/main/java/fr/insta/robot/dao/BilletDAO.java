package fr.insta.robot.dao;

import fr.insta.robot.bo.BilletEntity;

public interface BilletDAO {

	/**
	 * Persiste l'entite en base
	 * @param billet le billet
	 */
	void persist(BilletEntity billet);

	/**
	 * Cherche l'entite en base par son id
	 * @param id l'id
	 * @return un BilletEntity
	 */
	BilletEntity findById(String id);

	/**
	 * Met à jour l'entite 
	 * @param billet le billet
	 */
	void update(BilletEntity billet);

	/**
	 * Supprime l'entite 
	 * @param billet le billet
	 */
	void delete(BilletEntity billet);
}
