package fr.insta.robot.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import fr.insta.robot.bo.BilletEntity;
import fr.insta.robot.bo.EvenementEntity;
import fr.insta.robot.bo.UserEntity;

@Entity
@Table(name = "RG_BILLET")
public class BilletEntityImpl implements BilletEntity {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/** l'ID */
	private Long id;
	/** l'User*/
	private UserEntity user;
	/** l'Evenement */
	private EvenementEntity evenement;

	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "BILL_ID",unique = true, nullable = false, precision = 20, scale = 0)
	
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;		
	}
	///////////////////////////////////////////////////////////////////////////////
	@Override
	@ManyToOne(targetEntity = UserEntityImpl.class)
	@JoinColumn(name ="BILL_USER_ID", referencedColumnName="USER_ID")
	public UserEntity getUser() {
		return user;
	}

	@Override
	public void setUser(UserEntity user) {
		this.user = user;
	}

	@Override
	@ManyToOne(targetEntity = EvenementEntityImpl.class)
	@JoinColumn(name ="BILL_EVE_ID", referencedColumnName = "EVE_ID")
	public EvenementEntity getEvenement() {
		return evenement;
	}

	@Override
	public void setEvenement(EvenementEntity evenement) {
		this.evenement = evenement;
	}

}
