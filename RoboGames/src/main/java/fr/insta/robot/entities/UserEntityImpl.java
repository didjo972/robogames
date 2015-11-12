package fr.insta.robot.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import fr.insta.robot.bo.UserEntity;

@Entity
@Table(name = "RG_USER")
public class UserEntityImpl implements UserEntity {

	/** serialVersionUID **/
	private static final long serialVersionUID = 1L;

	/** L'Id */
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
	/** etat */

	private boolean etat;
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
	@Column(name = "USER_NOM", unique = false, nullable = false, length = 100)
	public String getNom() {
		return nom;
	}

	@Override
	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	@Column(name = "USER_PRENOM", unique = false, nullable = false, length = 100)
	public String getPrenom() {
		return prenom;
	}

	@Override
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Column(name = "USER_PSEUDO", unique = true, nullable = false, length = 100)
	@Override
	public String getPseudo() {
		return pseudo;
	}

	@Override
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;

	}
	@Column(name = "USER_PASSWORD", unique = false, nullable = false, length = 100)
	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public void setPassword(String password) {
		this.password = password;

	}

	@Override
	@Column(name = "USER_EMAIL", unique = true, nullable = false, length = 100)
	public String getEmail() {
		return email;
	}

	@Override
	public void setEmail(String email) {
		this.email = email;
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
	
}
