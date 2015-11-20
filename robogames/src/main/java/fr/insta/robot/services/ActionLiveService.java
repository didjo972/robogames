package fr.insta.robot.services;

import fr.insta.robot.bo.LiveEntity;
import fr.insta.robot.exceptions.DonneesInexistantException;

public interface ActionLiveService {
	/**
	 * Supprime le lien
	 * @param live
	 * @throws DonneesInexistantException 
	 */
	void delete(LiveEntity live) throws DonneesInexistantException;
	/**
	 * Ajoute une url et remplace une url si existant.
	 * @param url
	 * @return
	 * @throws DonneesInexistantException 
	 */
	LiveEntity ajouteUrl(String url) throws DonneesInexistantException;
	/**
	 * retourne le lien
	 * @return
	 */
	LiveEntity findURL();
	
}