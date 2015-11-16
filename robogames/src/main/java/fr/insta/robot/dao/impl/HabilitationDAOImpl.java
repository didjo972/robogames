package fr.insta.robot.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.insta.robot.bo.HabilitationEntity;
import fr.insta.robot.dao.HabilitationDAO;
import fr.insta.robot.entities.HabilitationEntityImpl;

@Repository("habilitationDAO")
public class HabilitationDAOImpl implements HabilitationDAO {

	@Autowired private SessionFactory sessionFactory;

	@Override
	@Transactional
	public void persist(HabilitationEntity habilitation) {
		sessionFactory.getCurrentSession().persist(habilitation);
	}

	@Override
	@Transactional
	public HabilitationEntity findById(Long id) {
		return (HabilitationEntity) sessionFactory.getCurrentSession().get(HabilitationEntityImpl.class, id);
	}

	@Override
	@Transactional
	public void update(HabilitationEntity habilitation) {
		sessionFactory.getCurrentSession().update(habilitation);
	}

	@Override
	@Transactional
	public void delete(HabilitationEntity habilitation) {
		sessionFactory.getCurrentSession().delete(habilitation);

	}
	
}
