package fr.insta.robot.services;

import java.util.List;

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
	UserEntity findUserById(Long id);
	
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
	 * Retourne la liste des utilisateurs
	 * @return
	 */
	List<UserEntity> findAllUser();

	/**
	 * Retourne la liste des utilisateurs par type
	 * @param typeRole
	 * @return
	 */
	List<UserEntity> findAllUserByType(String typeRole);
	
}
