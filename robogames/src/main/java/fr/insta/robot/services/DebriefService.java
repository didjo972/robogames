package fr.insta.robot.services;

import fr.insta.robot.bo.DebriefEntity;

public interface DebriefService {
	/**
	 * Persiste l'entite en base
	 * @param debrief debrief
	 */
	void persistDebrief(DebriefEntity debrief);
	
	/**
	 * Cherche l'entite en base par son id
	 * @param id l'id
	 * @return Debrief
	 */
	DebriefEntity findDebriefById(Long id);
	
	/**
	 * Met à jour l'entite
	 * @param Debrief Debrief
	 */
	void updateDebrief(DebriefEntity debrief);

	/**
	 * Supprime l'entite
	 * @param Debrief Debrief
	 */
	void deleteDebrief(DebriefEntity debrief);
}
