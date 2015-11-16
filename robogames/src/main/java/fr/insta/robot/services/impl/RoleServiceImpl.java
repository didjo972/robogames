package fr.insta.robot.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.insta.robot.bo.RoleEntity;
import fr.insta.robot.dao.RoleDAO;
import fr.insta.robot.services.RoleService;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleDAO roleDAO;
	
	@Override
	@Transactional
	public void persistRole(RoleEntity role) {
		roleDAO.persist(role);
	}

	@Override
	@Transactional
	public RoleEntity findRoleById(Long id) {
		return roleDAO.findById(id);
	}

	@Override
	@Transactional
	public void updateRole(RoleEntity role) {
		roleDAO.update(role);
	}

	@Override
	@Transactional
	public void deleteRole(RoleEntity role) {
		roleDAO.delete(role);
	}

}
