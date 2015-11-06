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
	InformationsEntity findById(String id);

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
	
}
