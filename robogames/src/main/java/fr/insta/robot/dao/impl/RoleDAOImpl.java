package fr.insta.robot.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.insta.robot.bo.RoleEntity;
import fr.insta.robot.dao.RoleDAO;
import fr.insta.robot.entities.RoleEntityImpl;

@Repository("roleDAO")
public class RoleDAOImpl implements RoleDAO {

	@Autowired private SessionFactory sessionFactory;

	@Override
	@Transactional
	public void persist(RoleEntity role) {
		sessionFactory.getCurrentSession().persist(role);
	}

	@Override
	@Transactional
	public RoleEntity findById(Long id) {
		return (RoleEntity) sessionFactory.getCurrentSession().get(RoleEntityImpl.class, id);
	}

	@Override
	@Transactional
	public void update(RoleEntity role) {
		sessionFactory.getCurrentSession().update(role);
	}

	@Override
	@Transactional
	public void delete(RoleEntity role) {
		sessionFactory.getCurrentSession().delete(role);

	}
	
}
