package fr.insta.robot.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.insta.robot.bo.InformationsEntity;
import fr.insta.robot.dao.InformationsDAO;
import fr.insta.robot.services.InformationsService;

@Service("informationsService")
public class InformationsServiceImpl implements InformationsService {

	@Autowired
	InformationsDAO informationsDAO;
	
	@Override
	@Transactional
	public void persistInformations(InformationsEntity informations) {
		informationsDAO.persist(informations);
	}

	@Override
	public InformationsEntity findInformationsById(String id) {
		return informationsDAO.findById(id);
	}

	@Override
	public void updateInformations(InformationsEntity informations) {
		informationsDAO.update(informations);
	}

	@Override
	public void deleteInformations(InformationsEntity informations) {
		informationsDAO.delete(informations);
	}

}
