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
	/** email */
	private String email;
	/** image */
	private String image;
	/** Utilisateur */
	private UserEntity user;

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
	@Column(name = "INF_NOM", unique = false, nullable = true, length = 100)
	public String getNom() {
		return nom;
	}

	@Override
	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	@Column(name = "INF_PRENOM", unique = false, nullable = true, length = 100)
	public String getPrenom() {
		return prenom;
	}

	@Override
	public void setPrenom(String prenom) {
		this.prenom = prenom;
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
	@Column(name = "INF_EMAIL", unique = false, nullable = false, length = 100)
	@Override
	public String getEmail() {
		return email;
	}
	@Override
	public void setEmail(String mail) {
		this.email = mail;
	}
	
	@Override
	@Column(name = "INF_IMAGE", unique = false, nullable = true, length = 100)
	public String getImage() {
		return image;
	}
	
	@Override
	public void setImage(String image) {
		this.image = image;
	}
	
	/////////////////////////////////////////////////////////
	@Override
	@OneToOne(targetEntity = UserEntityImpl.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "INF_USER_ID", referencedColumnName="USER_ID")
	public UserEntity getUser() {
		return user;
	}

	@Override
	public void setUser(UserEntity user) {
		this.user= user;
	}
}
