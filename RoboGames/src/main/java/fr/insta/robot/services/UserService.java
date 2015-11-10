package fr.insta.robot.services;

import fr.insta.robot.bo.UserEntity;

public interface UserService {
	
	/**
	 * Persiste l'entite en base
	 * @param user l'user
	 */
	void persistUser(UserEntity user);
	
	/**
	 * Cherche l'entite en base par son id
	 * @param id l'id
	 * @return un UserEntity
	 */
	UserEntity findUserById(String id);
	
	/**
	 * Met à jour l'entite
	 * @param user l'user
	 */
	void updateUser(UserEntity user);

	/**
	 * Supprime l'entite
	 * @param user l'user
	 */
	void deleteUser(UserEntity user);

	/**
	 * Recherche un user par son pseudo
	 * @param string
	 * @return
	 */
	UserEntity findUserByPseudo(String pseudo);
	
}
