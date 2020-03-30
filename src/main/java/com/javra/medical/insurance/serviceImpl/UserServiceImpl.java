package com.javra.medical.insurance.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javra.medical.insurance.dao.UserDao;
import com.javra.medical.insurance.model.Role;
import com.javra.medical.insurance.model.User;
import com.javra.medical.insurance.service.UserService;
@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao UserDAO;

	@Override
	public void adduser(User User) {
		UserDAO.adduser(User);

	}

	@Override
	public List<User> getAllUser() {
		return UserDAO.getAllUser();
	}

	@Override
	public void deleteUser(Integer UserId) {
		UserDAO.deleteUser(UserId);
	}

	@Override
	public User getUser(int UserId) {
		return UserDAO.getUser(UserId);
	}

	@Override
	public User updateUser(User User) {
		return UserDAO.updateUser(User);
	}

	@Override
	public void addRole(Role role) {
		 UserDAO.addRole(role);
		
	}

	@Override
	public User findByUserName(String username) {
		 return UserDAO.findByUserName(username);
	}

}
