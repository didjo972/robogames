package fr.insta.robot.services;

import fr.insta.robot.bo.LiveEntity;
import fr.insta.robot.exceptions.DonneesInexistantException;

public interface ActionLiveService {
	/**
	 * Creer un live
	 * @param url
	 * @return
	 * @throws DonneesInexistantException 
	 */
	LiveEntity createLive(String url) throws DonneesInexistantException;
	/**
	 * update l'url 
	 * @param url
	 * @return
	 * @throws DonneesInexistantException 
	 */
	LiveEntity updateLive(LiveEntity live, String url) throws DonneesInexistantException;
	/**
	 * Retourne l'id du live
	 */
	LiveEntity findById(Long id);
	/**
	 * Supprime le lien
	 * @param live
	 * @throws DonneesInexistantException 
	 */
	void delete(LiveEntity live) throws DonneesInexistantException;
}