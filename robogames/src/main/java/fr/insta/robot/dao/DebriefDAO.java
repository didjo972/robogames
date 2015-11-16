package fr.insta.robot.dao;

import fr.insta.robot.bo.DebriefEntity;

public interface DebriefDAO {
	/**
	 * Persiste l'entite en base
	 * @param debrief
	 */
	void persist(DebriefEntity debrief);

	/**
	 * Cherche l'entite en base par son id
	 * @param id l'id
	 * @return debrief
	 */
	DebriefEntity findById(Long id);

	/**
	 * Met à jour l'entite 
	 * @param debrief
	 */
	void update(DebriefEntity debrief);

	/**
	 * Supprime l'entite 
	 * @param debrief
	 */
	void delete(DebriefEntity debrief);
}
