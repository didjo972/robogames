package fr.insta.robot.services.impl;

import java.util.List;

import fr.insta.robot.bo.BilletEntity;
import fr.insta.robot.bo.EvenementEntity;
import fr.insta.robot.bo.UserEntity;
import fr.insta.robot.entities.BilletEntityImpl;
import fr.insta.robot.exceptions.FonctionnelleException;
import fr.insta.robot.services.ActionBilletService;
import fr.insta.robot.services.BilletService;
import fr.insta.robot.services.RGServiceFactory;
import fr.insta.robot.services.RoleConstantService;

public class ActionBilletServiceImpl implements ActionBilletService{

	@Override
	public BilletEntity createBillet(UserEntity user, EvenementEntity evenement) throws FonctionnelleException {
		List<BilletEntity> billets = findAllbilletsByEvenement(evenement);
		int nbBilletRestant = evenement.getNbPlace() - billets.size();
		
		if(nbBilletRestant > 0){
			//Creation d'un billet
			BilletEntity billet = new BilletEntityImpl();
			billet.setUser(user);
			billet.setEvenement(evenement);
			//Ajout dans user et evenement le billet
			user.addBillets(billet);
			evenement.addBillets(billet);
			//Persiste le billet
			BilletService billetService = RGServiceFactory.getInstance().getBilletService();
			billetService.persistBillet(billet);
			return billet;
		}
		else{
			throw new FonctionnelleException("Erreur, plus de billets disponible.");
		}
		
		
		
	}
	@Override
	public List<BilletEntity> findAllBillets(UserEntity admin) throws FonctionnelleException {
		if(admin.getHabilitation().getRole().getLibelle().equals(RoleConstantService.ADMIN)){
		BilletService billetService = RGServiceFactory.getInstance().getBilletService();
		return billetService.findAllBillets();
		}
		else{
			throw new FonctionnelleException("Erreur, votre compte n'est pas eligible.");
		}
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
	@Override
	public BilletEntity findById(Long id){
		BilletService billetService = RGServiceFactory.getInstance().getBilletService();
		return billetService.findBilletById(id);
	}
	
	
}
