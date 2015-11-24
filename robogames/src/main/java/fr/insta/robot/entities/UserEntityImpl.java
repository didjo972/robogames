package fr.insta.robot.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import fr.insta.robot.bo.BilletEntity;
import fr.insta.robot.bo.EvenementEntity;
import fr.insta.robot.bo.HabilitationEntity;
import fr.insta.robot.bo.InformationsEntity;
import fr.insta.robot.bo.UserEntity;

@Entity
@Table(name = "RG_USER")
public class UserEntityImpl implements UserEntity {

	/** serialVersionUID **/
	private static final long serialVersionUID = 1L;
	/** L'Id */
	private Long id;
	/** etat */
	private boolean etat;
	/** evenements */
	private Set<EvenementEntity> evenements = new HashSet<EvenementEntity>();
	/** billet */
	private Set<BilletEntity> billets = new HashSet<BilletEntity>();
	/** Habilitation */
	private HabilitationEntity habilitation;
	/** Information */
	private InformationsEntity information;

	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID", unique = true, nullable = false, precision = 20, scale = 0)
	public Long getId() {
		return this.id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}
	@Override
	@Column(name = "USER_ETAT", nullable = false)
	public boolean getEtat() {
		return etat;
	}

	@Override
	public void setEtat(boolean etat) {
		this.etat = etat;	
	}
		
	/***********************************************************************/
	@Override
	@OneToMany(mappedBy = "user", targetEntity = EvenementEntityImpl.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public Set<EvenementEntity> getEvenements() {
		return evenements;
	}
	@Override
	public void setEvenements(Set<EvenementEntity> evenements) {
		this.evenements = evenements;
	}
	@Override
	@OneToMany(mappedBy = "user", targetEntity = BilletEntityImpl.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public Set<BilletEntity> getBillets() {
		return billets;
	}
	@Override
	public void setBillets(Set<BilletEntity> billets) {
		this.billets = billets;
	}

	@Override
	@OneToOne(mappedBy = "user", targetEntity = HabilitationEntityImpl.class, cascade = CascadeType.ALL)
	public HabilitationEntity getHabilitation() {
		return habilitation;
	}

	@Override
	public void setHabilitation(HabilitationEntity habilitation) {
		this.habilitation = habilitation;
	}
	@Override
	@OneToOne(mappedBy = "user", targetEntity = InformationsEntityImpl.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public InformationsEntity getInformation() {
		return information;
	}
	@Override
	public void setInformation(InformationsEntity information) {
		this.information = information;
	}
	/*************************************************************/
	//Methode d'ajout dans les set
	@Override
	public void addEvenement(EvenementEntity evenement){
		evenements.add(evenement);
	}
	@Override
	public void removeEvenement(EvenementEntity evenement){
		evenements.remove(evenement);
	}
	@Override
	public void addBillets(BilletEntity billet){
		billets.add(billet);
	}
	@Override
	public void removeBillets(BilletEntity billet){
		billets.remove(billet);
	}	
}
