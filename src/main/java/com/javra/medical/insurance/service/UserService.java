package com.javra.medical.insurance.service;

import java.util.List;

import com.javra.medical.insurance.model.Role;
import com.javra.medical.insurance.model.User;

public interface UserService {

	public void adduser(User User);
	
	public List<User> getAllUser();

	public void deleteUser(Integer userId);

	public User getUser(int userId);

	public User updateUser(User User);
	public void addRole(Role role);
	public User findByUserName(String username);

	

}
