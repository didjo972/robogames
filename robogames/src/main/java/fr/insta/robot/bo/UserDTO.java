package fr.insta.robot.bo;

public class UserDTO {
	
	/** L'id */
	private Long idUser;

	/** Nom */
	private String nom;
	
	/** Prénom */
	private String prenom;
	
	/** Pseudo */
	private String pseudo;
	
	/** Etat */
	private String etat;
	
	/** Libellé habilitation */
	private String libelleHabilitation;
	
	/** Date inscription */
	private String dateInscription;

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the pseudo
	 */
	public String getPseudo() {
		return pseudo;
	}

	/**
	 * @param pseudo the pseudo to set
	 */
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	/**
	 * @return the etat
	 */
	public String getEtat() {
		return etat;
	}

	/**
	 * @param etat the etat to set
	 */
	public void setEtat(String etat) {
		this.etat = etat;
	}

	/**
	 * @return the libelleHabilitation
	 */
	public String getLibelleHabilitation() {
		return libelleHabilitation;
	}

	/**
	 * @param libelleHabilitation the libelleHabilitation to set
	 */
	public void setLibelleHabilitation(String libelleHabilitation) {
		this.libelleHabilitation = libelleHabilitation;
	}

	/**
	 * @return the idUser
	 */
	public Long getIdUser() {
		return idUser;
	}

	/**
	 * @param idUser the idUser to set
	 */
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	/**
	 * @return the dateInscription
	 */
	public String getDateInscription() {
		return dateInscription;
	}

	/**
	 * @param dateInscription the dateInscription to set
	 */
	public void setDateInscription(String dateInscription) {
		this.dateInscription = dateInscription;
	}
	
}
