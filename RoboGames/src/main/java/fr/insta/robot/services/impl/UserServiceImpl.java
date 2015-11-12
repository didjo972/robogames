package fr.insta.robot.services.impl;

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
	public UserEntity findUserById(String id) {
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
	public UserEntity findUserByPseudo(String pseudo) {
		return userDAO.findByPseudo(pseudo);
	}

	@Override
	public UserEntity findUserByEmail(String email) {
		return userDAO.findByEmail(email);
	}

}
