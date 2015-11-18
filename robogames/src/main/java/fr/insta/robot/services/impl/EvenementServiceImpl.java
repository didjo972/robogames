package fr.insta.robot.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.insta.robot.bo.EvenementEntity;
import fr.insta.robot.bo.UserEntity;
import fr.insta.robot.dao.EvenementDAO;
import fr.insta.robot.services.EvenementService;

@Service("evenementService")
public class EvenementServiceImpl implements EvenementService {

	@Autowired
	EvenementDAO evenementDAO;
	
	@Override
	@Transactional
	public void persistEvenement(EvenementEntity evenement) {
		evenementDAO.persist(evenement);
	}

	@Override
	@Transactional
	public EvenementEntity findEvenementById(Long id) {
		return evenementDAO.findById(id);
	}

	@Override
	@Transactional
	public void updateEvenement(EvenementEntity evenement) {
		evenementDAO.update(evenement);
	}

	@Override
	@Transactional
	public void deleteEvenement(EvenementEntity evenement) {
		evenementDAO.delete(evenement);
	}

	@Override
	@Transactional
	public EvenementEntity findEvenementByName(String nom) {
		return evenementDAO.findByName(nom);
	}

	@Override
	@Transactional
	public List<EvenementEntity> findAllEvenement() {
		return evenementDAO.findAll();
	}

	@Override
	@Transactional
	public List<EvenementEntity> findAllEventByUser(UserEntity user) {
		return evenementDAO.findByUser(user);
	}
	
	


}
