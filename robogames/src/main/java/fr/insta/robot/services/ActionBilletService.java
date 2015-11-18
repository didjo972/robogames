package fr.insta.robot.services;

import java.util.List;

import fr.insta.robot.bo.BilletEntity;
import fr.insta.robot.bo.EvenementEntity;
import fr.insta.robot.bo.UserEntity;

public interface ActionBilletService {
	/**
	 * creer un billet
	 * @param user
	 */
	void createBillet(UserEntity user, EvenementEntity evenement);
	/**
	 * tous les infos sur les billets
	 * @param admin
	 * @return
	 */
	List<BilletEntity> findAllBillets(UserEntity admin);
	/**
	 * tous les billets par user
	 * @param user
	 * @return
	 */
	List<BilletEntity> findAllbilletsByUser(UserEntity user);
	/**
	 * tous les billets par evenement
	 * @param evenement
	 * @return
	 */
	List<BilletEntity> findAllbilletsByEvenement(EvenementEntity evenement);
	/**
	 * Retourne le billet par id
	 * @param id
	 * @return
	 */
	BilletEntity findById(Long id);
	
	
}
