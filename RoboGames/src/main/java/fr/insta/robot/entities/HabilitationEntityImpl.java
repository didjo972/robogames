package fr.insta.robot.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import fr.insta.robot.bo.HabilitationEntity;
import fr.insta.robot.bo.RoleEntity;
import fr.insta.robot.bo.UserEntity;

@Entity
@Table(name = "RG_HABILITATION")
public class HabilitationEntityImpl implements HabilitationEntity {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/** ID */
	private Long id;
	/** Date de début */
	private Date dateDebut;
	/** Date de fin */
	private Date dateFin;
	/** Etat */
	private boolean etat;
	/** l'User */
	@OneToOne(optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "HAB_USER_ID")
	private UserEntity userH;
	/** Role */
	private RoleEntity role;
	/** Informations de l'habilitation */
	private String infos;
	

	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "HAB_ID",unique = true, nullable = false, precision = 20, scale = 0)	
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name = "HAB_DATE_DEBUT", unique = false, nullable = false)
	@Override
	public Date getDateDebut() {
		return dateDebut;
	}

	@Override
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	@Column(name = "HAB_DATE_FIN", unique = false, nullable = false)
	@Override
	public Date getDateFin() {
		return dateFin;
	}

	@Override
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
		
	}
	@Column(name = "HAB_ETAT", unique = false, nullable = false)
	@Override
	public boolean getEtat() {
		return etat;
	}

	@Override
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	
	@Override
	@JoinColumn(name = "HAB_USER_ID")
	public UserEntity getUser() {
		return userH;
	}

	@Override
	public void setUser(UserEntity user) {
		this.userH = user;
		
	}
	@ManyToOne(targetEntity = RoleEntityImpl.class, optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name ="HAB_ROL_ID")
	@Override
	public RoleEntity getRole() {
		return role;
	}

	@Override
	public void setRole(RoleEntity role) {
		this.role = role;
	}
	
	@Column(name = "HAB_INFOS", unique = false, nullable = false, length = 255)
	@Override
	public String getInfos() {
		return infos;
	}

	@Override
	public void setInfos(String infos) {
		this.infos = infos;
	}

}
