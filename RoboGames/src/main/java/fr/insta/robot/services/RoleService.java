package fr.insta.robot.services;

import fr.insta.robot.bo.RoleEntity;

public interface RoleService {

	/**
	 * Persiste l'entite en base
	 * @param role le role
	 */
	void persistRole(RoleEntity role);
	
	/**
	 * Cherche l'entite en base par son id
	 * @param id l'id
	 * @return un RoleEntity
	 */
	RoleEntity findRoleById(String id);
	
	/**
	 * Met à jour l'entite
	 * @param role le role
	 */
	void updateRole(RoleEntity role);

	/**
	 * Supprime l'entite
	 * @param role le role
	 */
	void deleteRole(RoleEntity role);
	
}
