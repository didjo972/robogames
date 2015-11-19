package fr.insta.robot.dao;

import java.util.List;

import fr.insta.robot.bo.LiveEntity;

public interface LiveDAO {

	/**
	 * Persiste l'entite en base
	 * @param liveEntity l'liveEntity
	 */
	void persist(LiveEntity liveEntity);
	
	/**
	 * Cherche l'entite en base par son id
	 * @param id l'id
	 * @return un liveEntity
	 */
	LiveEntity findById(Long id);

	/**
	 * Met à jour l'entite
	 * @param liveEntity l'liveEntity
	 */
	void update(LiveEntity liveEntity);

	/**
	 * Supprime l'entite
	 * @param liveEntity l'liveEntity
	 */
	void delete(LiveEntity liveEntity);
	/**
	 * Retourne tous les lives
	 * @return
	 */
	List<LiveEntity> findAllLive();
	
}
