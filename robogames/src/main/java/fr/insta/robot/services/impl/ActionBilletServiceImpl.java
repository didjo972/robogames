package fr.insta.robot.services.impl;

import java.util.List;

import fr.insta.robot.bo.BilletEntity;
import fr.insta.robot.bo.EvenementEntity;
import fr.insta.robot.bo.UserEntity;
import fr.insta.robot.services.ActionBilletService;
import fr.insta.robot.services.BilletService;
import fr.insta.robot.services.RGServiceFactory;

public class ActionBilletServiceImpl implements ActionBilletService{

	@Override
	public void createBillet(UserEntity user, EvenementEntity evenement) {
		List<BilletEntity> billets = findAllbilletsByEvenement(evenement);
		
	}
	@Override
	public List<BilletEntity> findAllBillets(UserEntity admin) {
		BilletService billetService = RGServiceFactory.getInstance().getBilletService();
		return billetService.findAllBillets();
		
	}
	@Override
	public List<BilletEntity> findAllbilletsByUser(UserEntity user){
		BilletService billetService = RGServiceFactory.getInstance().getBilletService();
		return billetService.findAllBilletsByUser(user);
	}
	@Override
	public List<BilletEntity> findAllbilletsByEvenement(EvenementEntity evenement){
		BilletService billetService = RGServiceFactory.getInstance().getBilletService();
		return billetService.findAllBilletsByEvenement(evenement);
	}
}
