package fr.insta.robot.services;

import java.util.Set;

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
	Set<BilletEntity> findAllBillets(UserEntity admin);
	
	
}
