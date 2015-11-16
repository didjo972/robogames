package fr.insta.robot.bo;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public interface EvenementEntity extends Serializable {

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
	 * Retourne la date de début
	 * @return la date de début
	 */
	Date getDateDebut();
	
	/**
	 * Met à jour la date de début
	 * @param dateDebut date de début
	 */
	void setDateDebut(Date dateDebut);
	
	/**
	 * Retourne la date de fin
	 * @return dateFin date de fin
	 */
	Date getDateFin();
	
	/**
	 * Met à jour la date de fin
	 * @param dateFin date de fin
	 */
	void setDateFin(Date dateFin);
	
	/**
	 * Retourne l'adresse
	 * @return l'adresse
	 */
	String getAdresse();
	
	/**
	 * Met à jour l'adresse
	 * @param adresse l'adresse
	 */
	void setAdresse(String adresse);
	
	/**
	 * Retourne le code postal
	 * @return le code postal
	 */
	int getCodePostal();
	
	/**
	 * Met à jour le code postal
	 * @param codePostal le code postal
	 */
	void setCodePostal(int codePostal);
	
	/**
	 * Retourne la ville
	 * @return la ville
	 */
	String getVille();
	
	/**
	 * Met à jour la ville
	 * @param ville la ville
	 */
	void setVille(String ville);
	
	/**
	 * Retourne le nombre de place
	 * @return nbPlace
	 */
	int getNbPlace();
	
	/**
	 * Met à jour le nombre de place
	 * @param nbPlace le nombre de place
	 */
	void setNbPlace(int nbPlace);
	
	/**
	 * Retourne le prix
	 * @return le prix
	 */
	int getPrix();
	
	/**
	 * Met à jour le prix
	 * @param prix le prix
	 */
	void setPrix(int prix);
	
	/**
	 * Retourne l'etat
	 * @return l'etat
	 */
	boolean getEtat();
	
	/**
	 * Met à jour l'etat
	 * @param etat l'etat
	 */
	void setEtat(boolean etat);
	
	/**
	 * Retourne infos
	 * @return infos
	 */
	String getInfos();
	
	/**
	 * Met à jour infos
	 * @param infos l'infos
	 */
	void setInfos(String infos);
	
	/**
	 * Retourne valide
	 * @return valide
	 */
	boolean getValide();
	
	/**
	 * Met à jour valide
	 * @param valide valide
	 */
	void setValide(boolean valide);
	
	/**
	 * Retourne l'User
	 * @return user
	 */
	UserEntity getUser();
	
	/**
	 * Met à jour l'User
	 * @param user l'user
	 */
	void setUser(UserEntity user);
	/**
	 * Retourne les billets de l'evenement
	 * @return
	 */
	Set<BilletEntity> getBillets();
	/**
	 * Met a jour les billets
	 * @param billets
	 */
	void setBillets(Set<BilletEntity> billets);
	/**
	 * retourne le debrief
	 * @return
	 */
	DebriefEntity getDebrief();
	/**
	 * Met a jour le debrief
	 * @param debrief
	 */
	void setDebrief(DebriefEntity debrief);
}
