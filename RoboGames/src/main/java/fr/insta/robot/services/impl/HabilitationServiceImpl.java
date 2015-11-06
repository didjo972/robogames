package fr.insta.robot.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.insta.robot.bo.HabilitationEntity;
import fr.insta.robot.dao.HabilitationDAO;
import fr.insta.robot.services.HabilitationService;

@Service("habilitationService")
public class HabilitationServiceImpl implements HabilitationService {

	@Autowired
	HabilitationDAO habilitationDAO;
	
	@Override
	@Transactional
	public void persistHabilitation(HabilitationEntity habilitation) {
		habilitationDAO.persist(habilitation);
	}

	@Override
	public HabilitationEntity findHabilitationById(String id) {
		return habilitationDAO.findById(id);
	}

	@Override
	public void updateHabilitation(HabilitationEntity habilitation) {
		habilitationDAO.update(habilitation);
	}

	@Override
	public void deleteHabilitation(HabilitationEntity habilitation) {
		habilitationDAO.delete(habilitation);
	}

}
