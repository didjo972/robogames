package fr.insta.robot.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.insta.robot.bo.DebriefEntity;
import fr.insta.robot.dao.DebriefDAO;
import fr.insta.robot.services.DebriefService;

@Service("debriefService")
public class DebriefServiceImpl implements DebriefService {

	@Autowired
	DebriefDAO debriefDAO;

	@Override
	@Transactional
	public void persistDebrief(DebriefEntity debrief) {
		debriefDAO.persist(debrief);

	}

	@Override
	@Transactional
	public DebriefEntity findDebriefById(Long id) {
		return debriefDAO.findById(id);
	}

	@Override
	@Transactional
	public void updateDebrief(DebriefEntity debrief) {
		debriefDAO.update(debrief);
	}

	@Override
	@Transactional
	public void deleteDebrief(DebriefEntity debrief) {
		debriefDAO.delete(debrief);
	}

}
