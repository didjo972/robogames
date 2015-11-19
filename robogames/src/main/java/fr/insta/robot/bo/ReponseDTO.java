package fr.insta.robot.bo;

public class ReponseDTO {

	/** Un Object */
	private Object object;
	
	/** Le message et le code retour */
	private RetourDTO retour;

	/**
	 * @return the object
	 */
	public Object getObject() {
		return object;
	}

	/**
	 * @param object the object to set
	 */
	public void setObject(Object object) {
		this.object = object;
	}

	/**
	 * @return the retour
	 */
	public RetourDTO getRetour() {
		return retour;
	}

	/**
	 * @param retour the retour to set
	 */
	public void setRetour(RetourDTO retour) {
		this.retour = retour;
	}
	
}
