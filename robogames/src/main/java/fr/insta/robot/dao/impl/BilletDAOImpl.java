package fr.insta.robot.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.insta.robot.bo.BilletEntity;
import fr.insta.robot.dao.BilletDAO;
import fr.insta.robot.entities.BilletEntityImpl;

@Repository("billetDAO")
public class BilletDAOImpl implements BilletDAO {
	
	@Autowired private SessionFactory sessionFactory;

	@Override
	@Transactional
	public void persist(BilletEntity billet) {
		sessionFactory.getCurrentSession().persist(billet);
	}

	@Override
	@Transactional
	public BilletEntity findById(Long id) {
		return (BilletEntity) sessionFactory.getCurrentSession().get(BilletEntityImpl.class, id);
	}

	@Override
	@Transactional
	public void update(BilletEntity billet) {
		sessionFactory.getCurrentSession().update(billet);
	}

	@Override
	@Transactional
	public void delete(BilletEntity billet) {
		sessionFactory.getCurrentSession().delete(billet);

	}

}
