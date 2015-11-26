package fr.insta.robot.bo;

public class BilletterieDTO {

	/** Le prénom */
	private String prenom;
	
	/** Le nom */
	private String nom;
	
	/** Le pseudo */
	private String pseudo;
	
	/** L'id de l'utilisateur */
	private String idUser;
	
	/** L'id de l'evenement */
	private String idEvent;
	
	/** Le nom de l'évènement */
	private String nomEvent;
	
	/** Le nombre de place total */
	private int nbPlace;
	
	/** Le nombre de place restant */
	private int nbPlaceRestant;
	
	/** Le prix de l'évènement */
	private int prix;

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
	 * @return the idUser
	 */
	public String getIdUser() {
		return idUser;
	}

	/**
	 * @param idUser the idUser to set
	 */
	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	/**
	 * @return the idEvent
	 */
	public String getIdEvent() {
		return idEvent;
	}

	/**
	 * @param idEvent the idEvent to set
	 */
	public void setIdEvent(String idEvent) {
		this.idEvent = idEvent;
	}

	/**
	 * @return the nomEvent
	 */
	public String getNomEvent() {
		return nomEvent;
	}

	/**
	 * @param nomEvent the nomEvent to set
	 */
	public void setNomEvent(String nomEvent) {
		this.nomEvent = nomEvent;
	}

	/**
	 * @return the nbPlace
	 */
	public int getNbPlace() {
		return nbPlace;
	}

	/**
	 * @param nbPlace the nbPlace to set
	 */
	public void setNbPlace(int nbPlace) {
		this.nbPlace = nbPlace;
	}

	/**
	 * @return the nbPlaceRestant
	 */
	public int getNbPlaceRestant() {
		return nbPlaceRestant;
	}

	/**
	 * @param nbPlaceRestant the nbPlaceRestant to set
	 */
	public void setNbPlaceRestant(int nbPlaceRestant) {
		this.nbPlaceRestant = nbPlaceRestant;
	}

	/**
	 * @return the prix
	 */
	public int getPrix() {
		return prix;
	}

	/**
	 * @param prix the prix to set
	 */
	public void setPrix(int prix) {
		this.prix = prix;
	}
	
}
