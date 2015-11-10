package fr.insta.robot.exceptions;

public class DonneesInexistantException extends Exception {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructeur le message
	 */
	public DonneesInexistantException() {
		super();
	}

	/**
	 * Constructeur
	 * @param messagesle message
	 */
	public DonneesInexistantException(final String messages) {
		super(messages);
	}

}
