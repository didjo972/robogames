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
	 * @throws FonctionnelleException 
	 */
	EvenementEntity createEvenement(UserEntity user, String nom, Date d_debut, Date d_fin, String adresse, String ville, int codePostal,
			int nb_place, int prix, String infos) throws DonneesInexistantException, FonctionnelleException;
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
	 * @throws DonneesInexistantException 
	 */
	void updateEvenement(UserEntity user, String nom, Date d_debut, Date d_fin, String adresse, String ville, int codePostal,
			int nb_place, int prix, String infos) throws FonctionnelleException, DonneesInexistantException;
	/**
	 * Supprime un evenement 
	 * @param evenement
	 */
	void deleteEvenement(EvenementEntity evenement);
	/**
	 * 
	 * @param nom
	 * @return
	 */
	EvenementEntity findByNameEvenement(String nom);
	
}
