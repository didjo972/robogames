package fr.insta.robot.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.insta.robot.bo.LiveEntity;
import fr.insta.robot.dao.LiveDAO;
import fr.insta.robot.services.LiveService;

@Service("liveService")
public class LiveServiceImpl implements LiveService {

	@Autowired
	LiveDAO liveDAO;
	
	@Override
	@Transactional
	public void persistLive(LiveEntity live) {
		liveDAO.persist(live);
	}

	@Override
	@Transactional
	public LiveEntity findLiveById(Long id) {
		return liveDAO.findById(id);
	}

	@Override
	@Transactional
	public void updateLive(LiveEntity live) {
		liveDAO.update(live);
	}

	@Override
	@Transactional
	public void deleteLive(LiveEntity live) {
		liveDAO.delete(live);
	}

	@Override
	@Transactional
	public LiveEntity findLive() {
		return liveDAO.findLive();
	}
}
