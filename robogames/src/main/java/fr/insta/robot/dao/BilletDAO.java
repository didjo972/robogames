package fr.insta.robot.dao;

import java.util.List;

import fr.insta.robot.bo.BilletEntity;
import fr.insta.robot.bo.EvenementEntity;
import fr.insta.robot.bo.UserEntity;

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
	BilletEntity findById(Long id);

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
	/**
	 * 
	 * @param evenement
	 * @return
	 */
	List<BilletEntity> findAllBilletByEvenement(EvenementEntity evenement);
	/**
	 * 
	 * @return
	 */
	List<BilletEntity> findAllBillet();
	/**
	 * 
	 * @param user
	 * @return
	 */
	List<BilletEntity> findAllBilletsByUser(UserEntity user);
}
