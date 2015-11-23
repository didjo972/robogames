package fr.insta.robot.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.insta.robot.bo.UserEntity;
import fr.insta.robot.dao.UserDAO;
import fr.insta.robot.services.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDAO;

	@Override
	@Transactional
	public void persistUser(UserEntity user) {
		userDAO.persist(user);
	}

	@Override
	@Transactional
	public UserEntity findUserById(Long id) {
		return userDAO.findById(id);
	}

	@Override
	@Transactional
	public void updateUser(UserEntity user) {
		userDAO.update(user);
	}

	@Override
	@Transactional
	public void deleteUser(UserEntity user) {
		userDAO.delete(user);
	}

	@Override
	@Transactional
	public List<UserEntity> findAllUser() {
		return userDAO.findAllUser();
	}

	@Override
	public List<UserEntity> findAllUserByType(String typeRole) {
		List<UserEntity> listUser = userDAO.findAllUser();
		List<UserEntity> listAdmin = new ArrayList<UserEntity>();
		for (UserEntity user : listUser) {
			if (user.getHabilitation().getRole().getLibelle().equalsIgnoreCase(typeRole)) {
				listAdmin.add(user);
			}
		}
		 
		 return listAdmin;
	}


}
