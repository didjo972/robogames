package fr.insta.robot.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import fr.insta.robot.bo.BilletEntity;
import fr.insta.robot.bo.DebriefEntity;
import fr.insta.robot.bo.EvenementEntity;
import fr.insta.robot.bo.UserEntity;

@Entity
@Table(name = "RG_EVENEMENT")
public class EvenementEntityImpl implements EvenementEntity {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/** l'ID */
	private Long id;
	/** Date de debut */
	private Date dateDebut;
	/** Date de Fin */
	private Date dateFin;
	/** Adresse */
	private String adresse;
	/** Code Postal */
	private int codePostal;
	/** Ville */
	private String ville;
	/** nombre de places */
	private int nbPlace;
	/** prix */
	private int prix;
	/** Etat de l'événement */
	private boolean etat;
	/** Informations sur l'événement */
	private String infos;
	/** Valide */
	private boolean valide;
	/** Un événement à un utilisateur */
	
	private UserEntity user;
	/** Billet */
	private Set<BilletEntity> billets = new HashSet<BilletEntity>();
	/** Debrief */
	private DebriefEntity debrief;
	
	
	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "EVE_ID",unique = true, nullable = false, precision = 20, scale = 0)
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;

	}
	@Override
	@Column(name = "EVE_DATE_DEBUT", unique = false, nullable = false)
	public Date getDateDebut() {
		return dateDebut;
	}

	@Override
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;

	}

	@Override
	@Column(name = "EVE_DATE_FIN", unique = false, nullable = false)
	public Date getDateFin() {
		return dateFin;
	}

	@Override
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	
	@Override
	@Column(name = "EVE_ADRESSE", unique = false, nullable = false, length = 100)
	public String getAdresse() {
		return adresse;
	}

	@Override
	public void setAdresse(String adresse) {
		this.adresse = adresse;

	}

	@Override
	@Column(name = "EVE_CODE_POSTAL", unique = false, nullable = false)
	public int getCodePostal() {
		return codePostal;
	}

	@Override
	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;

	}
	@Column(name = "EVE_VILLE", unique = false, nullable = false, length = 100)
	@Override
	public String getVille() {
		return ville;
	}

	@Override
	public void setVille(String ville) {
		this.ville = ville;
	}
	@Column(name = "EVE_NB_PLACE", unique = false, nullable = false)
	@Override
	public int getNbPlace() {
		return nbPlace;
	}

	@Override
	public void setNbPlace(int nbPlace) {
		this.nbPlace = nbPlace;

	}
	@Column(name = "EVE_PRIX", unique = false, nullable = false)
	@Override
	public int getPrix() {
		return prix;
	}

	@Override
	public void setPrix(int prix) {
		this.prix = prix;
	}
	@Column(name = "EVE_ETAT", unique = false, nullable = false)
	@Override
	public boolean getEtat() {
		return etat;
	}

	@Override
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	@Column(name = "EVE_INFOS", unique = false, nullable = false, columnDefinition = "LONGTEXT")
	@Override
	public String getInfos() {
		return infos;
	}

	@Override
	public void setInfos(String infos) {
		this.infos = infos;

	}
	@Column(name = "EVE_VALIDE", unique = false, nullable = false)
	@Override
	public boolean getValide() {
		return valide;
	}

	@Override
	public void setValide(boolean valide) {
		this.valide = valide;

	}
	//////////////////////////////////////////////////////////////////////////////////
	@Override
	@ManyToOne(targetEntity = UserEntityImpl.class)
	@JoinColumn(name ="EVE_USER_ID", referencedColumnName="USER_ID")
	public UserEntity getUser() {
		return user;
	}

	@Override
	public void setUser(UserEntity user) {
		this.user = user;

	}
	@Override
	@OneToMany(mappedBy = "evenement", targetEntity = BilletEntityImpl.class, cascade = CascadeType.ALL)
	public Set<BilletEntity> getBillets() {
		return billets;
	}
	@Override
	public void setBillets(Set<BilletEntity> billets) {
		this.billets = billets;
	}
	@Override
	@OneToOne(mappedBy = "evenement", targetEntity = DebriefEntityImpl.class, cascade = CascadeType.ALL)
	public DebriefEntity getDebrief() {
		return debrief;
	}
	@Override
	public void setDebrief(DebriefEntity debrief) {
		this.debrief = debrief;
	}
	

}
