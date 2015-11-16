package fr.insta.robot.exceptions;

public class FonctionnelleException extends Exception{
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Constructeur fonctionnelle
	 */
	public FonctionnelleException() {
		super();
	}
	/**
	 * Constructeur fonctionnelle avec le message
	 * @param messages le message
	 */
	public FonctionnelleException(final String messages) {
		super(messages);
	}
	
}
