package fr.insta.robot.bo;

import java.io.Serializable;
import java.util.Date;

public interface InformationsEntity extends Serializable {

	/**
	 * Retourne l'id
	 * @return l'id
	 */
	Long getId();
	
	/**
	 * Met à jour l'id
	 * @param id
	 */
	void setId(Long id);
	
	/**
	 * Retourne le nom
	 * @return
	 */
	
	String getNom();
	
	/**
	 * Met à jour le nom
	 * @param nom
	 */
	void setNom(String nom);
	
	/**
	 * Retourne le prénom
	 * @return prenom
	 */
	String getPrenom();
	
	/**
	 * Met à jour le prenom
	 * @param prenom
	 */
	void setPrenom(String prenom);
	
	/**
	 * Retourne l'user
	 * @return l'user
	 */
	UserEntity getUser();
	
	/**
	 * Met à jour l'user
	 * @param user l'user
	 */
	void setUser(UserEntity user);
	/**
	 * Met à jour le pseudo
	 * @param pseudo
	 */
	void setPseudo(String pseudo);
	
	/**
	 * Retourne le pseudo
	 * @return pseudo
	 */
	String getPseudo();
	/**
	 * Met à jour le password
	 * @param encodeMd5
	 */
	
	void setPassword(String encodeMd5);
	/**
	 * Retourne le password crypté par md5
	 * @return
	 */
	String getPassword();
	/**
	 * Retourne email
	 * @return
	 */
	String getEmail();
	/**
	 * Met a jour l'email
	 * @param mail
	 */
	void setEmail(String mail);
	/**
	 * Retourne l'image
	 * @return
	 */
	String getImage();
	/**
	 * Met a jour l'image
	 * @param image
	 */
	void setImage(String image);
	/**
	 * Retourne la derniere date de modification de mot de passe
	 * @return
	 */
	Date getLastUpdate();
	/**
	 * Met a jour la date
	 */
	void setLastUpdate(Date lastUpdate);
	
}
