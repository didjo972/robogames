package fr.insta.robot.dao;

import java.util.List;

import fr.insta.robot.bo.HabilitationEntity;

public interface HabilitationDAO {

	/**
	 * Persiste l'entite en base
	 * @param habilitationEntity l'habilitationEntity
	 */
	void persist(HabilitationEntity habilitationEntity);
	
	/**
	 * Cherche l'entite en base par son id
	 * @param id l'id
	 * @return une habilitationEntity
	 */
	HabilitationEntity findById(Long id);

	/**
	 * Met à jour l'entite
	 * @param habilitationEntity l'habilitationEntity
	 */
	void update(HabilitationEntity habilitationEntity);

	/**
	 * Supprime l'entite
	 * @param habilitationEntity l'habilitationEntity
	 */
	void delete(HabilitationEntity habilitationEntity);

	/**
	 * Retourne toutes les habilitations
	 * @return retourne toutes les habilitations
	 */
	List<HabilitationEntity> findAll();
	
	
	
	
}
