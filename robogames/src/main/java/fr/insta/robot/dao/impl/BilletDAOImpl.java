package fr.insta.robot.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.insta.robot.bo.BilletEntity;
import fr.insta.robot.bo.EvenementEntity;
import fr.insta.robot.bo.UserEntity;
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

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<BilletEntity> findAllBilletByEvenement(EvenementEntity evenement) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(BilletEntityImpl.class);
		criteria.add(Restrictions.eq("evenement", evenement));
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<BilletEntity> findAllBillet() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(BilletEntityImpl.class);
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<BilletEntity> findAllBilletsByUser(UserEntity user) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(BilletEntityImpl.class);
		criteria.add(Restrictions.eq("user", user));
		return criteria.list();
	}

}
