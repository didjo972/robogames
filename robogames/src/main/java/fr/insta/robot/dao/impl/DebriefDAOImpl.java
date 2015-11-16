package fr.insta.robot.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import fr.insta.robot.bo.DebriefEntity;
import fr.insta.robot.dao.DebriefDAO;
import fr.insta.robot.entities.DebriefEntityImpl;

@Repository("debriefDAO")
public class DebriefDAOImpl implements DebriefDAO {
	
	@Autowired private SessionFactory sessionFactory;

	@Override
	@Transactional
	public void persist(DebriefEntity debrief) {
		sessionFactory.getCurrentSession().persist(debrief);

	}

	@Override
	@Transactional
	public DebriefEntity findById(Long id) {
		return (DebriefEntity) sessionFactory.getCurrentSession().get(DebriefEntityImpl.class, id);
	}

	@Override
	@Transactional
	public void update(DebriefEntity debrief) {
		sessionFactory.getCurrentSession().update(debrief);

	}

	@Override
	@Transactional
	public void delete(DebriefEntity debrief) {
		sessionFactory.getCurrentSession().delete(debrief);
	}

}
