package fr.insta.robot.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.insta.robot.bo.LiveEntity;
import fr.insta.robot.dao.LiveDAO;
import fr.insta.robot.entities.LiveEntityImpl;

@Repository("liveDAO")
public class LiveDAOImpl implements LiveDAO {

	@Autowired private SessionFactory sessionFactory;

	@Override
	@Transactional
	public void persist(LiveEntity live) {
		sessionFactory.getCurrentSession().persist(live);
	}

	@Override
	@Transactional
	public LiveEntity findById(Long id) {
		return (LiveEntity) sessionFactory.getCurrentSession().get(LiveEntityImpl.class, id);
	}

	@Override
	@Transactional
	public void update(LiveEntity live) {
		sessionFactory.getCurrentSession().update(live);
	}

	@Override
	@Transactional
	public void delete(LiveEntity live) {
		sessionFactory.getCurrentSession().delete(live);

	}
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<LiveEntity> findAllLive() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(LiveEntityImpl.class);
		return criteria.list();
	}
}
