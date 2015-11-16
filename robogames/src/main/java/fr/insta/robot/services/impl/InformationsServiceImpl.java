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
	@Transactional
	public InformationsEntity findInformationsById(Long id) {
		return informationsDAO.findById(id);
	}

	@Override
	@Transactional
	public void updateInformations(InformationsEntity informations) {
		informationsDAO.update(informations);
	}

	@Override
	@Transactional
	public void deleteInformations(InformationsEntity informations) {
		informationsDAO.delete(informations);
	}

	@Override
	@Transactional
	public InformationsEntity findInformationsByPseudo(String pseudo) {
		return informationsDAO.findByPseudo(pseudo);
	}

	@Override
	@Transactional
	public InformationsEntity findInformationsByEmail(String email) {
		return informationsDAO.findByEmail(email);
	}

}
