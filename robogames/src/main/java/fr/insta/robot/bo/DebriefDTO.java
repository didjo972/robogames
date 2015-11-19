package fr.insta.robot.bo;

public class DebriefDTO {
	
	/** Le débriefing */
	private String debriefing;
	
	/** L'évènement concerné */
	private EvenementDTO evenement;

	/**
	 * @return the debriefing
	 */
	public String getDebriefing() {
		return debriefing;
	}

	/**
	 * @param debriefing the debriefing to set
	 */
	public void setDebriefing(String debriefing) {
		this.debriefing = debriefing;
	}

	/**
	 * @return the evenement
	 */
	public EvenementDTO getEvenement() {
		return evenement;
	}

	/**
	 * @param evenement the evenement to set
	 */
	public void setEvenement(EvenementDTO evenement) {
		this.evenement = evenement;
	}
	
}
