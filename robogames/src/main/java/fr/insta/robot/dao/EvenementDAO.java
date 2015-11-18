package fr.insta.robot.dao;

import java.util.List;

import fr.insta.robot.bo.EvenementEntity;
import fr.insta.robot.bo.UserEntity;

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
	/**
	 * Retourne l'evenement
	 * @param nom
	 */
	EvenementEntity findByName(String nom);
	/**
	 * Retourne tous les events
	 * @return
	 */
	List<EvenementEntity> findAll();
	/**
	 * Retourne tous les events de l'user
	 * @param user
	 * @return
	 */
	List<EvenementEntity> findByUser(UserEntity user);
	
}
