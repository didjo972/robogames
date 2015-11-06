package fr.insta.robot.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.insta.robot.bo.InformationsEntity;
import fr.insta.robot.dao.InformationsDAO;
import fr.insta.robot.entities.InformationsEntityImpl;

@Repository("informationsDAO")
public class InformationsDAOImpl implements InformationsDAO {

	@Autowired private SessionFactory sessionFactory;

	@Override
	@Transactional
	public void persist(InformationsEntity informations) {
		sessionFactory.getCurrentSession().persist(informations);
	}

	@Override
	@Transactional
	public InformationsEntity findById(String id) {
		return (InformationsEntity) sessionFactory.getCurrentSession().get(InformationsEntityImpl.class, id);
	}

	@Override
	@Transactional
	public void update(InformationsEntity informations) {
		sessionFactory.getCurrentSession().update(informations);
	}

	@Override
	@Transactional
	public void delete(InformationsEntity informations) {
		sessionFactory.getCurrentSession().delete(informations);

	}
	
}
