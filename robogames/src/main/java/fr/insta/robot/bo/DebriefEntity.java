package fr.insta.robot.bo;

import java.io.Serializable;

public interface DebriefEntity extends Serializable{
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
	
	String getDebrief();
	/**
	 * Met a jour le debrief
	 * @param debrief
	 */
	void setDebrief(String debrief);
	/**
	 * Retourne l'evenement
	 * @return
	 */
	EvenementEntity getEvenement();
	/**
	 * Met a jour l'evenement
	 * @param evenement
	 */
	void setEvenement(EvenementEntity evenement);
	
	
}
