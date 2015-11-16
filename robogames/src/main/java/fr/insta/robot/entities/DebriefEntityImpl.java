package fr.insta.robot.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import fr.insta.robot.bo.DebriefEntity;
import fr.insta.robot.bo.EvenementEntity;

@Entity
@Table(name = "RG_DEBRIEFING")
public class DebriefEntityImpl implements DebriefEntity {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/** l'ID */
	private Long id;
	/** Text */
	private String debrief;
	/** Evenement */
	private EvenementEntity evenement;
	
	
	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "DEB_ID",unique = true, nullable = false, precision = 20, scale = 0)
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	@Column(name = "DEB_DEBRIEF", unique = false, nullable = false, columnDefinition = "LONGTEXT")
	public String getDebrief() {
		return debrief;
	}

	@Override
	public void setDebrief(String debrief) {
		this.debrief = debrief;
	}

	@Override
	@OneToOne(fetch=FetchType.LAZY, targetEntity = EvenementEntityImpl.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "DEB_EVE_ID", referencedColumnName="EVE_ID")
	public EvenementEntity getEvenement() {
		return evenement;
	}

	@Override
	public void setEvenement(EvenementEntity evenement) {
		this.evenement = evenement;
	}
	

}
