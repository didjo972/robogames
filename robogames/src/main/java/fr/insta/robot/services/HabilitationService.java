package fr.insta.robot.services;

import fr.insta.robot.bo.HabilitationEntity;

public interface HabilitationService {

	/**
	 * Persiste l'entite en base
	 * @param habilitation l'habilitation
	 */
	void persistHabilitation(HabilitationEntity habilitation);
	
	/**
	 * Cherche l'entite en base par son id
	 * @param id l'id
	 * @return un HabilitationEntity
	 */
	HabilitationEntity findHabilitationById(Long id);
	
	/**
	 * Met à jour l'entite
	 * @param habilitation l'habilitation
	 */
	void updateHabilitation(HabilitationEntity habilitation);

	/**
	 * Supprime l'entite
	 * @param habilitation l'habilitation
	 */
	void deleteHabilitation(HabilitationEntity habilitation);
	
}
