package fr.insta.robot.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.insta.robot.bo.BilletEntity;
import fr.insta.robot.bo.EvenementEntity;
import fr.insta.robot.bo.UserEntity;
import fr.insta.robot.dao.BilletDAO;
import fr.insta.robot.services.BilletService;

@Service("billetService")
public class BilletServiceImpl implements BilletService {

	@Autowired
	BilletDAO billetDAO;
	
	@Override
	@Transactional
	public void persistBillet(BilletEntity billet) {
		billetDAO.persist(billet);
	}

	@Override
	@Transactional
	public BilletEntity findBilletById(Long id) {
		return billetDAO.findById(id);
	}

	@Override
	@Transactional
	public void updateBillet(BilletEntity billet) {
		billetDAO.update(billet);
	}

	@Override
	@Transactional
	public void deleteBillet(BilletEntity billet) {
		billetDAO.delete(billet);
	}

	@Override
	@Transactional
	public List<BilletEntity> findAllBillets() {
		return billetDAO.findAllBillet();
	}

	@Override
	@Transactional
	public List<BilletEntity> findAllBilletsByUser(UserEntity user) {
		return billetDAO.findAllBilletsByUser(user);
	}

	@Override
	@Transactional
	public List<BilletEntity> findAllBilletsByEvenement(EvenementEntity evenement) {
		return billetDAO.findAllBilletByEvenement(evenement);
	}

}
