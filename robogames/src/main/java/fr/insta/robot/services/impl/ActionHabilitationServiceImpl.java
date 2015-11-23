package fr.insta.robot.services.impl;

import java.util.List;

import fr.insta.robot.bo.HabilitationEntity;
import fr.insta.robot.services.ActionHabilitationService;
import fr.insta.robot.services.HabilitationService;
import fr.insta.robot.services.RGServiceFactory;

public class ActionHabilitationServiceImpl implements ActionHabilitationService {
	
	public ActionHabilitationServiceImpl() {

	}

	@Override
	public List<HabilitationEntity> findAll() {
		HabilitationService habilitationService = RGServiceFactory.getInstance().getHabilitationService();
		return habilitationService.findAll();
	}

}
