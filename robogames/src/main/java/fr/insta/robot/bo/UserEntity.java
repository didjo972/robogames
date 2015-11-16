package fr.insta.robot.bo;

import java.io.Serializable;
import java.util.Set;

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
	 * Retourne l'etat du compte
	 * @return
	 */
	boolean getEtat();
	/**
	 * Met à jour l'etat
	 * @param etat
	 */
	void setEtat(boolean etat);
	/**
	 * Ajoute un evenement
	 * @param e
	 */

	////////////////////Evenements //////////////////////////

	public Set<EvenementEntity> getEvenements();
	/**
	 * Met a jour le set d'evenements
	 * @param evenements
	 */
	public void setEvenements(Set<EvenementEntity> evenements);
	
	////////////////////Habilitation //////////////////////////
	/**
	 * Retourne une habilitation
	 * @return
	 */
	public HabilitationEntity getHabilitation();
	/**
	 * Met a jour l'habilitation
	 * @param habilitation
	 */
	public void setHabilitation(HabilitationEntity habilitation);

	////////////////////Billets //////////////////////////
	/**
	 * Retourne un set de billets
	 * @return
	 */
	public Set<BilletEntity> getBillets();
	/**
	 * Met a jour le set de billets
	 * @param billets
	 */
	public void setBillets(Set<BilletEntity> billets);
	/**
	 * Retourne les informations
	 * @param information
	 */
	void setInformation(InformationsEntity information);
	/**
	 * Met a jour les informations
	 * @return
	 */
	InformationsEntity getInformation();
}
