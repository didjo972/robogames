package fr.insta.robot.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
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
	public UserEntity findById(Long id) {
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

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<UserEntity> findAllUser() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(UserEntityImpl.class);
		return criteria.list();
	}
}
