package fr.insta.robot.dao;

import fr.insta.robot.bo.InformationsEntity;


public interface InformationsDAO {

	/**
	 * Persiste l'entite en base
	 * @param informationsEntity l'informationsEntity
	 */
	void persist(InformationsEntity informationsEntity);
	
	/**
	 * Cherche l'entite en base par son id
	 * @param id l'id
	 * @return une informationsEntity
	 */
	InformationsEntity findById(Long id);

	/**
	 * Met à jour l'entite
	 * @param informationsEntity l'informationsEntity
	 */
	void update(InformationsEntity informationsEntity);

	/**
	 * Supprime l'entite
	 * @param informationsEntity l'informationsEntity
	 */
	void delete(InformationsEntity informationsEntity);
	/**
	 * Retourne information par pseudo
	 * @param pseudo
	 */
	InformationsEntity findByPseudo(String pseudo);
	/**
	 * Retourne information par email
	 * @param email
	 * @return
	 */
	InformationsEntity findByEmail(String email);
	
}
