package com.javra.medical.insurance.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javra.medical.insurance.dao.UserDao;
import com.javra.medical.insurance.model.Role;
import com.javra.medical.insurance.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void adduser(User User) {
		sessionFactory.getCurrentSession().saveOrUpdate(User);

	}

	@SuppressWarnings("unchecked")
	public List<User> getAllUser() {

		return sessionFactory.getCurrentSession().createQuery("from User").list();
	}

	@Override
	public void deleteUser(Integer UserId) {
		User User = (User) sessionFactory.getCurrentSession().load(User.class, UserId);
		if (null != User) {
			this.sessionFactory.getCurrentSession().delete(User);
		}

	}

	public User getUser(int UserId) {
		return (User) sessionFactory.getCurrentSession().get(User.class, UserId);
	}

	@Override
	public User updateUser(User User) {
		sessionFactory.getCurrentSession().update(User);
		return User;
	}

	@Override
	public void addRole(Role role) {
		sessionFactory.getCurrentSession().saveOrUpdate(role);
		
	}

	@Override
	public User findByUserName(String username) {
		List<User> users = new ArrayList<User>();

		users = sessionFactory.getCurrentSession()
			.createQuery("from User where AssociateEmail=?")
			.setParameter(0, username)
			.list();

		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}

	}

}