package fr.insta.robot.dao;

import java.util.List;

import fr.insta.robot.bo.UserEntity;

public interface UserDAO {

	/**
	 * Persiste l'entite en base
	 * @param user l'user
	 */
	void persist(UserEntity user);
	
	/**
	 * Cherche l'entite en base par son id
	 * @param id l'id
	 * @return un UserEntity
	 */
	UserEntity findById(Long id);

	/**
	 * Met à jour l'entite
	 * @param user l'user
	 */
	void update(UserEntity user);

	/**
	 * Supprime l'entite
	 * @param user l'user
	 */
	void delete(UserEntity user);
	/**
	 * Retourne la liste des utilisateurs
	 * @return
	 */
	List<UserEntity> findAllUser();
	
	
	
}
