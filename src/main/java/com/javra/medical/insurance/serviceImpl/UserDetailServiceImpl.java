package com.javra.medical.insurance.serviceImpl;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.javra.medical.insurance.model.Role;
import com.javra.medical.insurance.service.UserService;
@Service
public class UserDetailServiceImpl implements UserDetailsService {
	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {

		System.out.println("spring role based security is enabled" + username );
		
		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);
		

		com.javra.medical.insurance.model.User user = userService.findByUserName(username);

		return (UserDetails) buildUserForAuthentication(user, Result);

	}

	private User buildUserForAuthentication(com.javra.medical.insurance.model.User user,
			List<GrantedAuthority> authorities) {
		return new User(user.getAssociateEmail(), user.getPassword(), true, true, true, true, authorities);
	}

	private List<GrantedAuthority> buildUserAuthority(Set<Role> userRoles) {

		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

		// Build user's authorities
		for (Role userRole : userRoles) {
			setAuths.add(new SimpleGrantedAuthority(userRole.getRoletype()));
		}

		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

		return Result;
	}

}
