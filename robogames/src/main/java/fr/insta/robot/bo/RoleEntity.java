package fr.insta.robot.bo;

import java.io.Serializable;
import java.util.Set;

public interface RoleEntity extends Serializable {

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
	 * Retourne le libelle
	 * @return le libelle
	 */
	String getLibelle();
	
	/**
	 * Met à jour le libelle
	 * @param libelle le libelle
	 */
	void setLibelle(String libelle);
	//////////////////////////////////////////////////////////////////
	/**
	 * Retourne un set d'habilitations
	 * @return
	 */
	Set<HabilitationEntity> getHabilitations();
	/**
	 * Met a jour le set d'habilitations
	 * @param habilitations
	 */
	void setHabilitations(Set<HabilitationEntity> habilitations);
	/**
	 * Ajoute une habilitation
	 * @param habilitation
	 */
	void addHabilitations(HabilitationEntity habilitation);
	/**
	 * Supprime une habilitation
	 * @param habilitation
	 */
	void removeHabilitations(HabilitationEntity habilitation);
}
