package fr.insta.robot.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.insta.robot.bo.UserEntity;
import fr.insta.robot.dao.UserDAO;
import fr.insta.robot.entities.UserEntityImpl;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {
	
	@Autowired private SessionFactory sessionFactory;

	@Override
	@Transactional
	public void persist(UserEntity user) {
		sessionFactory.getCurrentSession().persist(user);
	}

	@Override
	@Transactional
	public UserEntity findById(String id) {
		return (UserEntity) sessionFactory.getCurrentSession().get(UserEntityImpl.class, id);
	}

	@Override
	@Transactional
	public void update(UserEntity user) {
		sessionFactory.getCurrentSession().update(user);
	}

	@Override
	@Transactional
	public void delete(UserEntity user) {
		sessionFactory.getCurrentSession().delete(user);

	}

	@Override
	@Transactional
	public UserEntity findByPseudo(String pseudo) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(UserEntityImpl.class);
		criteria.add(Restrictions.eq("pseudo", pseudo));
		return (UserEntity) criteria.uniqueResult();
	}

	@Override
	@Transactional
	public UserEntity findByEmail(String email) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(UserEntityImpl.class);
		criteria.add(Restrictions.eq("email", email));
		return (UserEntity) criteria.uniqueResult();
	}
	
	

}
