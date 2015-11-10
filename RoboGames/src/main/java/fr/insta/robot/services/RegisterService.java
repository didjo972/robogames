package fr.insta.robot.services;

import java.security.NoSuchAlgorithmException;

import fr.insta.robot.bo.UserEntity;
import fr.insta.robot.exceptions.DonneesInexistantException;
import fr.insta.robot.exceptions.FonctionnelleException;

public interface RegisterService {
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
	
	void updateUser(UserEntity user ,String nom, String prenom, String oldpass, String newpass) throws DonneesInexistantException, FonctionnelleException;
	
	
}
