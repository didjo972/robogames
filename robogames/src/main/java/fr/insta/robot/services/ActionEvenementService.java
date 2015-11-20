package fr.insta.robot.services;

import java.util.Date;
import java.util.List;

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
	EvenementEntity updateEvenement(UserEntity user, Long id, Date d_debut, Date d_fin, String adresse, String ville, int codePostal,
			int nb_place, int prix, String infos) throws FonctionnelleException, DonneesInexistantException;
	/**
	 * Supprime un evenement 
	 * @param evenement
	 */
	void deleteEvenement(EvenementEntity evenement);
	/**
	 * Retourne l'evenement par nom
	 * @param nom
	 * @return
	 */
	EvenementEntity findByNameEvenement(String nom);
	/**
	 * Retourne l'evenement par id
	 * @param id
	 * @return
	 */
	EvenementEntity findById(Long id);
	/**
	 * Retourne tous les utilisateurs pour l'admin
	 * @param admin
	 * @return
	 * @throws FonctionnelleException 
	 */
	List<EvenementEntity> findAllEnvenement(UserEntity admin) throws FonctionnelleException;
	/**
	 * Retourne tous les utilisateurs par user
	 * @param user
	 * @return
	 */
	List<EvenementEntity> findAllEventByUser(UserEntity user);
	/**
	 * Met a jour un evenement par l'admin
	 * @param id
	 * @param d_debut
	 * @param d_fin
	 * @param adresse
	 * @param ville
	 * @param codePostal
	 * @param nb_place
	 * @param prix
	 * @param infos
	 * @return
	 * @throws FonctionnelleException
	 * @throws DonneesInexistantException
	 */
	EvenementEntity updateEvenementAdmin(Long id, Date d_debut, Date d_fin, String adresse, String ville,
			int codePostal, int nb_place, int prix, String infos)
					throws FonctionnelleException, DonneesInexistantException;
	/**
	 * Mise a jour auto des etats
	 */
	void updateStateEvenement();
	
	
}
