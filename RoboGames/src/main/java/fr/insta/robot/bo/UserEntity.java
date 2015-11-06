package fr.insta.robot.bo;

import java.io.Serializable;

public interface UserEntity extends Serializable {
	
	/**
	 * Retourne l'id
	 * @return l'id
	 */
	Long getId();
	
	/**
	 * Met à jour l'id
	 * @param id l'id
	 */
	void setId(Long id);
	
}
