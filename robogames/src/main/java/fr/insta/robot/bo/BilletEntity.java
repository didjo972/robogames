package fr.insta.robot.bo;

import java.io.Serializable;

public interface BilletEntity extends Serializable {

	/**
	 * Retourne l'id
	 * @return l'id
	 */
	Long getId();
	
	/**
	 * Met à jour l'id
	 * @param id l'id
	 */
	void setId(Long id);
	
	/**
	 * Retourne l'user
	 * @return user
	 */
	UserEntity getUser();
	
	/**
	 * Met à jour l'user
	 * @param user l'user
	 */
	void setUser(UserEntity user);
	
	/**
	 * Retourne l'evenement
	 * @return evenement
	 */
	EvenementEntity getEvenement();
	
	/**
	 * Met à jour l'evenement
	 * @param evenement l'evenement
	 */
	void setEvenement(EvenementEntity evenement);
	
}
