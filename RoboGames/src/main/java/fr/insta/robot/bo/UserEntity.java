package fr.insta.robot.bo;

import java.io.Serializable;

public interface UserEntity extends Serializable {

	/**
	 * Retourne l'id
	 * @return l'id
	 */
	Long getId();

	/**
	 * Met à jour l'id
	 * @param id l'id
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
	 * Retourne l'email 
	 * @return
	 */
	String getEmail();
	/**
	 * Met à jour l'email
	 * @param email
	 */
	void setEmail(String email);

}
