package fr.insta.robot.dao;

import fr.insta.robot.bo.RoleEntity;

public interface RoleDAO {

	/**
	 * Persiste l'entite en base
	 * @param roleEntity l'roleEntity
	 */
	void persist(RoleEntity roleEntity);
	
	/**
	 * Cherche l'entite en base par son id
	 * @param id l'id
	 * @return un roleEntity
	 */
	RoleEntity findById(Long id);

	/**
	 * Met à jour l'entite
	 * @param roleEntity l'roleEntity
	 */
	void update(RoleEntity roleEntity);

	/**
	 * Supprime l'entite
	 * @param roleEntity l'roleEntity
	 */
	void delete(RoleEntity roleEntity);
	
}
