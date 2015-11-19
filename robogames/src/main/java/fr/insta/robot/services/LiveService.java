package fr.insta.robot.services;

import java.util.List;

import fr.insta.robot.bo.LiveEntity;

public interface LiveService {

	/**
	 * Persiste l'entite en base
	 * @param live le live
	 */
	void persistLive(LiveEntity live);
	
	/**
	 * Cherche l'entite en base par son id
	 * @param id l'id
	 * @return un LiveEntity
	 */
	LiveEntity findLiveById(Long id);
	
	/**
	 * Met à jour l'entite
	 * @param live le live
	 */
	void updateLive(LiveEntity live);

	/**
	 * Supprime l'entite
	 * @param live le live
	 */
	void deleteLive(LiveEntity live);
	/**
	 * Retourne tous les lives
	 * @return
	 */
	List<LiveEntity> findAllLive();
	
}
