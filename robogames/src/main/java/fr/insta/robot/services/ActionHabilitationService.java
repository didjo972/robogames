package fr.insta.robot.services;

import java.util.List;

import fr.insta.robot.bo.HabilitationEntity;

public interface ActionHabilitationService {

	/**
	 * Retour une liste d'habilitation
	 * @return une liste d'habilitation
	 */
	List<HabilitationEntity> findAll();
	
}
