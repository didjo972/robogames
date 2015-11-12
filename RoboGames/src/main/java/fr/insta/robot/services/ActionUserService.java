package fr.insta.robot.services;

import java.security.NoSuchAlgorithmException;

import fr.insta.robot.bo.UserEntity;
import fr.insta.robot.exceptions.DonneesInexistantException;
import fr.insta.robot.exceptions.FonctionnelleException;

public interface ActionUserService {
	/**
	 * Creer un user
	 * @param nom
	 * @param prenom
	 * @param pseudo
	 * @param password
	 * @param mail
	 * @throws DonneesInexistantException 
	 * @throws FonctionnelleException 
	 */
	void createUser(String nom, String prenom, String pseudo, String password, String mail) throws DonneesInexistantException, FonctionnelleException;
	/**
	 * Retourne une chaine crypté en md5
	 * @param password
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	String encodeMd5(String password) throws NoSuchAlgorithmException;
	/**
	 * Modifier le nom et prénom de l'utilisateur
	 * @param user
	 * @param nom
	 * @param prenom
	 * @param oldpass
	 * @param newpass
	 * @throws DonneesInexistantException
	 * @throws FonctionnelleException
	 */
	void updateUser(UserEntity user ,String nom, String prenom, String email,String oldpass, String newpass) throws DonneesInexistantException, FonctionnelleException;
	/**
	 * Retourne un user à partir d'un mot de passe et d'un pseudo
	 * @param pseudo
	 * @param password
	 * @throws DonneesInexistantException 
	 * @throws FonctionnelleException 
	 * 
	 */
	UserEntity loginUser(String pseudo_email, String password) throws DonneesInexistantException, FonctionnelleException;
	/**
	 * Desactive le compte par l'action de l'utilisateur.
	 * @param user
	 */
	void disableUser(UserEntity user);
	/**
	 * Réinitialise le mot de passe
	 * @param pseudo_email
	 * @throws FonctionnelleException 
	 */
	String resetPasswordUser(String pseudo_email) throws FonctionnelleException;
	
}
