package fr.insta.robot.bo;

import java.io.Serializable;
import java.util.Date;

public interface HabilitationEntity extends Serializable {

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
	 * Retourne l'état
	 * @return l'etat
	 */
	boolean getEtat();
	
	/**
	 * Met à jour l'état
	 * @param l'etat
	 */
	void setEtat(boolean etat);
	
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
	 * Retourne le role
	 * @return le role
	 */
	RoleEntity getRole();
	
	/**
	 * Met à jour le role
	 * @param role le role
	 */
	void setRole(RoleEntity role);
	
	/**
	 * Retourne l'infos
	 * @return l'infos
	 */
	String getInfos();
	
	/**
	 * Met à jour l'infos
	 * @param infos l'infos
	 */
	void setInfos(String infos);
}
