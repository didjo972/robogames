package fr.insta.robot.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.insta.robot.bo.EvenementEntity;
import fr.insta.robot.bo.UserEntity;
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
	public EvenementEntity findById(Long id) {
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

	@Override
	@Transactional
	public EvenementEntity findByName(String nom) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(EvenementEntityImpl.class);
		criteria.add(Restrictions.eq("nom", nom));
		return (EvenementEntity) criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<EvenementEntity> findAll() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(EvenementEntityImpl.class);
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<EvenementEntity> findByUser(UserEntity user) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(EvenementEntityImpl.class);
		criteria.add(Restrictions.eq("user", user));
		return criteria.list();
	}
	
	
}
