package fr.insta.robot.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import fr.insta.robot.bo.InformationsEntity;
import fr.insta.robot.bo.UserEntity;

@Entity
@Table(name = "RG_INFORMATIONS")
public class InformationsEntityImpl implements InformationsEntity {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/** Id */
	private Long id;
	/** Nom */
	private String nom;
	/** prenom */
	private String prenom;
	/** pseudo */
	private String pseudo;
	/** password */
	private String password;
	/** Utilisateur */
	@OneToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "INF_USER_ID")
	private UserEntity userI;

	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "INF_ID",unique = true, nullable = false, precision = 20, scale = 0)	
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	@Column(name = "INF_NOM", unique = false, nullable = false, length = 100)
	public String getNom() {
		return nom;
	}

	@Override
	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	@Column(name = "INF_PRENOM", unique = false, nullable = false, length = 100)
	public String getPrenom() {
		return prenom;
	}

	@Override
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	
	@Override
	public UserEntity getUser() {
		return userI;
	}

	@Override
	public void setUser(UserEntity user) {
		this.userI= user;
	}


	@Column(name = "INF_PSEUDO", unique = false, nullable = false, length = 100)
	@Override
	public String getPseudo() {
		return pseudo;
	}

	@Override
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;

	}
	@Column(name = "INF_PASSWORD", unique = false, nullable = false, length = 100)
	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public void setPassword(String password) {
		this.password = password;

	}
}
