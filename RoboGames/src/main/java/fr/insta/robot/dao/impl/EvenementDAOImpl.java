package fr.insta.robot.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.insta.robot.bo.EvenementEntity;
import fr.insta.robot.dao.EvenementDAO;
import fr.insta.robot.entities.EvenementEntityImpl;

@Repository("evenementDAO")
public class EvenementDAOImpl implements EvenementDAO {

	@Autowired private SessionFactory sessionFactory;

	@Override
	@Transactional
	public void persist(EvenementEntity evenement) {
		sessionFactory.getCurrentSession().persist(evenement);
	}

	@Override
	@Transactional
	public EvenementEntity findById(String id) {
		return (EvenementEntity) sessionFactory.getCurrentSession().get(EvenementEntityImpl.class, id);
	}

	@Override
	@Transactional
	public void update(EvenementEntity evenement) {
		sessionFactory.getCurrentSession().update(evenement);
	}

	@Override
	@Transactional
	public void delete(EvenementEntity evenement) {
		sessionFactory.getCurrentSession().delete(evenement);

	}
	
}
