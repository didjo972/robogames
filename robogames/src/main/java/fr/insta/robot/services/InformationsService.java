package fr.insta.robot.services;

import fr.insta.robot.bo.InformationsEntity;

public interface InformationsService {

	/**
	 * Persiste l'entite en base
	 * @param informations l'informations
	 */
	void persistInformations(InformationsEntity informations);
	
	/**
	 * Cherche l'entite en base par son id
	 * @param id l'id
	 * @return un InformationsEntity
	 */
	InformationsEntity findInformationsById(Long id);
	
	/**
	 * Met à jour l'entite
	 * @param informations l'informations
	 */
	void updateInformations(InformationsEntity informations);

	/**
	 * Supprime l'entite
	 * @param informations l'informations
	 */
	void deleteInformations(InformationsEntity informations);
	/**
	 * Retourne l'information du pseudo
	 * @param pseudo
	 * @return
	 */
	InformationsEntity findInformationsByPseudo(String pseudo);
	/**
	 * Retourne l'information de l'email
	 * @param email
	 * @return
	 */
	InformationsEntity findInformationsByEmail(String email);
	
	
}
