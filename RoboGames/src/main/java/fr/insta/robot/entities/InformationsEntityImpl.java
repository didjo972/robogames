package fr.insta.robot.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	
	@JoinColumn(name = "INF_USER_ID")
	@Override
	public UserEntity getUser() {
		return user;
	}

	@Override
	public void setUser(UserEntity user) {
		this.user = user;
	}

}
