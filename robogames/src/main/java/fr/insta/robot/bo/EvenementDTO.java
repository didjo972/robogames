package fr.insta.robot.bo;


public class EvenementDTO {

	/** L'id */
	private String idEvent;
	
	/** Le nom de l'évènement */
	private String nomEvent;

	/** La date de début */
	private String dateDebut;
	
	/** La date de fin */
	private String dateFin;
	
	/** L'adresse */
	private String adresse;
	
	/** Le code Posta */
	private int codePostal;
	
	/** La ville */
	private String ville;
	
	/** Le nombre de place */
	private int nbPlace;
	
	/** Le nombre de place restante */
	private int nbPlaceRestant;
	
	/** Le prix */
	private int prix;
	
	/** L'état */
	private boolean etat;
	
	/** Les infos supplémentaires */
	private String infos;
	
	/** La validité de l'évènement */
	private boolean valide;
	
	/** L'utilisateur qui a créé l'évènement */
	private String idUser;
	
	/** Le débriefing */
	private String debrief;

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
	 * @return the dateDebut
	 */
	public String getDateDebut() {
		return dateDebut;
	}

	/**
	 * @param dateDebut the dateDebut to set
	 */
	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}

	/**
	 * @return the dateFin
	 */
	public String getDateFin() {
		return dateFin;
	}

	/**
	 * @param dateFin the dateFin to set
	 */
	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}

	/**
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/**
	 * @return the codePostal
	 */
	public int getCodePostal() {
		return codePostal;
	}

	/**
	 * @param codePostal the codePostal to set
	 */
	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	/**
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}

	/**
	 * @param ville the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
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

	/**
	 * @return the etat
	 */
	public boolean isEtat() {
		return etat;
	}

	/**
	 * @param etat the etat to set
	 */
	public void setEtat(boolean etat) {
		this.etat = etat;
	}

	/**
	 * @return the infos
	 */
	public String getInfos() {
		return infos;
	}

	/**
	 * @param infos the infos to set
	 */
	public void setInfos(String infos) {
		this.infos = infos;
	}

	/**
	 * @return the valide
	 */
	public boolean isValide() {
		return valide;
	}

	/**
	 * @param valide the valide to set
	 */
	public void setValide(boolean valide) {
		this.valide = valide;
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
	 * @return the debrief
	 */
	public String getDebrief() {
		return debrief;
	}

	/**
	 * @param debrief the debrief to set
	 */
	public void setDebrief(String debrief) {
		this.debrief = debrief;
	}
	
}
