package fr.insta.robot.services;

import java.util.Date;

import fr.insta.robot.bo.EvenementEntity;
import fr.insta.robot.bo.UserEntity;
import fr.insta.robot.exceptions.DonneesInexistantException;
import fr.insta.robot.exceptions.FonctionnelleException;

public interface ActionEvenementService {
	/**
	 * Creer un evenement avec un utilisateur
	 * @param user
	 * @param d_debut
	 * @param d_fin
	 * @param adresse
	 * @param ville
	 * @param codePostal
	 * @param nb_place
	 * @param prix
	 * @param infos
	 * @throws DonneesInexistantException 
	 */
	EvenementEntity createEvenement(UserEntity user, Date d_debut, Date d_fin, String adresse, String ville, int codePostal,
			int nb_place, int prix, String infos) throws DonneesInexistantException;
	/**
	 * Modifie un evenement par l'utilisateur
	 * @param evenement
	 * @param d_debut
	 * @param d_fin
	 * @param adresse
	 * @param ville
	 * @param codePostal
	 * @param nb_place
	 * @param prix
	 * @param infos
	 * @throws FonctionnelleException 
	 */
	void updateEvenement(EvenementEntity evenement,Date d_debut, Date d_fin, String adresse, String ville, int codePostal,
			int nb_place, int prix, String infos) throws FonctionnelleException;
	/**
	 * Supprime un evenement 
	 * @param evenement
	 */
	void deleteEvenement(EvenementEntity evenement);
	/**
	 * Ajoute un debrief
	 * @param evenement
	 * @param debrief
	 * @throws DonneesInexistantException
	 */
	void addDebriefEvenement(EvenementEntity evenement, String debrief) throws DonneesInexistantException;
	
}
